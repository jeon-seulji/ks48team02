/* main rank ajax code */
function rankAjax(param, callback){
    const request = $.ajax({
        url: '/user/ajax/rankCategory',
        method : 'POST',
        data : {"rankCategory" : param},
        dataType: 'json'
    })
    request.done(function(list){
        callback(list);
    });
    request.fail(function(err){
        console.log(err);
    })
}
// reload button click ajax
$('#rankReload').on('click', function(){
    rankAjax('achievementPercent', function(list){
        // console.log(list);
        $(`.main-rank-area`).addClass('active');
        $(`.main-rank-area ul li`).remove();

        $(list).each((idx, item) => {
            // append 로 수정해보기
            let listElement = "";
            listElement += "<li>";
            listElement += `	<a href='/user/donation/detail?projectCode=${item.projectCode}'>`;
            listElement += `      <em>${item.rankCount}</em>`;
            listElement += `      <div>`;
            listElement += `        <h5>${item.subject}</h5>`;
            listElement += "        <div class='product-detail-info'>";
            listElement += "			<p class='funding-percent'><span>"+item.achievementPercent+"</span>%</p>";
            listElement += "          	<p class='category'>";
            listElement += (item.categoryName == '')?"<span>카테고리 없음</span>":"<span>"+item.categoryName+"</span>";
            listElement += "            ·" ;
            listElement += "            <span>"+item.projectType+"</span>";
            listElement += "          	</p>";
            listElement += "        </div>";
            listElement += "        </div>";
            listElement += "      <div class='project-img' style=";
            listElement += (item.imageUrl == null)? "'background:#eee;'>": `'background:url("${item.imageUrl}") no-repeat center center / cover'`;
            listElement += "      </div>";
            listElement += "    </a>";
            listElement += "</li>";
            console.log(listElement);

            $(`.main-rank-area ul`).append(listElement);

        });
    })

    $('.tab-menu-btn li').removeClass('active');
    $('.tab-menu-btn li:first-child').addClass('active');
});


// admin orderList ajax
function adminOrderListAjax(orderby, currentPage, rowPerPage, callback){
    const request = $.ajax({
        url: '/admin/order/ajax/list',
        method : 'POST',
        data : {"orderby" : orderby, "currentPage" : currentPage, "rowPerPage" : rowPerPage},
        dataType: 'json'
    })
    request.done(function(list){
        // console.log(list, '<--');
        callback(list);
    });
    request.fail(function(err){
        console.log(err);
    });
}
// order data setting
function setOrderData(list){
    // add ajax contents
    $('#orderListForm tbody').remove();
    $('#orderListForm table').append('<tbody></tbody>');
    if (list.length == 0) {
        $('#orderListForm tbody').append(`<tr>
                                             <td colspan="10" style="text-align: center; padding: 30px 0;">검색 결과가 없습니다.</td>
                                          </tr>`);
    }
    $(list).each((idx, l) => {
        $('#orderListForm tbody').append(`<tr></tr>`)
            .append(
                `<td class="table-data-center">
                    <input type="checkbox" name="selectList">
                 </td>`
            )
            .append(
                `<td class="table-data-center">
                    <a title="${l.orderCode}" class="detail-link" href="/admin/order/detail?orderCode=${l.orderCode}&goodsPartition=${l.goodsPartition}">${l.orderCode}</a>
                 </td>`
            )
            .append(
                `<td title="${l.orderApplicationDate}" class="table-data-center">
                    ${l.orderApplicationDate}
                 </td>`
            )
            .append(
                `<td class="table-data-center">
                    <span>${l.goodsPartition === 'rwd' ? '리워드' : (l.goodsPartition === 'don' ? '기부' : '투자')}</span>
                </td>`
            )
            .append(
                `<td title="${l.orderFundingName}" class="table-data-center">
                    ${l.orderFundingName}
                </td>`
            )
            .append(
                `<td title="${l.orderCategoryDetail}">
                    ${l.orderCategoryDetail}
                </td>`
            )
            .append(
                `<td class="table-data-center">
                    ${l.orderName}
                </td>`
            )
            .append(
                `<td  class="table-data-center">
                    <input type="hidden" name="orderPrice" value="${l.orderTotalPrice}">
                    <span class="order-pay">0</span> 원
                </td>`
            )
            .append(
                `<td class="table-data-center">
                    ${l.orderConfirmDate == null? '-':l.orderConfirmDate}
                </td>`
            )
            .append(
                `<td class="table-data-center">
                    ${l.orderCancellDate == null? '-':l.orderCancellDate}
                </td>`
            )

    });


    let priceEls = $('input[name="orderPrice"]');
    payFormat(priceEls);
}

// pager setting
function setPagerData(arr, currentPage, list){
    console.log(list, '<--list');
    let lastPage = list.lastPage;
    let startPageNum = list.startPageNum;
    $('.list-btn-area button').removeClass('no-action');

    if(currentPage == startPageNum) {
        $('.prev-transfer').addClass('no-action');
    }
    if(currentPage == lastPage){
        $('.next-transfer').addClass('no-action');
    }

    $('.order-list-pager li').remove();
    $(arr).each((idx, item) => {
        let classArr = [];
        if(item == currentPage) {
            classArr.push('link-active');
            classArr.push('currentPage');
        }
        if(item == startPageNum) classArr.push('startPageNum');
        if(item == lastPage) classArr.push('lastPage');

        // console.log(classArr, '<-- classArr');
        $('.order-list-pager').append(`<li class="${classArr.join(' ')}"><a data-value="${item}">${item}</a></li>`);
    });
}

// select 옵션 선택 ajax
$('select[name="orderby"], select[name="count-select"]').on('change',function(){
    $('#allSelectBtn').prop('checked', false);
    let orderbyValue = $('select[name="orderby"]').val();

    $('.select-list-count').text('0');

    // page value
    let currentPage = 1;
    let rowPerPage = $('select[name="count-select"]').val();


    // ajax 호출
    adminOrderListAjax(orderbyValue, currentPage, rowPerPage, function(list) {
        // list count
        $('.total-list').text(list.orderList.length);
        setOrderData(list.orderList);

        // pager setting
        const pageNumArr = Array((list.endPageNum - list.startPageNum) + 1).fill().map((item, idx) => list.startPageNum + idx);
        setPagerData(pageNumArr, list.currentPage, list);

    });
});

// 페이징 ajax
$(document).on('click', '.order-list-pager a',function(e){
    let pageNumber = $(e.target).attr('data-value');
    let orderbyValue = $('select[name="orderby"]').val();
    let rowPerPage = $('select[name="count-select"]').val();
    // ajax 호출
    adminOrderListAjax(orderbyValue, pageNumber, rowPerPage, function(list){
        // list count
        $('.total-list').text(list.orderList.length);
        setOrderData(list.orderList);

        // pager setting
        const pageNumArr = Array((list.endPageNum - list.startPageNum) + 1).fill().map((item, idx) => list.startPageNum + idx);
        setPagerData(pageNumArr, list.currentPage, list);
    });
});

// prev, next click ajax
$(document).on('click', '.list-btn-area button', function(e){
    let validation = $(e.target).closest('button').hasClass('no-action');

    if(validation){
        let value = $(e.target).text();
        alert(`${(value == 'prev')? '첫 번째':'마지막' } 페이지 입니다.`);
        return;
    }

    const $orderListLi = $('.order-list-pager li');
    let currentPage;

    // current Page Number Validation
     $($orderListLi).each((idx, element) => {
        let validation = $(element).hasClass('currentPage');
        if(validation) {
            currentPage = $(element).text();
            return;
        }
    });

    // ajax 호출
    let orderbyValue = $('select[name="orderby"]').val();
    let rowPerPage = $('select[name="count-select"]').val();

    // page number array
    const numberArr = $.map($orderListLi, function(element, idx){
        return $(element).find('a').text();
    });

    if($(e.target).parent().hasClass('prev-transfer')){
        currentPage--;
    } else if($(e.target).parent().hasClass('next-transfer')){
        currentPage++;
    }

    adminOrderListAjax(orderbyValue, currentPage, rowPerPage, function(list) {
        // list count
        $('.total-list').text(list.orderList.length);
        setOrderData(list.orderList);

        // pager setting
        setPagerData(numberArr, currentPage, list);

    });



});
// order search ajax
function orderSearchAjax(queryString, callback){
    const request = $.ajax({
        url: '/admin/order/ajax/search',
        method : 'POST',
        data : queryString,
        contentType: 'application/json',
        dataType: 'json'
    })
    request.done(function(list){
        // console.log(list, '<--');
        callback(list);
    });
    request.fail(function(err){
        console.log(err);
    });
}

$('.orderSearchBtn').on('click', function(){
    console.log('aa');
    const $inputEls = $('.order-category-select input:checked');
    console.log($inputEls);
    const arr = [];
    $($inputEls).each((idx, item) => {
        let checkBoxValue = $(item).attr('name');
        arr.push(checkBoxValue);
    });
    console.log(arr, '<--arr');

    let userSettStartDate = $('input[name="userSettStartDate"]').val();
    let userSettEndDate = $('input[name="userSettEndDate"]').val();
    let userSearchKey = $('select[name="userSearchKey"]').val();
    let userSearchable = $('select[name="userSearchable"]').val();

    $('input[name="amDateSettStartDate"]').val(userSettStartDate);
    $('input[name="amDateSettEndDate"]').val(userSettEndDate);
    $('input[name="orderCategoryCode"]').val(arr);
    $('input[name="searchKey"]').val(userSearchKey);
    $('input[name="searchValue"]').val(userSearchable);

    let queryString = $('#searchForm').serialize();
    console.log(queryString, '<-- queryString');
    orderSearchAjax(queryString, function(list){
        console.log(list, '<--list');
    });
});
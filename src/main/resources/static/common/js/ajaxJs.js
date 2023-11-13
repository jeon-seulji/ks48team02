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
        console.log(list);
        // 여기에서 작업
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
        console.log(list, '<--');
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
function setPagerData(){
    $('.order-list-pager li').remove();
    $('.order-list-pager').append(`<li></li>`);
}

// select 옵션 선택 ajax
$('select[name="orderby"], select[name="count-select"]').on('change',function(){
    $('#allSelectBtn').prop('checked', false);
    let orderbyValue = $('select[name="orderby"]').val();

    $('.select-list-count').text('0');

    // page value
    let currentPage = 1;
    let rowPerPage = $('select[name="count-select"]').val();

    console.log(parseInt(rowPerPage), '<--rowPerPage');
    // ajax 호출
    adminOrderListAjax(orderbyValue, currentPage, rowPerPage, function(list) {
        // list count
        $('.total-list').text(list.orderList.length);
        setOrderData(list.orderList);
    });
});

// 페이징 ajax
$(document).on('click', '.order-list-pager a',function(){
    let pageNumber = $(this).attr('data-value');
    console.log(pageNumber, '<--pageNumber');
    let orderbyValue = $('select[name="orderby"]').val();
    let rowPerPage = $('select[name="count-select"]').val();
    // ajax 호출
    adminOrderListAjax(orderbyValue, pageNumber, rowPerPage, function(list){
        // list count
        $('.total-list').text(list.orderList.length);
        setOrderData(list.orderList);

        // pager setting
        const pageNumArr = Array(list.endPageNum - (list.startPageNum + 1)).fill().map((item, idx) => list.startPageNum + idx);
        console.log(pageNumArr, '<--pageNumArr');
    });
})
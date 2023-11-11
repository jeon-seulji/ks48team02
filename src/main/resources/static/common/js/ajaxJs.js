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
function adminOrderListAjax(param, callback){
    const request = $.ajax({
        url: '/admin/order/ajax/list',
        method : 'POST',
        data : {"orderby" : param},
        dataType: 'json'
    })
    request.done(function(list){
        callback(list);
    });
    request.fail(function(err){
        console.log(err);
    })
}

$('select[name="orderby"]').on('change',function(){
    $('#allSelectBtn').prop('checked', false);
    let value = $(this).val();
    $('.select-list-count').text('0');
    adminOrderListAjax(value, function(list) {
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


    });
});
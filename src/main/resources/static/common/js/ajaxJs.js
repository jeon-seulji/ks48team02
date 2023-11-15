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


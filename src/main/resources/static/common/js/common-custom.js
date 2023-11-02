// count function
const counterShort = ($counter, max) => {
    // console.log($counter, max);
    let now = max;

    const handle = setInterval(() => {
        let hasPriceClass = $($counter).hasClass('price-data');
        let price = Math.ceil(max - now);
        let result = price;

        if(hasPriceClass){
            result = price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        }

        $($counter).text(result);

        // 목표수치에 도달하면 정지
        if (now < 1) {
            clearInterval(handle);
        }

        // 증가되는 값이 계속하여 작아짐
        const step = now / 10;

        // 값을 적용시키면서 다음 차례에 영향을 끼침
        now -= step;
    }, 30);
}

const counterLong = ($counter, max) => {
    // console.log($counter, max);
    let now = max;

    const handle = setInterval(() => {
        let hasPriceClass = $($counter).hasClass('price-data');
        let price = Math.ceil(max - now);
        let result = price;

        if(hasPriceClass){
            result = price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        }

        $($counter).text(result);

        // 목표수치에 도달하면 정지
        if (now < 1) {
            clearInterval(handle);
        }

        // 증가되는 값이 계속하여 작아짐
        const step = now / 10;

        // 값을 적용시키면서 다음 차례에 영향을 끼침
        now -= step;
    }, 10);
}

// back btn function
function backLocationFn(){
    if(confirm('작업중인 내용이 사라집니다. 정말 이전 페이지로 가시겠습니까?')){
        location.href = document.referrer;
    }
    return;
}

// default date setting
const nowDateSet = new Date();
let nowDateFomat = '';
nowDateFomat += nowDateSet.getFullYear();
nowDateFomat += '-';
nowDateFomat += nowDateSet.getMonth() + 1;
nowDateFomat += '-';
nowDateFomat += nowDateSet.getDate();

function startDate(dateObj) {
    const dateLimit = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    let startDateValue = "";

    let idxNum = nowDateSet.getMonth() - 2;

    if (idxNum < 0) {
        startDateValue += nowDateSet.getFullYear() - 1;
        idxNum = 12 + idxNum;
        startDateValue += "-";
    } else {
        startDateValue += nowDateSet.getFullYear();
        startDateValue += "-";
    }

    if (dateLimit[nowDateSet.getMonth()] > dateLimit[idxNum - 1]) {
        startDateValue += String(idxNum).padStart(2, '0');
        startDateValue += "-";
        startDateValue += "28";
    } else {
        startDateValue += String(idxNum).padStart(2, '0');
        startDateValue += "-";
        startDateValue += String(nowDateSet.getDate()).padStart(2, '0');
    }
    return startDateValue;
}


// 달 적용 함수
function monthDateSettingFn(date, $obj){
    let CalSettingMonth = date.getMonth() + 1;
    let isFalse = false;
    $($obj).each((idx, item) => {
        let itemValue = $(item).val();
        if(itemValue == CalSettingMonth){
            $(item).prop('selected', true);
            isFalse = true;
            return;
        }
        if(isFalse) return;
    });
}
// 연 적용 함수
function yearDateSettingFn(date, $obj){
    let CalSettingYear = date.getFullYear();
    let isFalse = false;
    $($obj).each((idx, item) => {
        let itemValue = $(item).val();
        if(itemValue == CalSettingYear){
            $(item).prop('selected', true);
            isFalse = true;
            return;
        }
        if(isFalse) return;
    });
}

const projectPointColor = [
    'rgb(253,169,185)', // 리워드
    'rgb(158,227,215)', // 기부
    'rgb(198,173,246)' // 투자
]

// 진현
// popup 형태 새로운 브라우저 open function
function popupOpen(customUrl) {
    console.log("a");
    var url = customUrl;    //팝업창에 출력될 페이지 URL
    var winWidth = 700;
    var winHeight = 600;

    var popupX = (document.body.offsetWidth / 2) - (winWidth / 2);
    // 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

    var popupY = (window.screen.height / 2) - (winHeight / 2);
    // 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
    var popupOption = 'status=no, height=' + winWidth + ', width=' + winHeight + ', left=' + popupX + ', top=' + popupY;    //팝업창 옵션(optoin)

    window.open(url, ' target="_blank"', popupOption);
}

// 수정 삭제 confirm 이벤트
function confirmBtnFn(e){
    let contentsText = $(e).text();
    if(confirm(`정말 ${contentsText} 하시겠습니까?`)) {

        $(e).parents('form').submit();
        // location.href = document.referrer;
    }
}

// input [type='date'] min setting
$('input[type="date"]').prop('min',nowDateFomat);

// 배송 메세지 직접 입력
$('select[name="deliveryMessage"]').on('change', function(){
    let selectedValue = $(this).val();

    console.log(selectedValue, '<--');
    if(selectedValue == '5') {
        $('input[name="deliveryMessageDirect"]').attr('disabled', false).focus();
    } else {
        $('input[name="deliveryMessageDirect"]').attr('disabled', true);
    }
});

// 전체 선택 버튼 제어
$('#allSelectBtn').on('click', function(){
    let isChecked = $(this).prop('checked');
    $('input[name="selectList"]').prop('checked', isChecked);
});
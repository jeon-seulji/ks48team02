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

// 공고 상세보기 btn controls
$('.more-btn').on('click', function(){
    $('.projectInfoDetail').toggleClass('active');
    $(this).toggleClass('active');
});


/* 유효성 검사 Fn */
let regExpKr = /[^ㄱ-ㅎ가-힣]/g;
let regExpEn = /[^a-zA-Z]/g;
let regExpNum = /[^0-9]/g;
let regEmpty = /\s/;

// 공백 유효성 검사
function validationEmptyFn($els){
    let isFalse = true;
    $($els).each((idx, item) => {
        let value = $(item).val();
        let labelId = $(item).attr('id');
        console.log(labelId, '<--?')

        if(value == null || value == '' || typeof value == 'undefined') {
            let labelText = $(`label[for=${labelId}]`).text();
            alert(labelText+'는 필수 입력 항목입니다');
            $(item).focus();
            isFalse = false;
            return false;
        }
    });
    return isFalse;
}
// 한글 유효성 검사
function validationOnlyKoreanFn($els){
    let isFalse = true;
    $($els).each((idx, item) => {
        // 초기화
        $(item).siblings('.error-message').remove();
        // 대상 value 반환
        let value = $(item).val();

        // 공백 검증
        let emptyMatches = value.match(regEmpty) ; // 공백 반환
        if(emptyMatches) {
            $(item).focus().val('').after('<span class="error-message">공백 없이 입력해주세요</span>');
            isFalse = false;
            return false;
        }

        // 한글 유효성 검증
        let valueMatches = value.match(regExpKr) ; // value 중 한글이 아닌 값 반환

        if(valueMatches) {
            $(item).focus().val('').after('<span class="error-message">한글만 입력해주세요</span>');
            isFalse = false;
            return false;
        }
    });
    return isFalse;
}
/*
*
* */
// 숫자 유효성 검사
function onlyNumberValidationFn($els,addValue){
    let regExpNum = new RegExp('[^0-9' + addValue + ']', 'g');
    let isFalse = true;
    $($els).each((idx, item) => {
        $(item).siblings('.error-message').remove();

        let value = $(item).val();

        let emptyMatches = value.match(regEmpty) ;

        if(emptyMatches) {
            $(item).focus().val('').after('<span class="error-message">공백 없이 입력해주세요</span>');
            isFalse = false;
            return false;
        }

        // 숫자 유효성 검사
        let valueMatches = value.match(regExpNum) ;
        if(valueMatches) {
            $(item).focus().val('').after('<span class="error-message">숫자만 입력해주세요</span>');
            isFalse = false;
            return false;
        }
    });
    return isFalse;
}

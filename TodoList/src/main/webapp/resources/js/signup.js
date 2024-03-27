// const req  = /^[ㄱ-힣{2,5}]$/;

const checkObj = {
    "inputId" : false ,// 아이디 
    "inputPw" : false , //비밀번호
    "inputPw2" : false, //비번확인
    "inputName" : false // 닉네임
};


const inputId = document.getElementById("inputId");




inputId.addEventListener("change", function(){
    const regExp = /^[a-z][\w!@#$%^&*()]{5,13}$/;
    //소문자 시작 + 언더바 나머지글자 5 ~ 13 글자 특수문자 가능 = 6~14글자

    if(regExp.test(this.value)){
            this.style.backgroundColor = "green";
           
            this.style.color = "white";
            checkObj.inputId = true;
    }else{
       this.style.backgroundColor = "red";
       this.style.color = "white";
       checkObj.inputId = false;
    }
});

//change 는 값을 입력하다가 다른곳으로 클릭하면 그 변화가 일어낫으니 검사를 해준다

const inputPw = document.getElementById("inputPw");
const inputPwConfirm = document.getElementById("inputPw2");
const pwMessage = document.getElementById("pwMessage");

inputPwConfirm.addEventListener("keyup" , function(){

if(inputPw.value.length == 0){
    this.value = "";
    alert("비밀번호를 먼저 입력해주세요");
    inputPw.focus();
    checkObj.inputPw = false;
}

   

});

inputPw.addEventListener("keyup", function(){

   if(  (inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0){
    pwMessage.innerText = "비밀번호 일치";
    pwMessage.classList.add("confirm");
    pwMessage.classList.remove("error");
    checkObj.inputPw = true;
    checkObj.inputPwConfirm = true;
   }else{
    pwMessage.innerText = "비밀번호 불일치";
    pwMessage.classList.add("error");
    pwMessage.classList.remove("confirm");
    checkObj.inputPwConfirm = false;
   }

});

inputPwConfirm.addEventListener("keyup", function(){

    if(  (inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0){
     pwMessage.innerText = "비밀번호 일치";
     pwMessage.classList.add("confirm");
     pwMessage.classList.remove("error");
     checkObj.inputPw = true;
     checkObj.inputPwConfirm = true;
    }else{
     pwMessage.innerText = "비밀번호 불일치";
     pwMessage.classList.add("error");
     pwMessage.classList.remove("confirm");
     checkObj.inputPwConfirm = false;
    }
 
 });


 //--------------------------------닉네임 유효성 검사
 // 두글자 이상 5글자 미만

 const inputName = document.getElementById("inputName");

 const nameMessage = document.getElementById("nameMessage");


 inputName.addEventListener("keyup", function(){
    const regtest = /^[ㄱ-힣]{2,5}$/;

    if(regtest.test(this.value)){
        nameMessage.innerText = "정상입력"
        nameMessage.classList.add("confirm");
        nameMessage.classList.remove("error");
        checkObj.inputName = true;
    }else{
        nameMessage.innerText = "비정상"
        nameMessage.classList.add("error");
        nameMessage.classList.remove("confirm");
        checkObj.inputName = false;
    }


 })






//최종적으로 유효성 검사 객체인 checkObj안에 있는 모든 value가
//true 인지 확인해주는 함수
//만약 모두 true다 -> 서버로 submit
//만약 하나라도 false 다 -> 유효성검사가 완료되지않았습니다.
function validate(){

  for(let key in checkObj){
        if(!checkObj[key]){
            alert("유효성 검사가 완료되지 않았습니다");
            return false;   
        }
  }

  return true;


};


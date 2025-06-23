//HTML要素をオブジェクトとして取得する
let formObj = document.getElementById('user_form');
let errorMessageObj = document.getElementById('error_message');
let viewicon = document.getElementById('view');

const pwPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,20}$/;

formObj.onsubmit = function(event) {
 const pw1 = formObj.pw1.value;
 const pw = formObj.pw.value;
 //空欄でエラー出るか
   if ( pw1 === '' ) {
    errorMessageObj.textContent = '※名前とID、パスワードを入力してください！';
    event.preventDefault();
   }}
/*
 //パスワードが一致しないときのエラー
 if(pw1 !== pw){
  errorMessageObj.textContent = 'パスワードが一致しません';
  event.preventDefault();
//パスワードが条件を満たさないときのエラー
 } else if (!pwPattern.test(pw)) {
  errorMessageObj.textContent = 'パスワードは英大文字・小文字・数字を含む8〜20文字で入力してください';
  event.preventDefault();
  */

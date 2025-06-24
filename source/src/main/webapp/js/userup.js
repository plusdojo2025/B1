//HTML要素をオブジェクトとして取得する
let formObj = document.getElementById('user_form');
let errorMessageObj = document.getElementById('error_message');


const pwPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_])[A-Za-z\d\W_]{8,20}$/;

formObj.onsubmit = function(event) {
 const first_pw = formObj.first_pw.value;
 const second_pw = formObj.second_pw.value;
 //空欄でエラー出るか
   if ( second_pw !== first_pw ) {
    errorMessageObj.textContent = 'パスワードが一致しません';
    event.preventDefault();
   }else if (!pwPattern.test(first_pw)) {
  errorMessageObj.textContent = 'パスワードは英大文字・小文字・数字を含む8〜20文字で入力してください';
  event.preventDefault();
  }
};
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

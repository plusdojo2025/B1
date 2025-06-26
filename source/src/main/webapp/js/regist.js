window.addEventListener('DOMContentLoaded', function () {
let formObj = document.getElementById('user_form');
let errorMessageObj = document.getElementById('error_message');


const pwPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_])[A-Za-z\d\W_]{8,20}$/;

formObj.onsubmit = function(event) {
	const pw = document.getElementById("pw").value;
	const pw2 = document.getElementById("pw2").value;
 
 //空欄でエラー出るか
   if (pw2 !== pw ) {
    errorMessageObj.textContent = 'パスワードが一致しません';
    event.preventDefault();
   }else if (!pwPattern.test(pw)) {
  errorMessageObj.textContent = 'パスワードは英大文字・小文字・数字を含む8〜20文字で入力してください';
  event.preventDefault();
  }
};
});
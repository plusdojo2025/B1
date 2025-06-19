<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報|NaviZaka</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
<link rel="Stylesheet" href="<c:url value='/css/userup.css'/>">
</head>
<body>
  <!-- ヘッダー（ここから） -->
	<header>
		<a href="/B1/LoginServlet">
			<img src="img/logo.png" alt="NaviZaka"  height="130">
		</a>
		<nav>
			<ul>
			<li><a href="/B1/LoginServlet">ホーム</a></li>
			<li><a href="/B1/ManuListServlet">マニュアル一覧</a></li>
			<li><a href="/B1/UserUpServlet">ユーザー情報</a></li>
			<li><a href="/B1/LoginServlet"><img src="img/logout.png" alt="ログアウト" width="100"></a>
			</ul>
		</nav>
	</header>
  <!-- ヘッダー（ここまで） -->
  <div class="wrapper">
  <!-- メッセージエリア -->
  <p id="error_message"><c:out value="${result.message}" /></p> 
  <!-- 入力フォーム -->
  <form id="user_form" method="POST" action="<c:url value='/UserUpServlet' />">
    <input type="hidden" name="id" value="${user.id}">
    <table class="upload">
      <tr>
        <th><label>氏名</label></th>
      </tr>
      <tr>
        <td><input type="text" name="name" id="name" value="${user.name}" placeholder="氏名を入力" class="form"></td>
      </tr>
      <tr>
        <th><label>ID</label></th>
      </tr>
      <tr>
        <td><input type="text" name="email" id="email" value="${user.email}" placeholder="メールアドレスを入力" class="form"></td>
      </tr>
      <tr>
        <th><label>PW<span class="tips">(英大文字・英小文字・数字の3種を含む8文字以上20字以下)</span></label></th>
      </tr>
      <tr>
        <td><input type="text" name="pw1" id="pw1" value="${user.pw}" placeholder="パスワードを入力" class="form">
          <span id="view">
           <!-- 目のアイコン -->
          <i class="eye"></i>
       </span>
       </td>
      </tr>
      <tr>
        <th><label>PW(確認)</label></th>
      </tr>
      <tr>
        <td><input type="text" name="pw" id="pw" value="${user.pw}" placeholder="パスワードを入力" class="form">
        <span id="view">
         <!-- 目のアイコン -->
         <i class="eye"></i>
       </span>
        </td>
      </tr>
      </table>
       <div class=radio>
        <input type="radio" name="role" value="社員" ${user.role == '社員' ? 'checked' : ''} >社員
		<input type="radio" name="role" value="アルバイト" ${user.role == 'アルバイト' ? 'checked' : ''}>アルバイト
	  </div>
	  <div class=button>
       <input type="submit"  class="button" name="submit" value="変更">
      </div>
      
     
  </form>
  </div>
  <!-- フッダー(ここから) -->
  <footer>
  <p class="copyright">&copy;せんこうはなび</p>
  </footer>
<!-- フッダー(ここまで) -->
</body>
<script>
'use struct';

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
 }}

/*
//  id="view"クリック時の処理を設定
$('#view').on('click', function () {

       //  passwordからtextへ
       if(inputtype.type === 'pw'){
              inputtype.type = 'text';
              viewicon.innerHTML = '<i class="eye"></i>';

        //  textからpasswordへ
        } else {
               inputtype.type = 'password';
               viewicon.innerHTML = '<i class="eye"></i>';
        }
});
*/
*
</script>
</html>
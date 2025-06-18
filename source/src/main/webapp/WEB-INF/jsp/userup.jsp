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
  <p id="error_message">氏名が入力されていません。</p> 
  <!-- 入力フォーム -->
  <form id="user_form" method="POST" action="<c:url value='/UserUpServlet' />">
    <table class="upload">
      <tr>
        <th><label>氏名</label></th>
      </tr>
      <tr>
        <td><input type="text" name="name" id="name" placeholder="氏名を入力" class="form"></td>
      </tr>
      <tr>
        <th><label>ID</label></th>
      </tr>
      <tr>
        <td><input type="text" name="email" id="email" placeholder="メールアドレスを入力" class="form"></td>
      </tr>
      <tr>
        <th><label>PW<span class="tips">(英大文字・英小文字・数字の3種を含む8文字以上20字以下)</span></label></th>
      </tr>
      <tr>
        <td><input type="password" placeholder="パスワードを入力" class="form"></td>
      </tr>
            <tr>
        <th><label>PW(確認)</label></th>
      </tr>
      <tr>
        <td><input type="password" name="pw" id="pw" placeholder="パスワードを入力" class="form"></td>
      </tr>
      </table>
       <div class=radio>
        <input type="radio" name="role" value="社員">社員
		<input type="radio" name="role" value="アルバイト">アルバイト
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

<!--HTML要素をオブジェクトとして取得する-->
let formObj = document.getElementById('user_form');
let errorMessageObj = document.getElementById('error_message');

<!--[ログイン]ボタンをクリックしたときの処理-->
<!--空欄があるときのエラー-->
formObj.onsubmit = function(event) {
  const user_name = formObj.name.value;
  const user_id = formObj.id.value;
  const user_pass = formObj.pw.value;
  if ( user_name === '') {
    errorMessageObj.textContent = '※氏名を入力してください';
    event.preventDefault();
  }else if(user_id === ''){
	errorMessageObj.textContent = '※IDを入力してください';
	event.preventDefault();  
  }else if(user_pass === ''){
	errorMessageObj.textContent = '※PWを入力してください';
    event.preventDefault();  
  }
};
<!--パスワードが条件を満たさないときのエラー-->
<!--パスワードが一致しないときのエラー-->
</script>
</html>
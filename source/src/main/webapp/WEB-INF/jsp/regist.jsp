<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
<link rel="stylesheet" type="text/css" href="/B1/css/common.css">
</head>
<body>
<!-- ヘッダー（ここから） -->
  <header>
  　<a href="/B1/LoginServlet"><img src="img/logo.png"  height="130" alt="ロゴ"></a>
  </header>
  <!-- ヘッダー（ここまで） -->
<div class="wrapper">
   <!-- メッセージエリア -->
  <p id="message">氏名が入力されていません。</p> 
    <!-- ユーザー登録フォーム -->
    <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
		氏名<br><input type="text" name="username" placeholder="氏名を入力" class="form"><br>
		ID<br><input type="text" name="email" id="email" placeholder="メールアドレスを入力" class="form"><br>
        パスワード(英大文字・英小文字・数字の3種を含む8文字以上20字以下)<br><input type="password" name="pw" id="pw" placeholder="パスワードを入力" class="form"><br>
        パスワード(確認)<br><input type="password" name="pw" id="pw" placeholder="パスワードを入力" class="form"><br>
    </form>
    
    <div class=radio>
        <input type="radio" name="num_of_inq" value="社員">社員
		<input type="radio" name="num_of_inq" value="アルバイト">アルバイト
	  </div>
	  <div class=button>
       <input type="submit"  class="button" name="submit" value="登録">
      </div>
    </div>
     <!-- フッダー(ここから) -->
        <footer>
        <p class="copyright">&copy;せんこうはなび</p>
        </footer>
      <!-- フッダー(ここまで) -->
<script>
       
    </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>"> 
</head>
<body>
<!-- ヘッダー（ここから） -->
  <header>
  　<a href="<c:url value='/RegistServlet'/>">
 	<img src="<c:url value='/img/logo.png' />" alt="NaviZaka"  height="130">
 	</a>
  </header>
  <!-- ヘッダー（ここまで） -->
<div class="wrapper">
	<div class="center">
   <!-- メッセージエリア -->
 	 <p id="message">氏名が入力されていません。</p> 
    <!-- ユーザー登録フォーム -->
    <form action="${pageContext.request.contextPath}/RegistServlet" method="post">
		氏名<br><input type="text" name="name" placeholder="氏名を入力" class="form"><br>
		ID<br><input type="text" name="email" id="email" placeholder="メールアドレスを入力" class="form"><br>
        パスワード(英大文字・英小文字・数字の3種を含む8文字以上20字以下)<br><input type="password" name="pw" id="pw" placeholder="パスワードを入力" class="form"><br>
        パスワード(確認)<br><input type="password" name="pw2" id="pw2" placeholder="パスワードを入力" class="form"><br>
        <label><input type="radio" name="role" value="社員"> 社員</label>
        <label><input type="radio" name="role" value="アルバイト"> アルバイト</label><br><br>
        
        <input type="submit" class="button" value="登録">
    </form>
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
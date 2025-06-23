<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css'/>">
</head>
<body>
	<!-- ヘッダー -->
	<header>
		<a href="/B1/LoginServlet">
			<img src="img/logo.png" alt="NaviZaka" height="130">
		</a>
	</header>
	<!-- ヘッダーここまで -->

<form method="POST" action="/B1/LoginServlet" class="idpas" id="idpas">
	<!-- メッセージエリア -->
	<div id="center">
		<p id="massage">
		<c:if test="${not empty message}">
			${message}
		</c:if>
		</p>
	</div>
	
	<!-- id入力 -->
	<p class="login_text">USER NAME(MAIL ADDRESS)</p>
	<input type="text" name="email" id="id" class="text">
	
	<!-- PW入力 -->
	<p class="login_text">パスワード</p>
	<input type="text" name="pw" id="pw" class="text"><br>
	
	<!-- ログインボタン -->
	<input type="submit" name="login" value="ログイン" id="loginbutton" class="button">
</form>
	
	<!-- 新規登録 -->
	<p>
		<a href="<c:url value='/RegistServlet'/>"class="link">新規登録はこちら</a>
	</p>

	<!-- フッター -->
	<footer>
	<p class="copyright">&copy;せんこうはなび</p>
	</footer>
</body>
</html>
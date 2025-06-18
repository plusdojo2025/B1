<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ユーザー管理</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
</head>
<body>
	<!-- ヘッダー -->
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
	
	<form method="POST" class="idpas" id="idpas">
	<!-- 日付ピッカー -->
	<input type="date" name="workday">
	
	<!-- メッセージエリア -->
	<p id="message"></p> 
	
	<!-- アルバイト表示 -->
	<p>アルバイトA</p>
	<p>アルバイトB</p>
	<p>アルバイトC</p>
	
	<!-- 業務選択 -->
	<select id="work" name="work">
		<option value="dish">dish</option>
	</select>
	<select id="work" name="work">
		<option value="dish">dish</option>
	</select>
	<select id="work" name="work">
		<option value="dish">dish</option>
	</select>
	
	<!-- ポイント -->
	<p>330p</p>
	<p>330p</p>
	<p>330p</p>
	
	<!-- ログインボタン -->
	<input type="submit" name="regist_usermanage" value="登録" id=regist_usermanage class=button>
	</form>
	
	<!-- フッター -->
	<footer>
		<p class="copyright">&copy;せんこうはなび</p>
	</footer>
</body>
</html>
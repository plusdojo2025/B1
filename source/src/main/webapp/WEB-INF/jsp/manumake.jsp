<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マニュアル作成|NaviZaka</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">

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
<body>
<h2>マニュアル作成ページ</h2>
</body>
  <!-- フッダー(ここから) -->
  <footer>
  <p class="copyright">&copy;せんこうはなび</p>
  </footer>
<!-- フッダー(ここまで) -->
</html>
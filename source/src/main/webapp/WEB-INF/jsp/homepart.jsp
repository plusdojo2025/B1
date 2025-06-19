<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム</title>
<link rel="stylesheet" href="<c:url value='/css/common.css' />">
<link rel="stylesheet" href="<c:url value='/css/homepart.css' />">
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
 
 <!--ログイン者名表示 -->
   <p><span id="username"></span></p>
<div class=center>
   <!-- 更新マニュアル通知 -->
	<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
	<input type="text"  name="username" placeholder="更新マニュアル通知が表示されます" class="form">
	</form>
　<!-- 今日の業務表示 -->
   <p>今日の業務<p>
   <input type="text"  name="username" placeholder="今日の業務が表示されます" class="form">
</div>
   <footer>
        <p class="copyright">&copy;せんこうはなび</p>
        </footer>
   <script>
    // サーバーから取得したログインユーザー名（仮のJavaScript　実際はJava）
    const loggedInUserName = "山田太郎";

    // HTMLに表示
    document.getElementById("username").textContent = loggedInUserName;
    </script>
</body>
</html>
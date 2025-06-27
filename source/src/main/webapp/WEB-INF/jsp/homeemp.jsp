<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="dto.Users"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
Users loginUser = (Users) session.getAttribute("loginUser");
if (loginUser == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/homeemp.css'/>">
</head>
<body>
	<!-- ヘッダー -->
	<header>
		<a href="<c:url value='/HomeServlet'/>"> <img
			src="<c:url value='/img/logo.png' />" alt="NaviZaka" height="130">
		</a>
		<nav>
			<ul>
				<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
				<li><a href="<c:url value='/ManuListServlet' />">マニュアル一覧</a></li>
				<li><a href="<c:url value='/UserUpServlet' />">ユーザー情報</a></li>
				<li><a href="<c:url value='/LoginServlet' />"><img
						src="<c:url value='/img/logout.png' />" alt="ログアウト" width="100"></a>
			</ul>
		</nav>
	</header>

	<!--ログイン者名表示 -->
	<p>
		ログインユーザー：<strong><%=loginUser.getName()%></strong>
	</p>

	<div class=center>
		<!--　マニュアル更新依頼 -->
		<p>
			マニュアル更新依頼<span id="request-count" class="badge"></span>
		</p>
		<a href="<c:url value='/ManuUpServlet' />">食器洗い</a>
		<!-- 今日のアルバイト表示 -->
		<p>今日のアルバイト
		<p>
		<ul>
			<c:forEach var="Parttimer" items="${todayParttimer}">
				<li>${Parttimer.name}</li>
			</c:forEach>
		</ul>
		<!-- 各種ボタン -->
		<button class="button" name="submit" value="マニュアル作成"
			onclick="location.href='<c:url value='/FormServlet' />'">マニュアル作成</button>
		<button class="button" name="submit" value="ユーザー管理"
			onclick="location.href='<c:url value='/UserManageServlet' />'">ユーザー管理</button>
		<button class="button" name="submit" value="ユーザー管理"
			onclick="location.href='<c:url value='/ManuUpServlet' />'">マニュアル更新</button>
	</div>



	<!-- フッダー(ここから) -->
	<footer>
		<p class="copyright">&copy;せんこうはなび</p>
	</footer>
	<!-- フッダー(ここまで) -->
</body>
</html>
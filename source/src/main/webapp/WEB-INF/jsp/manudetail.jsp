<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マニュアル詳細 | NaviZaka</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/manudetail.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
</head>
<body>
<!-- ヘッダー（ここから） -->
<header>
		<a href="<c:url value='/LoginServlet'/>">
			<img src="<c:url value='/img/logo.png' />" alt="NaviZaka"  height="130">
		</a>
		<nav>
			<ul>
			<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
			<li><a href="<c:url value='/ManuListServlet' />">マニュアル一覧</a></li>
			<li><a href="<c:url value='/UserUpServlet' />">ユーザー情報</a></li>
			<li><a href="<c:url value='/LoginServlet' />"><img src="<c:url value='/img/logout.png' />" alt="ログアウト" width="100"></a>
			</ul>
		</nav>
	</header>
  <!-- ヘッダー（ここまで） -->
	<h2>${manual.categoryName}｜${manual.taskName}</h2>

<div class="manual-body-container">
    <div class="manual-body-box"><c:out value="${manual.manualBody}" /></div>
</div>
<!-- レビューフォーム -->
<form action="<c:url value='/ManuDetailServlet' />" method="POST">

<!-- 評価 -->
<div>
    評価：
    <span class="star" onclick="setRating(1)">☆</span>
    <span class="star" onclick="setRating(2)">☆</span>
    <span class="star" onclick="setRating(3)">☆</span>
    <span class="star" onclick="setRating(4)">☆</span>
    <span class="star" onclick="setRating(5)">☆</span>
    <input type="hidden" name="rating" id="rating" value="0">
</div>

<!-- コメント入力 -->
    <p>
        <textarea name="comment" rows="4" cols="50" placeholder="コメント"></textarea>
    </p>

    <input type="hidden" name="manualId" value="${manual.id}">
    <button type="submit" class="button">送信</button>
    
    
</form>

<!-- 完了チェックフォーム -->
<form method="post" action="<c:url value='/ManuDetailServlet' />">
<input type="hidden" name="manualId" value="${manual.id}">

<c:choose>
    <c:when test="${hasChecked}">
        <p style="color: green;">✔ 完了済みです</p>
    </c:when>
    <c:otherwise>
        <input type="hidden" name="action" value="completeCheck" />
        <button type="submit" class="button">完了</button>
    </c:otherwise>
</c:choose>
</form>
	<!-- フッダー(ここから) -->
	<footer>
  		<p class="copyright">&copy;せんこうはなび</p>
	</footer>
	<!-- フッダー(ここまで) -->  
</body>
<script src="<c:url value='/js/manudetail.js' />"></script>
</html>
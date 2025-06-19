<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マニュアル詳細 | NaviZaka</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/manudetail.css'/>">
</head>
<body>
<!-- ヘッダー（ここから） -->
  	<header>
  		<div class="logo">
  　			<a href="/B1/LoginServlet"><img src="img/logo.png"alt="ロゴ" height="130" width="400"></a>
  		</div>
  		<nav class="nav">
    		<ul>
    			<li><a href="/B1/LoginServlet">ホーム</a></li>
     			<li><a href="/B1/ManuListServlet">マニュアル一覧</a></li>
     			<li><a href="/B1/UserUpServlet">ユーザー情報</a></li>
    		</ul>
   		</nav>
   		<div class="logout"> 
   			<a href="/B1/LoginServlet"><img src="img/logout.png"alt="ログアウト"></a>
  		</div>  


  	</header>
  	<!-- ヘッダー（ここまで） -->
	<h2>${manual.categoryName}｜${manual.taskName}</h2>

<div class="manual-body-container">
    <div class="manual-body-box">
    ${manual.manualBody}
    </div>
</div>

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
<form action="/B1/ManuDetailServlet" method="POST">
    <p>
        <textarea name="comment" rows="4" cols="50" placeholder="コメント"></textarea>
    </p>

    <input type="hidden" name="manualId" value="${manual.id}">
    <button type="submit">完了</button>
</form>
	<!-- フッダー(ここから) -->
	<footer>
  		<p class="copyright">&copy;せんこうはなび</p>
	</footer>
	<!-- フッダー(ここまで) -->  
</body>
<script src="<c:url value='/js/manudetail.js' />"></script>
</html>
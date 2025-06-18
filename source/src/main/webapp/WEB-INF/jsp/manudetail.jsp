<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マニュアル詳細 | NaviZaka</title>
<link rel="stylesheet" href="<c:url value='/css/common.css' />">
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
	<!--メッセージエリア-->
  	<p id="message">メッセージエリア</p>  
	<form id="user_form" method="POST" action="/B1/ManuDetailServlet">
		<table>
			<tr>
				<th><label>カテゴリ（キッチンなど）業務名（皿洗いなど）</label></th>
			</tr>
			<tr>
        		<td><input type="text" readonly name="name" id="name" class="form" size="50"></td>
      		</tr>
		</table>
		
		<div id="stars">
        	<span class="star" data-star="1">☆</span>
        	<span class="star" data-star="2">☆</span>
        	<span class="star" data-star="3">☆</span>
        	<span class="star" data-star="4">☆</span>
        	<span class="star" data-star="5">☆</span>
    	</div>
    	<input type="text">
    	<button type="submit">評価</button>
	</form>
	<!-- フッダー(ここから) -->
	<footer>
  		<p class="copyright">&copy;せんこうはなび</p>
	</footer>
	<!-- フッダー(ここまで) -->  
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ユーザー管理</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/usermanage.css'/>">
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
	
	<form method="GET" class="idpas" id="idpas">
		<!-- 日付ピッカー -->
		<input type="date" name="workday">
		
		<!-- メッセージエリア -->
		<p id="message"></p> 
		
		<!-- 横並びの為div -->
		<div class=row>

			<!-- 業務選択 -->
			<div class="selectContainer">
				<p>アルバイトA</p>
				<p>330p</p>
				<div class=select_work>
					<select id="work" name="work">
						<c:forEach var="task" items="${taskList}">
							<option value="${task.id}">${task.task}</option>
						</c:forEach>
					</select>
				</div>
				<!-- 追加ボタン -->
				<button type="button" onclick="addSelect(this)" class="button">+</button>
				
				<p>アルバイトB</p>
				<p>330p</p>
				<div class=select_work>
					<select id="work" name="work">
						<option value="dish">dish</option>
					</select>
				</div>
				<!-- 追加ボタン -->
				<button type="button" onclick="addSelect(this)" class="button">+</button>
				
				<p>アルバイトC</p>
				<p>330p</p>
				<div class=select_work>
					<select id="work" name="work">
						<option value="dish">dish</option>
					</select>
				</div>
				<!-- 追加ボタン -->
				<button type="button" onclick="addSelect(this)" class="button">+</button>
			</div>
			
		</div>
		
		<!-- 登録ボタン -->
		<div class="register-button">
			<input type="submit" name="regist_usermanage" value="登録" id="regist_usermanage" class="button">
		</div>
	</form>
	
	<!-- フッター -->
	<footer>
		<p class="copyright">&copy;せんこうはなび</p>
	</footer>
</body>
<script src="<c:url value='/js/usermanage.js'/>">
	const optionsHtml = `
	<c:forEach var="task" items="${taskList}">
	<option value="${task.id}">${task.task}</option>
	</c:forEach>
	`;
</script>
</html>
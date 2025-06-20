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
	
	<form method="POST" action="/B1/UserManageServlet">
		<!-- 日付ピッカー -->
		<input type="date" name="workday" required>
		
		<!-- メッセージエリア -->
		<p id="message"></p> 
		
		<!-- 横並びの為div -->
		<div class=row>
			<!-- 業務選択 -->
			<div class="selectContainer">
				<div class=job_block>
					<p>アルバイトA</p>
					<p>330p</p>
					<div class=select_work>
						<select id="work" name="work1">
							<c:forEach items="${taskList}" var="task" varStatus="status">
								<option value="${status.index + 1}">${task.task}</option>
							</c:forEach>
						</select>
					</div>
					<!-- 追加ボタン -->
					<button type="button" onclick="addSelect1(this)" class="button">+</button>
				</div>
				
				<div class=job_block>
					<p>アルバイトB</p>
					<p>330p</p>
					<div class=select_work>
						<select id="work" name="work2">
							<c:forEach items="${taskList}" var="task" varStatus="status">
								<option value="${status.index + 1}">${task.task}</option>
							</c:forEach>
						</select>
					</div>
					<!-- 追加ボタン -->
					<button type="button" onclick="addSelect2(this)" class="button">+</button>
				</div>
				
				<div class=job_block>
					<p>アルバイトC</p>
					<p>330p</p>
					<div class=select_work>
						<select id="work" name="work3">
							<c:forEach items="${taskList}" var="task" varStatus="status">
								<option value="${status.index + 1}">${task.task}</option>
							</c:forEach>
						</select>
					</div>
					<!-- 追加ボタン -->
					<button type="button" onclick="addSelect3(this)" class="button">+</button>
				</div>
			</div>
		</div>
		
		<!-- 登録ボタン -->
		<div class="register-button">
			<input type="submit" name="regist_usermanage" value="登録" id="regist_usermanage" class="button">
		</div>
		
		
		<!-- 新しく追加される -->
		<div id="options-data" style="display:none;">
		  <c:forEach items="${taskList}" var="task" varStatus="status">
				<option value="${status.index + 1}">${task.task}</option>
			</c:forEach>
		</div>
		
	</form>
	
	<!-- フッター -->
	<footer>
		<p class="copyright">&copy;せんこうはなび</p>
	</footer>
</body>
<script src="<c:url value='/js/usermanage.js'/>"></script>
</html>
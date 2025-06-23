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
	
	<form method="POST" action="<c:url value='/UserManageServlet'/>">
		<!-- 日付ピッカー -->
		<input type="date" name="workday" required>
		
		<!-- メッセージエリア -->
		<div class=center>
			<p id="message">
				<c:if test="${not empty message}">
					${message}
				</c:if>
			</p> 
		</div>
		
		<!-- 横並びの為div -->
		<div class=row>
			<!-- 業務選択 -->
			<div class="selectContainer">
				<div class=job_block>
				<input type="hidden" name="userId1" value="${userA.id}">
					<p>${userA.name}</p>
					<p>${pointA}</p>
					<div class=select_work>
						<select id="work" name="work1">
							<option value="">-- 選択しない --</option>
							<c:forEach items="${taskList}" var="category" varStatus="status">
								<option value="${category.id}">${category.category}</option>
							</c:forEach>
						</select>
					</div>
					<!-- 追加ボタン -->
					<button type="button" onclick="addSelect1(this)" class="button">+</button>
				</div>
				
				<div class=job_block>
				<input type="hidden" name="userId2" value="${userB.id}">
					<p>${userB.name}</p>
					<p>${pointB}</p>
					<div class=select_work>
						<select id="work" name="work2">
							<option value="">-- 選択しない --</option>
							<c:forEach items="${taskList}" var="category" varStatus="status">
								<option value="${category.id}">${category.category}</option>
							</c:forEach>
						</select>
					</div>
					<!-- 追加ボタン -->
					<button type="button" onclick="addSelect2(this)" class="button">+</button>
				</div>
				
				<div class=job_block>
				<input type="hidden" name="userId3" value="${userC.id}">
					<p>${userC.name}</p>
					<p>${pointC}</p>
					<div class=select_work>
						<select id="work" name="work3">
							<option value="">-- 選択しない --</option>
							<c:forEach items="${taskList}" var="category" varStatus="status">
								<option value="${category.id}">${category.category}</option>
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
		  	<c:forEach items="${taskList}" var="category" varStatus="status">
				<option value="${category.id}">${category.category}</option>
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
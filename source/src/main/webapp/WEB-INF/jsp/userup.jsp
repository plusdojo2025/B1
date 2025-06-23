<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報|NaviZaka</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/userup.css'/>">
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
	<!-- メッセージエリア -->
	<p id="error_message"><c:out value="${result.message}" /></p> 
	<div class=wrapper>
		<!-- 入力フォーム -->
		<form id="user_form" method="POST" action="<c:url value='/UserUpServlet' />">
			<input type="hidden" name="id" value="${user.id}">
			<table class="upload">
				<tr>
				<th><label>氏名</label></th>
				</tr>
				<tr>
				    <td><input type="text" name="name" id="name" value="${user.name}" placeholder="氏名を入力" class="form"></td>
				</tr>
				<tr>
					<th><label>ID</label></th>
				</tr>
				<tr>
					<td><input type="text" name="email" id="email" value="${user.email}" placeholder="メールアドレスを入力" class="form"></td>
				</tr>
				<tr>
					<th><label>PW<span class="tips">(英大文字・英小文字・数字の3種を含む8文字以上20字以下)</span></label></th>
				</tr>
				<tr>
					<td><input type="text" name="first_pw" id="pw1" value="${user.pw}" placeholder="パスワードを入力" class="form">
					</td>
				</tr>
				<tr>
					<th><label>PW(確認)</label></th>
				</tr>
				<tr>
					<td><input type="text" name="second_pw" id="pw" value="${user.pw}" placeholder="パスワードを入力" class="form">
					</td>
				</tr>
			</table>
			<div class=radio>
				<input type="radio" name="role" value="社員" ${user.role == '社員' ? 'checked' : ''} >社員
				<input type="radio" name="role" value="アルバイト" ${user.role == 'アルバイト' ? 'checked' : ''}>アルバイト
			</div>
			<input type="submit"  class="button" name="submit" value="変更">
		</form>
	</div>
	
<!-- フッダー(ここから) -->
	<footer>
		<p class="copyright">&copy;せんこうはなび</p>
	</footer>
<!-- フッダー(ここまで) -->
</body>
<script src="<c:url value='/js/userup.js'/>"></script>
</html>
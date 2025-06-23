<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マニュアル作成|NaviZaka</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/manumake.css'/>">
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
<div class=area>
<table>
<tr>
<!-- プロンプト表示フォーム -->
<td>
<textarea id="prompt" name="prompt">${prompt}</textarea>
<br>
<!-- コピーボタン -->
<div class="manumake">
<button type="button" class="button" onclick="copy()">コピー</button> 
</div>
</td>
<!-- マニュアル本体保存フォーム -->
<form id="manual_form" method="POST" action="<c:url value='/ResultServlet' />">
<td>
<!-- カテゴリId取得 -->
<input type="hidden" name="category_id" value="${category_id}">
<!-- タスクId取得 -->
<input type="hidden" name="task_id" value="${task_id}">
<textarea id="manual" name="manual" placeholder="生成されたマニュアル本文を貼り付けてください"></textarea>
<br>
<!-- 保存ボタン -->
<div class="manumake">
<input type="submit"  class="button" name="submit"  value="保存">
</div>
</form>
</td>
</div>
</table>
</div>
  <!-- フッダー(ここから) -->
  <footer>
    <p class="copyright">&copy;せんこうはなび</p>
  </footer>
  <!-- フッダー(ここまで) -->
</body>
<script src="<c:url value='/js/form.js'/>"></script>
</html>
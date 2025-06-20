<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マニュアル作成|NaviZaka</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/manumake.css'/>">
</head>
<body>
  <!-- ヘッダー（ここから） -->
<header>
		<a href="/B1/LoginServlet">
			<img src="img/logo.png" alt="NaviZaka"  height="130">
		</a>
		<nav>
			<ul>
			<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
			<li><a href="<c:url value='/ManuListServlet' />">マニュアル一覧</a></li>
			<li><a href="<c:url value='/UserUpServlet' />">ユーザー情報</a></li>
			<li><a href="<c:url value='/LoginServlet' />"><img src="img/logout.png" alt="ログアウト" width="100"></a>
			</ul>
		</nav>
	</header>
  <!-- ヘッダー（ここまで） -->
  <div class="wrapper">
  <table>
<tr>
<!-- プロンプト表示フォーム -->
<td>
<textarea id="error_message" name="prompt">${prompt}</textarea>
<br>
<div class=area>
<!-- コピーボタン -->
<div class="manumake">
<button type="submit" class="button" onclick="copy()">コピー</button> 
</div>
</td>
<!-- マニュアル本体保存フォーム -->
<form id="manual_form" method="POST" action="<c:url value='/ResultServlet' />">
<td>
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
</html>
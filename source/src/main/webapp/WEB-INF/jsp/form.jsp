<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マニュアル作成|NaviZaka</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/form.css'/>">
</head>
<body>
 <!-- ヘッダー（ここから） -->
<header>
		<a href="<c:url value='/HomeServlet'/>">
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
  
<div class="wrapper">
<p id="error_message">${result}</p>
<form id="prompt_form" method="POST" action="<c:url value='/PromptServlet' />">
<table class="make">
<tr>
<!-- カテゴリ -->
<th rowspan="2">カテゴリ</th>
<td rowspan="2">
<div>
	<select id="category" name="category">
	<c:forEach items="${categoList}" var="category" varStatus="status">
			<option value="${category.category}">${category.category}</option>
	</c:forEach>
	</select>
</div>
</td>
<!-- 業務名 -->
<th rowspan="2">業務名</th>
<td rowspan="2"><input type="text" name="task" id="task" style="width: 150px; placeholder="業務名を入力" class="form"></td>
<!-- 目標時間 -->
<th class="time">目標時間</th>
<td class="time2">
 分：
<input type="button"  name="min" value="10" style="width: 50px;" onclick="AddTime(this)" />
<input type="button"  name="min" value="1" style="width: 50px;" onclick="AddTime(this)" />
</td>
</tr>
<tr>
<td class="time"><input type="text" name="min" id="minutes" size="1" value="0" class="form">:
    <input type="text" name="sec" id="sec" size="1" value="0" class="form"></td>
<td class="time2">
 秒：
 <input type="button" name="sec" value="30" style="width: 50px;" onclick="AddTime(this)" />
 <input type="button" name="sec" value="1" style="width: 50px;" onclick="AddTime(this)" />
</td>
</tr>
<!-- 場所 -->
<tr>
<th rowspan="2">場所</th>
<td rowspan="2">
<div id="place-data">
	<select id="place" name="place">
        <c:forEach items="${placeList}" var="place" varStatus="status">
			<option value="${place.place}">${place.place}</option>
		</c:forEach>
	</select>
</div>
<br>
<!-- 追加ボタン -->
<button type="button" onclick="AddPlaceSelect(this)" class="button">+</button>
</td>
<!-- 道具 -->
<th rowspan="2">使用物</th>
<td rowspan="2">
<div id="tool-data">
	<select id="tool" name="tool">
        <c:forEach items="${tooList}" var="tool" varStatus="status">
			<option value="${tool.tool}">${tool.tool}</option>
		</c:forEach>
	</select>
</div>
<br>
<!-- 追加ボタン -->
<button type="button" onclick="AddToolSelect(this)" class="button">+</button>
</td>
<!-- 手順 -->
<th rowspan="2" class="time">手順</th>
<td class=process_work rowspan="2" class="time2"><input type="text" name="process" id="process" class="form">
<br>
<!-- 追加ボタン 手順フォームの真下に置く-->
<button type="button" onclick="addForm(this)" class="button">+</button></td>
</tr>
</table>
<div class="manumake">
<input type="submit"  class="button" name="submit"  value="プロンプト作成">
</div>
</form>
</div>
  <!-- フッダー(ここから) -->
  <footer>
    <p class="copyright">&copy;せんこうはなび</p>
  </footer>
  <!-- フッダー(ここまで) -->
</body>
<script src="<c:url value='/js/form.js'/>"></script>
</html>
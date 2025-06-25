<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マニュアル更新 | NaviZaka</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/manuup.css'/>">
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

	<!-- メッセージエリア -->
	<p id="message">
		<c:if test="${not empty message}">${message}</c:if>
	</p>

	<!-- required=必ず選択させる。選択していないと警告が表示される。 -->
	<form id="manual_form" method="POST"
		action="<c:url value='/ManuUpServlet' />">


				<!-- カテゴリ -->

					<div id="category-data">
						<select id="work" name="work1">
							<option value="" disabled selected>カテゴリを選択してください</option>
							<c:forEach items="${CategorieList}" var="category" varStatus="status">
								<option value="${category.id}">${category.category}</option>
							</c:forEach>							
						</select>

					</div> 
					<!-- 業務名 -->
					<div id="task-data">
						<select name="taskId" id="task">
 							<option value="" disabled selected>業務を選択してください</option>
								<c:forEach var="task" items="${TaskList}">
									<option value="${task.id}">${task.task}</option>
								</c:forEach> 
						</select>
					</div>
		<input type="reset" value="リセット">
		<input type="submit" value="絞り込む">

		<!-- 評価 -->
		<div>
			累計： <span class="star" onclick="setRating(1)">☆</span> <span
				class="star" onclick="setRating(2)">☆</span> <span class="star"
				onclick="setRating(3)">☆</span> <span class="star"
				onclick="setRating(4)">☆</span> <span class="star"
				onclick="setRating(5)">☆</span> <input type="hidden" name="rating"
				id="rating" value="0">
				${review_score}
		</div>
		<!-- 評価 -->
		<div>
			更新後： <span class="star" onclick="setRating(1)">☆</span> <span
				class="star" onclick="setRating(2)">☆</span> <span class="star"
				onclick="setRating(3)">☆</span> <span class="star"
				onclick="setRating(4)">☆</span> <span class="star"
				onclick="setRating(5)">☆</span> <input type="hidden" name="rating"
				id="rating" value="0">
				${review_half_score}
		</div>
	<br>
		
<!-- テキストエリア -->
				<textarea name="bodys" id="body" >${ManuBody.manualBody}</textarea>
				<br>
<!-- コメントエリア -->
				<c:forEach var="e" items="${comments}" >
				<textarea name="comments" id="comment" class="text" readonly>${e}</textarea>
				</c:forEach>

	<br>
		<input type="hidden" name="manualId" value="${manual.id}" />
  		<input type="submit" value="更新" />
	</form>
	
	<!-- フッダー(ここから) -->
	<footer>
		<p class="copyright">&copy;せんこうはなび</p>
	</footer>
	<!-- フッダー(ここまで) -->

	<script>

  /* 項目追加の処理 */
  function addOption() {
	    const input = document.getElementById("input-text");
	    const datalist = document.getElementById("options");
	    const value = input.value.trim();

	    // 既存オプションの重複チェック
	    const exists = Array.from(datalist.options).some(opt => opt.value === value);

	    if (value && !exists) {
	      const newOption = document.createElement("option");
	      newOption.value = value;
	      datalist.appendChild(newOption);
	      input.value = ""; // 入力欄をクリア
	    } else if (exists) {
	      alert("すでに存在する項目です。");
	    }
	  }
  
  
</script>
</body>
</html>
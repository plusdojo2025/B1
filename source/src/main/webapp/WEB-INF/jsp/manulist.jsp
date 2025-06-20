<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マニュアル一覧|NaviZaka</title>
<link rel="stylesheet" href="<c:url value='/css/manulist.css' />">
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
  
　　<!-- ループ -->
<c:forEach var="entry" items="${manualMap}">
 
 <!-- カテゴリ見出し（開閉） -->
 <div class="category" onclick="toggleManual('manual-${entry.key}')">
  ▼ ${entry.key}
 </div>
 
 <!-- カテゴリ内のマニュアル一覧 -->
 <div class="manual-content" id="manual-${entry.key}" style="display:none;">
  <c:forEach var="manual" items="${entry.value}">
   <p class="task-line">
    <span class="task-name">
     <a href="ManuDetailServlet?manualId=${manual.id}">
      ${manual.taskName}
     </a>
    </span>
    <span class="task-date">
     <fmt:formatDate value="${manual.createDate}" pattern="yyyy/MM/dd" />
    </span>
   </p>
  </c:forEach>
 </div>
</c:forEach>

  <!-- フッダー(ここから) -->
  <footer>
  <p class="copyright">&copy;せんこうはなび</p>
  
  </footer>
  <script src="<c:url value='/js/manulist.js' />"></script>
  </body>
<!-- フッダー(ここまで) -->
</html>
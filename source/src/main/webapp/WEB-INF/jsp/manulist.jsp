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
<script src="<c:url value='/js/manulist.js' />"></script>
</head>
<body>
  <!-- ヘッダー（ここから） -->
  <header>
  　<a href="/B1/LoginServlet"><img src="img/logo.png"alt="ロゴ" class="logo"></a>
 
    <nav>
    <ul>
     <li><a href="/B1/LoginServlet">ホーム</a></li>
     <li><a href="/B1/ManuListServlet">マニュアル一覧</a></li>
     <li><a href="/B1/UserUpServlet">ユーザー情報</a></li>
    </ul>
   </nav>
   
   <a href="/B1/LoginServlet"><img src="img/logout.png"alt="ログアウト" class="logout"></a>

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
     <a href="ManuDetailServlet?task=${manual.taskName}">
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
  </body>
<!-- フッダー(ここまで) -->
</html>
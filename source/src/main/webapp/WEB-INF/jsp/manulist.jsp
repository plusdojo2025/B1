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
  
   <div class="manual-section">
   
    <!-- JSTLでループ開始。-->
    <c:set var="currentCategory" value="" />
    
    <c:forEach var="manual" items="${manuList}" varStatus="status">
    
     <!-- 新規作成 -->
     <c:if test="${manual.categoryName != currentCategory}">
       <!-- 更新 -->
       <c:set var="currentCategory" value="${manual.categoryName}" />
        <!-- クリックで開閉 -->
        <div class="category" onclick="toggleManual('manual-${manual.categoryName}')">
                ▼ ${manual.categoryName}
        </div>
        
        <div class="manual-content" id="manual-${manual.categoryName}" style="display:none;">
         
         <!-- 業務名、日付を表示 -->
         <p class="task-line">
            <!-- 業務名はクリックで詳細ページへリンク（後で詳細URLに修正） -->
            <span class="task-name">
            <a href="ManualDetailServlet?task=${manual.taskName}">
             ${manual.taskName}
            </a>
            </span>
            <span class="task-date">
             <fmt:formatDate value="${manual.createDate}" pattern="yyyy/MM/dd" />
            </span>
         </p>
         
         <c:if test="${status.last || manuList[status.index + 1].categoryName != manual.categoryName}">
         </c:if>
        </div>     
     </c:if>
    </c:forEach>
   </div>

  <!-- フッダー(ここから) -->
  <footer>
  <p class="copyright">&copy;せんこうはなび</p>
  
  </footer>
  </body>
<!-- フッダー(ここまで) -->
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報|NaviZaka</title>
<link rel="Stylesheet" href="/B1/css/manucheck.css">
<script src="/B1/js/manucheck.js"></script>
</head>
<body>
  <!-- ヘッダー（ここから） -->
  <header>
  　<a href="/B1/LoginServlet"><img src="img/logo.png"alt="ロゴ" class=logo></a>
 
    <nav>
    <ul>
     <li><a href="/B1/LoginServlet">ホーム</a></li>
     <li><a href="/B1/ManuListServlet">マニュアル一覧</a></li>
     <li><a href="/B1/UserUpServlet">ユーザー情報</a></li>
    </ul>
   </nav>
   
   <a href="/B1/LoginServlet"><img src="img/logout.png"alt="ログアウト" class=logout></a>

  </header>
  <!-- ヘッダー（ここまで） -->
  <section class="category-name">
  <h2>${taskName}</h2>
  </section>
  <main>
   <pre class="manual-body">${manualBody}</pre>
   
   <form action="${pageContext.request.contextPath}/CompleteServlet" method="post" class="complete-form">
        <input type="hidden" name="categoryId" value="${categoryId}" />
        <button type="submit" class=button>完了</button>
    </form>
  </main>
  <!-- フッダー(ここから) -->
  <footer>
  <p class="copyright">&copy;せんこうはなび</p>
  </footer>
<!-- フッダー(ここまで) -->
</body>
</html>
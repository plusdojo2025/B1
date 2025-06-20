<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>リザルト（仮）</title>
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
  
  <div class="result-container">
   <h2>マニュアルを登録しました！</h2>
   
   <!-- 登録されたマニュアル表示 -->
   <textarea class="manual-body" readonly></textarea>
   
   <!-- ホームに戻るボタン -->
   <form action="B1/LoginServlet" method="get">
    <button type="submit" class="button">ホームに戻る</button>
   </form>
  </div>
 <!-- フッダー(ここから) -->
  <footer>
  <p class="copyright">&copy;せんこうはなび</p>
  
  </footer>
  </body>
<!-- フッダー(ここまで) -->
</body>
</html>
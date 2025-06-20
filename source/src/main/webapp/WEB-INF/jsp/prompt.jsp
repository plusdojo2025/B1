<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロンプト表示（仮）</title>
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
  <div class="manual-container">
   <!-- プロンプト表示 -->
   <div class="manual-prompt">
    <h2>プロンプト</h2>
    <textarea id="displayArea"></textarea>
    <br>
    <button type="button" id="copyBtn">コピー</button>
   </div>
   
   <!-- マニュアル入力 -->
   <div class="manual-body">
    <h2>マニュアル入力</h2>
    <form action="manual" method="post">
     <textarea name="newManual" id="inputArea" placeholder="生成されたマニュアルを入力してください..."></textarea>
     <br>
     <button type="submit">登録</button>
    </form>
   </div>
  </div>
  <script src="<c:url value='/js/prompt.js' />"></script>

</body>
</html>
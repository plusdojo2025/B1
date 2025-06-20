<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム</title>
<link rel="stylesheet" type="text/css" href="/B1/css/common.css">
</head>
<body>
 <!-- ヘッダー -->
	<header>
		<a href="/B1/LoginServlet">
			<img src="img/logo.png" alt="NaviZaka"  height="130">
		</a>
		<nav>
			<ul>
			<li><a href="/B1/LoginServlet">ホーム</a></li>
			<li><a href="/B1/ManuListServlet">マニュアル一覧</a></li>
			<li><a href="/B1/UserUpServlet">ユーザー情報</a></li>
			<li><a href="/B1/LoginServlet"><img src="img/logout.png" alt="ログアウト" width="100"></a>
			</ul>
		</nav>
	</header>
 
 <!--ログイン者名表示 -->
   <p><span id="username"></span></p>
   
   <div class=center>
 <!--　マニュアル更新依頼 -->
   <p>マニュアル更新依頼<span id="request-count" class="badge">0</span></p>
　<!-- 今日のアルバイト表示 -->
   <p>今日のアルバイト<p>
　<!-- 各種ボタン -->
       <!-- <input type="submit"  class="button" name="submit" value="マニュアル作成">
       <input type="submit"  class="button" name="submit" value="ユーザー管理"> -->
		<button class="button" name="submit" value="マニュアル作成" onclick="location.href='${pageContext.request.contextPath}/ManuMakeServlet'">マニュアル作成</button>
		<button class="button" name="submit" value="ユーザー管理" onclick="location.href='${pageContext.request.contextPath}/UserManageServlet'">ユーザー管理</button>
       </div>
   
      
      
  <!-- フッダー(ここから) -->
        <footer>
        <p class="copyright">&copy;せんこうはなび</p>
        </footer>
  <!-- フッダー(ここまで) -->
   <script>
    // サーバーから取得したログインユーザー名（仮のJavaScript　実際はJava）
    const loggedInUserName = "月島陽";

    // HTMLに表示
    document.getElementById("username").textContent = loggedInUserName;
    
    // 疑似APIから更新依頼件数を取得する（仮のJavaScript 実際はJavaかapiを利用）
    async function fetchRequestCount() {
      try {
        // ここでは仮のエンドポイント
        const response = await fetch('/api/request-count'); // ← サーバーから取得
        const data = await response.json();
        document.getElementById('request-count').textContent = data.count;
      } catch (error) {
        console.error('件数の取得に失敗しました', error);
      }
    }

    // ページ読み込み時に実行
    fetchRequestCount();

    // 30秒ごとに件数を更新
    setInterval(fetchRequestCount, 30000);
  </script>
</body>
</html>
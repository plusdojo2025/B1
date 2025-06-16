<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報|NaviZaka</title>
<link rel="Stylesheet" href="/B1/css/UserUp.css">
</head>
<body>
  <!-- ヘッダー（ここから） -->
  <header>
  <div class="header">
  <div class="logo">
  　<a href="/B1/LoginServlet"><img src="img/logo.png"alt="ロゴ"></a>
  </div>
  <nav class="nav">
    <ul>
     <li><a href="/B1/LoginServlet">ホーム</a></li>
     <li><a href="/B1/ManuListServlet">マニュアル一覧</a></li>
     <li><a href="/B1/UserUpServlet">ユーザー情報</a></li>
    </ul>
   </nav>
   <div class="logout"> 
   <a href="/B1/LoginServlet"><img src="img/logo.png"alt="ログアウト"></a>
  </div>  
   </div>
  </header>
  <!-- ヘッダー（ここまで） -->
  <div class="wrapper">
  <!-- メッセージエリア -->
  <p id="message">氏名が入力されていません。</p> 
  <!-- 入力フォーム -->
  <form id="user_form" method="POST" action="/B1/UserUpServlet">
    <table class="upload">
      <tr>
        <th><label>氏名</label></th>
      </tr>
      <tr>
        <td><input type="text" name="name" id="name" placeholder="氏名を入力" class="form"></td>
      </tr>
      <tr>
        <th><label>ID</label></th>
      </tr>
      <tr>
        <td><input type="text" name="email" id="email" placeholder="メールアドレスを入力" class="form"></td>
      </tr>
      <tr>
        <th><label>PW<span class="tips">(英大文字・英小文字・数字の3種を含む8文字以上20字以下)</span></label></th>
      </tr>
      <tr>
        <td><input type="password" name="pw" id="pw" placeholder="パスワードを入力" class="form"></td>
      </tr>
            <tr>
        <th><label>PW(確認)</label></th>
      </tr>
      <tr>
        <td><input type="password" name="pw" id="pw" placeholder="パスワードを入力" class="form"></td>
      </tr>
      </table>
       <div class=radio>
        <input type="radio" name="num_of_inq" value="社員">社員
		<input type="radio" name="num_of_inq" value="アルバイト">アルバイト
	  </div>
	  <div class=button>
       <input type="submit"  class="button" name="submit" value="変更">
      </div>
      
     
  </form>
  </div>
  <!-- フッダー(ここから) -->
  <footer>
  <p class="copyright">&copy;せんこうはなび</p>
  </footer>
<!-- フッダー(ここまで) -->
</body>
</html>
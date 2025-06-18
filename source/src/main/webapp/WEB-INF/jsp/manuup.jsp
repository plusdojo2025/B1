<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マニュアル更新|NaviZaka</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
</head>
<body>
<!-- ヘッダー（ここから） -->
<header>
<%-- 
<a href="/B1/LoginServlet"><img src="<c:url value='/images/logo.png'alt="ロゴ" />"></a>
 --%>
<a href="/B1/LoginServlet"><img src="img/logo.png"alt="ロゴ" height="130" width="400"></a>
   <nav>
    <ul>
     <li><a href="/B1/LoginServlet">ホーム</a></li>
     <li><a href="/B1/ManuListServlet">マニュアル一覧</a></li>
     <li><a href="/B1/UserUpServlet">ユーザー情報</a></li>
     
    </ul>
   </nav>
   	<a href="/B1/LoginServlet"><img src="img/logout.png"alt="ログアウト"></a>

</header>
  <!-- ヘッダー（ここまで） -->
	<p id="message">メッセージエリア</p>
<br>
<select name="category" required>
  <option value="" disabled selected>カテゴリを選択してください</option>
  <option value="dog">犬</option>
  <option value="cat">猫</option>
  <option value="rabbit">うさぎ</option>
</select>

	<table>
      <tr>
        <td>
        	<input type="text" name="name" id="name" placeholder="カテゴリ（キッチンなど）" class="form">
        </td>
      	<td>
      		<p>累計</p>
      		<div id="stars">
        	<span class="star" data-star="1">☆</span>
        	<span class="star" data-star="2">☆</span>
        	<span class="star" data-star="3">☆</span>
        	<span class="star" data-star="4">☆</span>
        	<span class="star" data-star="5">☆</span>
    		</div>
      	</td>
      </tr>
    </table>
    <table>
      <tr>
        <td>
        	<input type="text" name="name" id="name" placeholder="業務名（皿洗いなど）" class="form">
        </td>
      	<td>
      		<p>更新後</p>
      		<div id="stars">
        	<span class="star" data-star="1">☆</span>
        	<span class="star" data-star="2">☆</span>
        	<span class="star" data-star="3">☆</span>
        	<span class="star" data-star="4">☆</span>
        	<span class="star" data-star="5">☆</span>
    		</div>
      	</td>
      </tr>
    </table>
	<input type="text" id="name" name="name">
  	<button type="submit" style="background-color: red; color: white;">いいね</button>
	<br>
	<textarea id="message" name="message" rows="5" cols="40">テキスト表示エリア</textarea>
	<br>
	<button type="submit">更新</button>
	
  <!-- フッダー(ここから) -->
  <footer>
  	<p class="copyright">&copy;せんこうはなび</p>
  </footer>
<!-- フッダー(ここまで) -->
</body>
</html>
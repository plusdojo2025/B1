<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マニュアル更新|NaviZaka</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/manuup.css'/>">
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

<!-- required=必ず選択させる。選択していないと警告が表示される。 -->
<form>
	<table>
      <tr>
        <td>
        	<select name="category" required>
  					<option value="" disabled selected>カテゴリを選択してください</option>
  					<option value="dog">犬</option>
  					<option value="cat">猫</option>
  					<option value="rabbit">うさぎ</option>
			</select>
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
        	<select name="category" required>
  				<option value="" disabled selected>業務名を選択してください</option>
  				<option value="dog">犬</option>
  				<option value="cat">猫</option>
  				<option value="rabbit">うさぎ</option>
			</select>        	
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
  	<button type="submit">いいね</button>
	<br>
	<textarea id="message" name="message" rows="5" cols="40">テキスト表示エリア</textarea>
	<br>
	<button type="submit">更新</button>
</form>


<br>
<!-- プルダウン＋テキストボックス共用 -->
<input type="text" id="input-text" list="options" placeholder="選択または入力">
<datalist id="options">
  <option value="りんご">
  <option value="ばなな">
  <option value="みかん">
</datalist>
<br>
<button onclick="addOption()">追加</button>

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
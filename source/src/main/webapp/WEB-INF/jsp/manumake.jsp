<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マニュアル作成|NaviZaka</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/manumake.css'/>">

</head>
<body>
  <!-- ヘッダー（ここから） -->
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
  <!-- ヘッダー（ここまで） -->
<body>
<div class="wrapper">
<p id="error_message">メッセージエリア</p>

<form id="manual_form" method="POST" action="<c:url value='/ManuMakeServlet' />">
<table class="make">
<tr>
<!-- カテゴリ -->
<th rowspan="2">カテゴリ</th>
<td rowspan="2">
<div>
	<select id="category" name="category">
        <c:forEach items="${categoList}" var="category" varStatus="status">
			<option value="${status.index + 1}">${category.category}</option>
			<input type="hidden" name="category_id" value="${category.id}">
		</c:forEach>
	</select>
</div>
</td>
<!-- 業務名 -->
<th rowspan="2">業務名</th>
<td rowspan="2"><input type="text" name="task" id="task" placeholder="業務名を入力" class="form"></td>
<!-- 目標時間 -->
<th>目標時間</th>
<td>
 分：
<input type="button" name="min" value="10" style="width: 50px;" onclick="AddTime(this)" />
<input type="button" name="min" value="1" style="width: 50px;" onclick="AddTime(this)" />
</td>
</tr>
<tr>
<td><input type="text" name="minutes" id="minutes" size="1" value="0" class="form">:
    <input type="text" name="sec" id="sec" size="1" value="0" class="form"></td>
<td>
 秒：
 <input type="button" name="sec" value="30" style="width: 50px;" onclick="AddTime(this)" />
 <input type="button" name="sec" value="1" style="width: 50px;" onclick="AddTime(this)" />
</td>
</tr>
<!-- 場所 -->
<tr>
<th rowspan="2">場所</th>
<td rowspan="2">
<div id="place-data">
	<select id="place" name="place">
        <c:forEach items="${placeList}" var="place" varStatus="status">
			<option value="${status.index + 1}">${place.place}</option>
			<input type="hidden" name="number" value="${place.id}">
		</c:forEach>
	</select>
</div>
<br>
<!-- 追加ボタン -->
<button type="button" onclick="AddPlaceSelect(this)" class="button">+</button>
</td>
<!-- 道具 -->
<th rowspan="2">使用物</th>
<td rowspan="2">
<div id="tool-data">
	<select id="tool" name="tool">
        <c:forEach items="${tooList}" var="tool" varStatus="status">
			<option value="${status.index + 1}">${tool.tool}</option>
			<input type="hidden" name="number" value="${tool.id}">
		</c:forEach>
	</select>
</div>
<br>
<!-- 追加ボタン -->
<button type="button" onclick="AddToolSelect(this)" class="button">+</button>
</td>
<!-- 手順 -->
<th rowspan="2">手順</th>
<span class=process_work>
<td rowspan="2"><input type="text" name="process" id="process" class="form"></td>
</span>
</tr>
<tr>
<td></td>
</tr>
<tr>
<!-- 追加ボタン 手順フォームの真下に置く-->
<td colspan="5"></td>
<td><button type="button" onclick="addForm(this)" class="button">+</button></td>
</tr>
</table>
<div class="manumake">
<input type="submit"  class="button" name="submit"  value="プロンプト作成">
</div>
</form>
<table>
<tr>
<!-- プロンプト表示フォーム -->
<td>
<textarea id="prompt" name="prompt" placeholder="生成されたプロンプトが表示されます。"></textarea>
<br>
<div class=area>
<!-- コピーボタン -->
<div class="manumake">
<button type="submit" class="button" onclick="copy()">コピー</button> 
</div>
</td>
<!-- マニュアル本体保存フォーム -->
<td>
<textarea id="manual" name="manual" placeholder="生成されたマニュアル本文を貼り付けてください"></textarea>
<br>
<!-- 保存ボタン -->
<div class="manumake">
<input type="submit"  class="button" name="submit"  value="保存">
</div>
</td>
</div>
</table>

</div>
</body>
  <!-- フッダー(ここから) -->
  <footer>
  <p class="copyright">&copy;せんこうはなび</p>
  </footer>
<!-- フッダー(ここまで) -->
<script>
let formObj = document.getElementById('manual_form');

// 時間表示＆60上超えたら繰り上げ
function AddTime(button) {
	  const minBox = document.getElementById("minutes");
	  const secBox = document.getElementById("sec");

	  let minutes = parseInt(minBox.value) || 0;
	  let seconds = parseInt(secBox.value) || 0;
	  const value = parseInt(button.value);

	  if (button.name === "min") {
	    minutes += value;
	  } else if (button.name === "sec") {
	    seconds += value;
	    
	    // 秒が60以上なら分に繰り上げ
	    if (seconds >= 60) {
	      minutes += Math.floor(seconds / 60);
	      seconds = seconds % 60;
	    }
	  }

	  // 更新
	  minBox.value = minutes;
	  secBox.value = seconds;
	}
	
//使用物プルダウン追加
function AddToolSelect(button) {
  //使用物のセレクトを取得
  const select = document.querySelectorAll('select[name="tool"]')
  // セレクトの中に入れる選択肢のHTML
  const optionsHtml = document.getElementById("tool-data")?.innerHTML || "";

  // 一番最後の input を取得
  const lastSelect = select[select.length - 1];

  // 新しい select 要素を作成
  const newSelect = document.createElement('select');
  newSelect.name = "tool";
  newSelect.innerHTML = optionsHtml;
  newSelect.style.display = 'block'; // 改行されるようにする（見やすく）

  // 一番最後の input のあとに追加
  lastSelect.parentNode.insertBefore(newSelect, lastSelect.nextSibling);
}

//場所プルダウン追加
function AddPlaceSelect(button) {
  //使用物のセレクトを取得
  const select = document.querySelectorAll('select[name="place"]')
  // セレクトの中に入れる選択肢のHTML
  const optionsHtml = document.getElementById("place-data")?.innerHTML || "";

  // 一番最後の input を取得
  const lastSelect = select[select.length - 1];

  // 新しい select 要素を作成
  const newSelect = document.createElement('select');
  newSelect.name = "place";
  newSelect.innerHTML = optionsHtml;
  newSelect.style.display = 'block'; // 改行されるようにする（見やすく）

  // 一番最後の input のあとに追加
  lastSelect.parentNode.insertBefore(newSelect, lastSelect.nextSibling);
}

// 手順フォーム追加
function addForm(button) {
  // すべての input[type="text"] を取得
  const inputs = document.querySelectorAll('input[type="text"]');
  

  // 一番最後の input を取得
  const lastInput = inputs[inputs.length - 1];

  // 新しい input 要素を作成
  const newInput = document.createElement('input');
  newInput.type = 'text';
  newInput.name = 'dynamic_input'; // 必要なら name をつける
  newInput.style.display = 'block'; // 改行されるようにする（見やすく）

  // 一番最後の input のあとに追加
  lastInput.parentNode.insertBefore(newInput, lastInput.nextSibling);
}

//テキストエリア内のテキストをコピー
function copy() {
    // コピー対象をJavaScript上で変数として定義する
    var copyText = document.getElementById("prompt");

    // コピー対象のテキストを選択する
    copyText.select();

    // 選択しているテキストをクリップボードにコピーする
    document.execCommand("Copy");

}

 </script>
</html>
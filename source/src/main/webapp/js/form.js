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
  const select = document.querySelectorAll('select[name="tool"]');
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
  const select = document.querySelectorAll('select[name="place"]');
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
  newInput.name = 'process'; // 必要なら name をつける
  newInput.style.display = 'block'; // 改行されるようにする（見やすく）

  // 一番最後の input のあとに追加
  lastInput.parentNode.insertBefore(newInput, lastInput.nextSibling);
}

//テキストエリア内のテキストをコピー
function copy() {
  const copyText = document.getElementById("prompt");

  navigator.clipboard.writeText(copyText.value).then(() => {
    alert("コピーしました！");
  }).catch(err => {
    alert("コピーに失敗しました：" + err);
  });
}

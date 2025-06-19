// セレクトの中に入れる選択肢のHTML（JSPで出力してくれる前提）
const optionsHtml = document.getElementById("options-data")?.innerHTML || "";

function addSelect(button) {
  // ボタンのすぐ前の select_work を探す
  const container = button.previousElementSibling;

  // 新しい select を作る
  const newDiv = document.createElement("div");
  newDiv.className = "select_work";

  const newSelect = document.createElement("select");
  newSelect.name = "work";
  newSelect.innerHTML = optionsHtml;

  newDiv.appendChild(newSelect);

  // 新しいセレクトをボタンの前に追加
  button.parentNode.insertBefore(newDiv, button);
}

	function clearFormInputs() {
		  const form = document.getElementById('manual_form');

    // セレクトボックスをリセット（先頭に戻す）
    form.querySelectorAll('select').forEach(select => {
      select.selectedIndex = 0;
    });

    // テキストエリアの内容をクリア
    form.querySelectorAll('textarea').forEach(textarea => {
      textarea.value = '';
    });

    // テキスト入力をクリア（もしあれば）
    form.querySelectorAll('input[type="text"]').forEach(input => {
      input.value = '';
    });

    // 星評価のクリア
    document.getElementById('rating').value = 0;
    document.querySelectorAll('.star').forEach(star => {
      star.textContent = '☆'; // 初期の表示に戻す
    });
  }

	//絞り込むボタンの処理（サーバーに送られる前に処理を行う）
	  document.getElementById("manual_form").addEventListener("submit", function(e) {
		    const category = document.getElementById("work").value;
		    const task = document.getElementById("task").value;

		    if (!category || !task) {
		      e.preventDefault(); // フォーム送信をキャンセル
		      alert("カテゴリと業務を両方選択してください。");
		      return false;
		    }

		    return true;
		  });
	
	  
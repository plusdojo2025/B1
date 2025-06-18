document.addEventListener('DOMContentLoaded', () => {
  const completeButton = document.getElementById('completeButton');

  completeButton.addEventListener('click', (e) => {
    // 完了ボタン押したら確認ダイアログを出す
    const confirmed = window.confirm('本当に完了にしますか？');
    if (!confirmed) {
      e.preventDefault(); // キャンセルしたらフォーム送信を止める
    }
  });
});

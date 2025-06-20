//表示エリアの内容をコピーする処理
document.addEventListener('DOMContentLoaded', () => {
    const copyBtn = document.getElementById('copyBtn');
    const displayArea = document.getElementById('displayArea');

    copyBtn.addEventListener('click', () => {
        const text = displayArea.value;

        navigator.clipboard.writeText(text)
            .then(() => {
                alert("文書をクリップボードにコピーしました！");
            })
            .catch((err) => {
                console.error("コピーに失敗:", err);
                alert("コピーに失敗しました。ブラウザの設定を確認してください。");
            });
    });
});
function validateForm() {
    const id = document.getElementById("id").value.trim();
    const pw = document.getElementById("pw").value.trim();
    const msgElem = document.getElementById("message");

    if (!id) {
        msgElem.textContent = "IDを入力してください";
        return false;
    }
    if (!pw) {
        msgElem.textContent = "パスワードを入力してください";
        return false;
    }
    return true;
}
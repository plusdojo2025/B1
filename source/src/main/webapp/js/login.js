window.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("idpas");
    const message = document.getElementById("message");

    form.addEventListener("submit", function (e) {
        const id = document.getElementById("id").value.trim();
        const pw = document.getElementById("pw").value.trim();

        // メッセージクリア
        message.textContent = "";

		if(id === "" && pw ===""){
			message.textContent = "USER NAMEとパスワードを入力してください。";
            e.preventDefault();
            return;
		}

        if (id === "") {
            message.textContent = "USER NAMEを入力してください。";
            e.preventDefault();
            return;
        }

        if (pw === "") {
            message.textContent = "パスワードを入力してください。";
            e.preventDefault();
        }
    });
});

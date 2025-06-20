package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import dto.Users;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 登録画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文字エンコーディング設定
		request.setCharacterEncoding("UTF-8");

		// 入力値を取得
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String role = request.getParameter("role");

		// DTO生成（id=0 → AUTO_INCREMENT用）
		Users newUser = new Users(0, name, email, pw, role);

		// 登録実行
		UsersDao dao = new UsersDao();
		boolean result = dao.insert(newUser);

		if (result) {
		    // 登録成功 → ログイン画面にフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		    dispatcher.forward(request, response);
		} else {
		    // 登録失敗 → エラー表示
		    request.setAttribute("errorMsg", "登録に失敗しました。入力内容をご確認ください。");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
		    dispatcher.forward(request, response);
		}
	}
}
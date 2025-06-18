package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import dto.Result;
import dto.Users;

/**
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/UserUpServlet")
public class UserUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/B1/LoginServlet");
			return;
		}
		
		// ユーザー情報の取得
		// ログインサーブレットから渡されたemail情報を受け取る
		String email = (String)session.getAttribute("email");
		UsersDao uDao = new UsersDao();
		Users user = uDao.userInfo(email);
		session.setAttribute("user", user);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userup.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String role = request.getParameter("role");
		
		//更新処理を行う
		UsersDao UserDao = new UsersDao();
		if (UserDao.update(new Users(id,name, email, pw, role))) { // 更新成功
			request.setAttribute("result", new Result("更新成功！", "ユーザー情報を更新しました。", "/B1/UserUpServlet"));
		} else { // 更新失敗
				request.setAttribute("result", new Result("更新失敗！", "ユーザー情報を更新できませんでした。", "/B1/UserUpServlet"));
		}
		
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userup.jsp");
		dispatcher.forward(request, response);
	}
}



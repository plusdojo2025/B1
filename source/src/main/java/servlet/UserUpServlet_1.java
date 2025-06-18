package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import dao.BcDAO;
//import dto.Bc;

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
		//HttpSession session = request.getSession();
		//if (session.getAttribute("id") == null) {
		//	response.sendRedirect("/webapp/LoginServlet");
		//	return;
		//}
		
		// ユーザー情報の取得
		LoginUser  = (LoginUser)session.getAttribute("email");
		String userId = lu.getName();
		UsersDao UserDao = new UsersDAO();
		String userName = iDao.username(userId);
		session.setAttribute("username", userName);
		

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUp.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String role = request.getParameter("role");
		
		//更新処理を行う
		UsersDao UserDao = new UsersDAO();
		if (UserDao.update(new User(name, email, pw, role))) { // 更新成功
		//	request.setAttribute("result", new Result("更新成功！", "レコードを更新しました。", "/webapp/MenuServlet"));
		//	} else { // 更新失敗
		///		request.setAttribute("result", new Result("更新失敗！", "レコードを更新できませんでした。", "/webapp/MenuServlet"));
		//	}
		
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUp.jsp");
		dispatcher.forward(request, response);
	}
}



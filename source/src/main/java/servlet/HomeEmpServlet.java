package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import dto.Users;

/**
 * Servlet implementation class HomeEmp
 */
@WebServlet("/HomeEmpServlet")
public class HomeEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeEmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// アルバイト取得
		UsersDao dao = new UsersDao();
		List<Users> todayParttimer = dao.getTodayParttimer();

		// リクエストにセット
		request.setAttribute("todayParttimer", todayParttimer);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/homeemp.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

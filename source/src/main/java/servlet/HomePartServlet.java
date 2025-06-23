package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SchedulesDao;
import dto.Users;

/**
 * Servlet implementation class HomePartServlet
 */
@WebServlet("/HomePartServlet")
public class HomePartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
	    Users loginUser = (Users) session.getAttribute("loginUser");

	    if (loginUser == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    int userId = loginUser.getId();
	    SchedulesDao dao = new SchedulesDao();
	    List<String> categoryList = dao.getTodayCategories(userId);

	    request.setAttribute("todayTasks", categoryList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/homepart.jsp");
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

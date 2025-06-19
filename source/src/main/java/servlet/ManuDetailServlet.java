package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManualsDao;
import dto.Manual;
/**
 * Servlet implementation class ManuDetailServlet
 */
@WebServlet("/ManuDetailServlet")
public class ManuDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManuDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		 // パラメータから manualId を取得
		 String manualIdStr = request.getParameter("manualId");

		    if (manualIdStr != null && manualIdStr.matches("\\d+")) {
		        int manualId = Integer.parseInt(manualIdStr);

		        ManualsDao dao = new ManualsDao();
		        Manual manual = dao.getManualById(manualId);  

		        if (manual != null) {
		            request.setAttribute("manual", manual);

		            HttpSession session = request.getSession();
		            session.setAttribute("manualId", manualId);

		            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manudetail.jsp");
		            dispatcher.forward(request, response);
		        } else {
		            response.sendRedirect("/B1/ManuListServlet");
		        }
		    } else {
		        response.sendRedirect("/B1/ManuListServlet");
		    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// もしもログインしていなかったらマニュアル詳細サーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
			response.sendRedirect("/webapp/ManuDetailServlet");
			return;
	}
	}
}

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManualsDao;
import dto.Manual;

/**
 * Servlet implementation class MenuListServlet
 */
@WebServlet("/ManuListServlet")
public class ManuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/webapp/LoginServlet");
			return;
		}
		*/
		
			//データベースからマニュアルを取得
			ManualsDao dao = new ManualsDao();
			List<Manual> manuList = dao.getManuList();
			
		
			//jspに渡す
			request.setAttribute("manuList", manuList);
			request.getRequestDispatcher("/WEB-INF/jsp/manulist.jsp").forward(request, response);
			

			
		
		}

		
	
}

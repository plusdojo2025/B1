package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManualsDao;
import dto.Manual;

/**
 * Servlet implementation class MenuCheckServlet
 */
@WebServlet("/ManuCheckServlet")
public class ManuCheckServlet extends HttpServlet {
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
		
		//category_id取得
		String categoryId = request.getParameter("categoryId");
		
		
	
		//カテゴリ名とマニュアル本文を取得
		ManualsDao dao = new ManualsDao();
		Manual manual = dao.getManualByCategoryId(categoryId);
		
		//リクエスト属性にセット
        request.setAttribute("taskName", manual.getTaskName());
        request.setAttribute("manualBody", manual.getManualBody());
        request.setAttribute("categoryId", categoryId);
        
        //jspに渡す
        request.getRequestDispatcher("/WEB-INF/jsp/manucheck.jsp").forward(request, response);
	}
}

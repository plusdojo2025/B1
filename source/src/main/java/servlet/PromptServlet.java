package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromptServlet {
	
	/**
	 * Servlet implementation class UpdateDeleteServlet
	 */
	@WebServlet("/PromptServlet")
	public class Promptervlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// もしもログインしていなかったらログインサーブレットにリダイレクトする
			//HttpSession session = request.getSession();
			//if (session.getAttribute("id") == null) {
			//	response.sendRedirect("/B1/LoginServlet");
			//	return;
			//}
						
			// 結果ページにフォワードする→Prompt.jspへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/prompt.jsp");
			dispatcher.forward(request, response);
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			//フォームページで送られた内容(キーワード)を受け取る
			//request.setCharacterEncoding("UTF-8");
			//int category_id = Integer.parseInt(request.getParameter("category_id"));
			//String category = request.getParameter("category");
	        //int task_id = Integer.parseInt(request.getParameter("task_id"));
			//String task = request.getParameter("task");
			//String body = request.getParam
			
			//プロンプトを完成させる
			
			// 結果ページにフォワードする→prompt.jspへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/prompt.jsp");
			dispatcher.forward(request, response);
		}
	}
	
}

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//HttpSession session = request.getSession();
		//if (session.getAttribute("id") == null) {
		//	response.sendRedirect("/B1/LoginServlet");
		//	return;
		//}
		       
		// 結果ページにフォワードする→情報追加.jspへ
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/form.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//リクエストスコープを取得する
		request.setCharacterEncoding("UTF-8");
		String manual = request.getParameter("manual");
		
		
		//登録処理
		
		//結果を返す
		/*
		if (result) { // 登録成功
			String result = "保存しました。";
			request.setAttribute("result",result);
		} else { // 登録失敗
			String result = "保存できませんでした。";
			request.setAttribute("result",result);
		}
		*/
		
		String result = "保存しました。";
		request.setAttribute("result",result);
		
		// 結果ページにフォワードする→情報追加.jspへ
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/form.jsp");
		dispatcher.forward(request, response);
	}
}
	
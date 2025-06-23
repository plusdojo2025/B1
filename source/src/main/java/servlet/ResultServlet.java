package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManualsDao;
import dto.Manual;


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
		int categoryId = Integer.parseInt(request.getParameter("category_id"));
		int taskId = Integer.parseInt(request.getParameter("task_id"));
		String manualBody = request.getParameter("manual");
		
		//登録処理
		ManualsDao manuDao = new ManualsDao();
		Manual manuDto = new Manual(categoryId,taskId,manualBody);
		boolean result = manuDao.insert(manuDto);
		String resultMessage = "";
		
		//結果を返す
		if (result) { // 登録成功
			resultMessage = "マニュアルを保存しました。";
			request.setAttribute("result",resultMessage);
		} else { // 登録失敗
			resultMessage = "マニュアルを保存できませんでした。";
			request.setAttribute("result",resultMessage);
		}
		
		// 結果ページにフォワードする→情報追加.jspへ
		request.setAttribute("result",resultMessage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/form.jsp");
		dispatcher.forward(request, response);
	}
}
	
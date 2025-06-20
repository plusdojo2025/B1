package servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/webapp/LoginServlet");
			return;
		}
		
		
			//データベースからマニュアルを取得
			ManualsDao dao = new ManualsDao();
			List<Manual> manuList = dao.getManuList();
			
			//カテゴリ名をキーにして、Mapを作成
			Map<String, List<Manual>> manualMap =new LinkedHashMap<>();
			
			//一件ずつ取り出し、カテゴリごとに
			for (Manual m : manuList) {
				//指定カテゴリ名がMap似ない場合、新しいリストを作成して追加
				manualMap.computeIfAbsent(m.getCategoryName(), k -> new java.util.ArrayList<>()).add(m);
			}
		
			//jspに渡す
			request.setAttribute("manualMap", manualMap);
			
			//フォワード
			request.getRequestDispatcher("/WEB-INF/jsp/manulist.jsp").forward(request, response);
			

			
		
		}

		
	
}

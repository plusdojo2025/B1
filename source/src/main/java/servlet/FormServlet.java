package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriesDao;
import dao.PlacesDao;
import dao.ToolsDao;
import dto.Categories;
import dto.Places;
import dto.Tools;

/**
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//HttpSession session = request.getSession();
		//if (session.getAttribute("id") == null) {
		//	response.sendRedirect("/B1/LoginServlet");
		//	return;
		//}
		
		// カテゴリ一覧取得
	    CategoriesDao catsDao = new CategoriesDao();
	    List<Categories> categoList = catsDao.findAll();
        
		// 場所一覧取得
	    PlacesDao placeDao = new PlacesDao();
	    List<Places> placeList = placeDao.findAll();
        
		// 使用物一覧取得
	    ToolsDao toolDao = new ToolsDao();
	    List<Tools> tooList = toolDao.findAll();
        
        request.setAttribute("categoList", categoList);
        request.setAttribute("placeList", placeList);
        request.setAttribute("tooList", tooList);
        
		// 結果ページにフォワードする→情報追加.jspへ
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	
}
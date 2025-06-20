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
@WebServlet("/ManuMakeServlet")
public class ManuMakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//HttpSession session = request.getSession();
		//if (session.getAttribute("id") == null) {
		//	response.sendRedirect("/webapp/LoginServlet");
		//	return;
		//}
		
		// カテゴリ一覧取得
	    CategoriesDao catsDao = new CategoriesDao();
	    List<Categories> categoList = catsDao.findAll();
	    System.out.println("カテゴリ");
	    //出力
        for (Categories category : categoList) {
            System.out.println(category.getId() + ": " + category.getCategory());
        }
        
		// 場所一覧取得
	    PlacesDao placeDao = new PlacesDao();
	    List<Places> placeList = placeDao.findAll();
	    System.out.println("場所");
	    //出力
        for (Places place : placeList) {
            System.out.println(place.getId() + ": " + place.getPlace());
        }
        
		// 使用物一覧取得
	    ToolsDao toolDao = new ToolsDao();
	    List<Tools> tooList = toolDao.findAll();
	    System.out.println("使用物");
	    //出力
        for (Tools tool : tooList) {
            System.out.println(tool.getId() + ": " + tool.getTool());
        }
        
        request.setAttribute("categoList", categoList);
        request.setAttribute("placeList", placeList);
        request.setAttribute("tooList", tooList);
        
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manumake.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//具体的な処理
		
		/*
		// マニュアル登録用
		//request.setCharacterEncoding("UTF-8");
		//int category_id = Integer.parseInt(request.getParameter("category_id"));
		//String category = request.getParameter("category");
        //int task_id = Integer.parseInt(request.getParameter("task_id"));
		//String task = request.getParameter("task");
		//String body = request.getParameter("manual");
		*/
	
}
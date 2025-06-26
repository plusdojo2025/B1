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
import dao.ManualsDao;
import dao.ReviewsDao;
import dao.TasksDao;
import dto.Categories;
import dto.Manual;
import dto.TasksDto;

/**
 * Servlet implementation class ManuUpServlet
 */
@WebServlet("/ManuUpServlet")
public class ManuUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*
		 * HttpSession session = request.getSession(); if (session.getAttribute("id") ==
		 * null) { response.sendRedirect("/webapp/LoginServlet"); return; }
		 */

		// カテゴリ一覧を取得してリクエストにセット
		CategoriesDao CategoriesDao = new CategoriesDao();
		List<Categories> CategorieList = CategoriesDao.findAll();

		System.out.println("カテゴリ名: " + CategorieList.size());
		for (Categories Categorie : CategorieList) {
			System.out.println(Categorie.getId() + ": " + Categorie.getCategory());
		}

		request.setAttribute("CategorieList", CategorieList);

		// タスク一覧を取得してリクエストにセット
		// tDaoを作成
		// TasksDtoはTasksDaoから
		TasksDao tDao = new TasksDao();
		List<TasksDto> TaskList = tDao.findAll();
		request.setAttribute("TaskList", TaskList);


		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manuup.jsp");
		dispatcher.forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// もしもログインしていなかったらマニュアル変更サーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//		response.sendRedirect("/B1/ManuUpServlet");
//		return;
		String category_id = request.getParameter("work1");
		String task_id = request.getParameter("taskId");
		int category_id_int = Integer.parseInt(category_id);
		int task_id_int = Integer.parseInt(task_id);
		// リクエストパラメータを取得する
		// category_idはwork1（selectのname）へ
		// task_idはtaskIdへ
		// 青文字は(jsp)のname
		// category_idとtask_idをint型に変換する
		request.setCharacterEncoding("UTF-8");
		
		//絞り込むボタンを押された時の処理
		if(request.getParameter("submit").equals("search")) {
		// categoryのidとtaskのidを使ってmanualsテーブルからbodyを取得するdaoをつくる

		// select id,body from manuals where category_id = ? and task_id = ? ;
		// id,bodyを取得してリクエストにセット
		//Manual型
		// キッチン（ポテトサラダ・食器洗い）
		// ホール（オーダー）のみ表示できる
		  ManualsDao mDao = new ManualsDao(); 
		  Manual ManuBody =mDao.getBody(category_id_int, task_id_int); 
		  request.setAttribute("ManuBody", ManuBody);
		  
		  
		  //レビューの値をマニュアルidから計算
		  ReviewsDao rDao = new ReviewsDao();
		  int review_avg = rDao.review_avg(ManuBody.getId());
		  int review_avg_half = rDao.review_avg_half(ManuBody.getId());
		  
		  //comment
		  // ManuBodyにidが含まれている
		  List<String> comments = rDao.getComments(ManuBody.getId());
		  
		  //レビューの値をmanuup.jspにわたすためにリクエストスコープに格納する
		  //review_avgをreview_scoreという名前で保存
		  //review_avg_halfはreview_half_scoreで
		  request.setAttribute("review_score", review_avg);
		  request.setAttribute("review_half_score", review_avg_half);
		  request.setAttribute("comments", comments); 
		  Manual mn = new Manual();
		  mn.setCategoryId(category_id_int);
		  mn.setTaskId(task_id_int);
		  request.setAttribute("category_task_id", mn); 
		  
		  //jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manuup.jsp");
			dispatcher.forward(request, response);
		
		}else if(request.getParameter("submit").equals("更新")) {
			//更新ボタンが押された時の処理
			String body = request.getParameter("body");
			
			//UPDATE  manuals SET body = ?  WHERE category_id = ? && task_id = ?;
			//daoに3つの引数を貰って実行するメソッドを作って、呼び出す
			ManualsDao mdao = new ManualsDao();

			
			boolean result = mdao.updateManual(body, category_id_int, task_id_int);
			if (result) { // 更新成功
				request.setAttribute("result","更新成功！");
				response.sendRedirect("/b1/ManuUpServlet");
				return;
			} else { // 更新失敗
				request.setAttribute("result","更新失敗！");
			}
			 //jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manuup.jsp");
			dispatcher.forward(request, response);
		
		}
	}
}


package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		// カテゴリ一覧を取得してリクエストにセット
		request.setCharacterEncoding("UTF-8");
		CategoriesDao CategoriesDao = new CategoriesDao();
		List<Categories> CategorieList = CategoriesDao.findAll();

		System.out.println("カテゴリ名: " + CategorieList.size());
		for (Categories Categorie : CategorieList) {
			System.out.println(Categorie.getId() + ": " + Categorie.getCategory());
		}

		// セッションスコープに格納する
		HttpSession session = request.getSession();
		session.setAttribute("CategorieList", CategorieList);
		// タスク一覧を取得してリクエストにセット
		// tDaoを作成
		// TasksDtoはTasksDaoから
		TasksDao tDao = new TasksDao();
		List<TasksDto> TaskList = tDao.findAll();
		session.setAttribute("TaskList", TaskList);


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
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("UTF-8");で文字文字コードをUTF-8に指定
		//文字化けを防ぐ
		
		//int型に変換し、それぞれセット
		int category_id = Integer.parseInt(request.getParameter("work1"));
		int task_id = Integer.parseInt(request.getParameter("taskId"));

		
		//絞り込むボタンを押された時の処理
		if(request.getParameter("submit").equals("絞り込み")) {
			
		// category_idとtask_idに対応したbodyをgetしてManuBodyにセット
		//Manual型
		  ManualsDao mDao = new ManualsDao(); 
		  Manual ManuBody =mDao.getBody(category_id, task_id); 
		  request.setAttribute("ManuBody", ManuBody);
		  
		  
		  //レビューの値をマニュアルidから計算
		  ReviewsDao rDao = new ReviewsDao();
//		  int review_avg = rDao.review_avg(ManuBody.getId());
//		  int review_avg_half = rDao.review_avg_half(ManuBody.getId());
		  
		  //comment
		  // ManuBodyにidが含まれている
		  List<String> comments = rDao.getComments(ManuBody.getId());
		  
		  //レビューの値をmanuup.jspにわたすためにリクエストスコープに格納する
		  //review_avgをreview_scoreという名前で保存
		  //review_avg_halfはreview_half_scoreで
//		  request.setAttribute("review_score", review_avg);
//		  request.setAttribute("review_half_score", review_avg_half);
		  request.setAttribute("comments", comments); 
		  Manual mn = new Manual();
		  mn.setCategoryId(category_id);
		  mn.setTaskId(task_id);
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

			
			boolean result = mdao.updateManual(body, category_id, task_id);
			if (result) { // 更新成功
				request.setAttribute("result","更新成功！");
				doGet(request,response);
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


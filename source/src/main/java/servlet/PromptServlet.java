package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriesDao;
import dao.TasksDao;


/**
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/PromptServlet")
public class PromptServlet extends HttpServlet {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/prompt.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//リクエストスコープを取得する
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		String task = request.getParameter("task");
		String min = request.getParameter("min");
		String sec = request.getParameter("sec");
		String[] placeList = request.getParameterValues("place");
		String[] toolList = request.getParameterValues("tool");
		String[] processList = request.getParameterValues("process");
		
		//カテゴリIDを取得
		CategoriesDao cateDao = new CategoriesDao();
		int category_id = cateDao.getId(category);
		System.out.println("カテゴリID:"+category_id);
		
		//taskデータを登録
		TasksDao taskDao = new TasksDao();
		taskDao.insert(task);
		//タスクIDを取得
		int task_id = taskDao.getId(task);	
		System.out.println("タスクID:"+task_id);
				
		//出力するプロンプト文
		// StringBuilderを使って文章組み立て
	    StringBuilder prompt = new StringBuilder();

	    // プロンプト条件説明
	    prompt.append("居酒屋の業務マニュアルをアルバイト向けに作成してください。以下の条件と与えられた内容に基づいて作成してください。\n\n");
	    prompt.append("■ 条件\n\n");
	    prompt.append("・文字数は1000字以内\n");
	    prompt.append("・与えられた情報のみを使用し、情報を補完しないこと（推測や想像を含めない）\n");
	    prompt.append("・不足している情報がある場合は、マニュアル末尾に「【不足情報】」として記載すること\n");
	    prompt.append("・初めに全体の目標時間を「").append(min).append("分").append(sec).append("秒」の形式で記載すること（例：1分30秒）\n\n");

	    // 提供情報タイトル
	    prompt.append("■ 提供情報（以下の項目に基づき記載）\n\n");

	    // 業務内容（カテゴリー＋具体的な業務）
	    prompt.append("・業務内容\n");
	    prompt.append(category != null ? category : "なし").append(" ");
	    prompt.append(task != null ? task : "なし").append("\n\n");

	    // 場所一覧の組み立て
	    prompt.append("・場所\n");
	    if (placeList != null && placeList.length > 0) {
	        for (String place : placeList) {
	            prompt.append("- ").append(place).append("\n");
	        }
	    } else {
	        prompt.append("なし\n");
	    }
	    prompt.append("\n");

	    // 道具一覧の組み立て
	    prompt.append("・使用する道具\n");
	    if (toolList != null && toolList.length > 0) {
	        for (String tool : toolList) {
	            prompt.append("- ").append(tool).append("\n");
	        }
	    } else {
	        prompt.append("なし\n");
	    }
	    prompt.append("\n");

	    // 番号付きで手順一覧の組み立て
	    prompt.append("・手順\n");
	    if (processList != null && processList.length > 0) {
	        for (int i = 0; i < processList.length; i++) {
	            prompt.append((i + 1)).append(". ").append(processList[i]).append("\n");
	        }
	    } else {
	        prompt.append("なし\n");
	    }
	    prompt.append("\n");

	    // 目標時間
	    prompt.append("・目標時間\n");
	    prompt.append(min != null ? min : "0").append("分");
	    prompt.append(sec != null ? sec : "0").append("秒\n");
	    
	    //System.out.print(prompt);

		// 結果ページにフォワードする→prompt.jspへ
		request.setAttribute("prompt", prompt);
		request.setAttribute("category_id", category_id);
		request.setAttribute("task_id", task_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/prompt.jsp");
		dispatcher.forward(request, response);
	}
	
	
}
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManualsDao;
import dao.ReviewsDao;
import dto.Manual;
import dto.Reviews;
/**
 * Servlet implementation class ManuDetailServlet
 */
@WebServlet("/ManuDetailServlet")
public class ManuDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManuDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		 // リクエストパラメータから manualId を取得
		 String manualIdStr = request.getParameter("manualId");
		 
		 
		    // manualId が null でなく、数字のみかどうかをチェック
		    if (manualIdStr != null && manualIdStr.matches("\\d+")) {
		    	// String から int に変換
		        int manualId = Integer.parseInt(manualIdStr);
		        
		        // DAOクラスを使ってDBからマニュアルデータを取得
		        ManualsDao dao = new ManualsDao();
		        Manual manual = dao.getManualById(manualId);  
		        
		        
		        if (manual != null) {
		        	// リクエスト属性に manual をセット
		            request.setAttribute("manual", manual);
		            
		            // セッションにも manualId をセット
		            HttpSession session = request.getSession();
		            session.setAttribute("manualId", manualId);

		            // 詳細表示用JSPへフォワード（内部転送）
		            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manudetail.jsp");
		            dispatcher.forward(request, response);
		        } else {
		        	// manual が見つからなかった場合、マニュアル一覧ページへリダイレクト
		            response.sendRedirect("/B1/ManuListServlet");
		        }
		    } else {
		    	// manualId パラメータが不正な場合も一覧ページへリダイレクト	
		        response.sendRedirect("/B1/ManuListServlet");
		    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/B1/LoginServlet");
			return;
	}
		//パラメータを取得
		request.setCharacterEncoding("UTF-8");
		String comment = request.getParameter("comment");
		String manualIdStr = request.getParameter("manualId");
		String ratingStr = request.getParameter("rating");
		
		int manualId = Integer.parseInt(manualIdStr);
		int userId = (int) session.getAttribute("id");
		
		//DTO生成
		Reviews review = new Reviews();
		review.setManual_id(manualId);
		review.setUser_id(userId);
		review.setReview(ratingStr);
		review.setComment(comment);
		
		//DAO呼び出し
		ReviewsDao dao = new ReviewsDao();
		dao.insertReview(review);
		
	}
	
}

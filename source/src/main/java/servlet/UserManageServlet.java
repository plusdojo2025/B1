package servlet;

import java.io.IOException;
import java.sql.Timestamp;    // java.sql.Timestamp
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriesDao;
import dao.PointsDao;
import dao.SchedulesDao;
import dao.UsersDao;
import dto.Categories;
import dto.Users;

/**
 * Servlet implementation class UserManageServlet
 */
@WebServlet("/UserManageServlet")
public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
    	//アルバイト名前取得
    	// 仮で3人のアルバイトメールアドレスを指定して取得
    	UsersDao usersDao = new UsersDao();
    	Users userA = usersDao.userInfo("dojouser3@plusdojo.jp");
    	Users userB = usersDao.userInfo("dojouser4@plusdojo.jp");
    	Users userC = usersDao.userInfo("dojouser5@plusdojo.jp");

    	//daoを使ってユーザーポイント取得
    	PointsDao pointsDao = new PointsDao();
    	int pointA = pointsDao.point(userA.getId());
    	int pointB = pointsDao.point(userB.getId());
    	int pointC = pointsDao.point(userC.getId());
    	
    	// JSPに渡す
    	request.setAttribute("userA", userA);
    	request.setAttribute("userB", userB);
    	request.setAttribute("userC", userC);
    	request.setAttribute("pointA", pointA);
    	request.setAttribute("pointB", pointB);
    	request.setAttribute("pointC", pointC);

        // 業務一覧を取得してリクエストにセット
    	CategoriesDao CategoriesDao = new CategoriesDao();
        List<Categories> CategorieList = CategoriesDao.findAll();
        
   
        System.out.println("業務件数: " + CategorieList.size());
        for (Categories Categorie : CategorieList) {
            System.out.println(Categorie.getId() + ": " + Categorie.getCategory());
        }
        
        request.setAttribute("taskList", CategorieList);

        // JSP にフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usermanage.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//ユーザーID
		int userId1 = Integer.parseInt(request.getParameter("userId1"));
		int userId2 = Integer.parseInt(request.getParameter("userId2"));
		int userId3 = Integer.parseInt(request.getParameter("userId3"));
		
		//日付
		String workdayStr = request.getParameter("workday");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parsedDate = null;
		try {
	        parsedDate = sdf.parse(workdayStr);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		// Date → Timestampに変換
		Timestamp workdayTimestamp = new Timestamp(parsedDate.getTime());
		
		
		// フォームから送られてきた業務IDを受け取る
		String work1[] = request.getParameterValues("work1");
		String work2[] = request.getParameterValues("work2");
		String work3[] = request.getParameterValues("work3");
		
		//dao
		SchedulesDao dao = new SchedulesDao();
		
		
		for (String cid : work1) {
		    dao.insert(userId1, Integer.parseInt(cid), workdayTimestamp);
		}
		for (String cid : work2) {
		    dao.insert(userId2, Integer.parseInt(cid), workdayTimestamp);
		}
		for (String cid : work3) {
		    dao.insert(userId3, Integer.parseInt(cid), workdayTimestamp);
		}
		
		//メッセージエリアのプログラム
		request.setAttribute("message", "登録が完了しました");
		doGet(request, response);
		
		}
	}



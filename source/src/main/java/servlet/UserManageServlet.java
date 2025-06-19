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

import dao.SchedulesDao;
import dao.TasksDao;
import dto.TasksDto;

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

        // 業務一覧を取得してリクエストにセット
        TasksDao tasksDao = new TasksDao();
        List<TasksDto> taskList = tasksDao.findAll();
        
   
        System.out.println("業務件数: " + taskList.size());
        for (TasksDto task : taskList) {
            System.out.println(task.getId() + ": " + task.getTask());
        }
        
        request.setAttribute("taskList", taskList);

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
		String userIdStr = request.getParameter("partTimeUserId");
		int userId = Integer.parseInt(userIdStr);
		
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
		
		
		for (String categoryIdStr : work1) {
	        int categoryId = Integer.parseInt(categoryIdStr);
	        dao.insert(userId, categoryId, workdayTimestamp);
	    }
		for (String categoryIdStr : work2) {
	        int categoryId = Integer.parseInt(categoryIdStr);
	        dao.insert(userId, categoryId, workdayTimestamp);
	    }
		for (String categoryIdStr : work3) {
	        int categoryId = Integer.parseInt(categoryIdStr);
	        dao.insert(userId, categoryId, workdayTimestamp);
	    }
		response.sendRedirect("UserManageServlet");
		
		}
	}



package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import dto.Users;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ログインページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			
			//id,pwを使ってdbのテーブルにこのセットがあるかどうかをチェックする
			//dbを使うということはdaoがいるよ
			
			//UsersクラスのJavaBeansをインスタンス化して、コンストラクターに変数を渡す。
			Users us = new Users(email,pw);
			//Users型のデータをdaoのメソッドの引数として使う
			//UsersDaoをインスタンス化
			UsersDao ud = new UsersDao();
			//usersdaoにあるisLoginOKメソッドにusers型のデータを引数としてわたす
			//結果はtrue　or　falseで戻って来る
			boolean loginok = ud.isLoginOK(us);
			
			
			//usersテーブルに会った場合
			if(loginok == true) {
				Users userInfo = ud.userInfo(email);
				
				
				HttpSession session = request.getSession();
				session.setAttribute("user", userInfo);
				session.setAttribute("id", userInfo.getId());
				session.setAttribute("loginUser", userInfo);
				session.setAttribute("role", userInfo.getRole());
				
				//usersでrole取得
				String role = userInfo.getRole();
				
		        if("社員".equalsIgnoreCase(role)) {
				//homeempにリダイレクト
				 response.sendRedirect(request.getContextPath() + "/HomeEmpServlet");
		        }else {
		        	response.sendRedirect(request.getContextPath() + "/HomePartServlet");
		        }
			}else {
			//なかった場合　メッセージエリア
				request.setAttribute("message", "ログイン失敗しました。");
				doGet(request, response);
			}
			 //ログイン処理を行う
			
		
	}

}

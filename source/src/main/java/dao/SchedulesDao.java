package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/*public class SchedulesDao {
	//ログイン確認
		public boolean isLoginOK(Users user) {
			Connection conn = null;
			boolean loginResult = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SELECT文を準備する
				String sql = "SELECT count(*) FROM USERS WHERE email=? AND pw=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, user.getEmail());
				pStmt.setString(2, user.getPw());

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// ユーザーIDとパスワードが一致するユーザーがいれば結果をtrueにする
				rs.next();
				if (rs.getInt("count(*)") == 1) {
					loginResult = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				loginResult = false;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				loginResult = false;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						loginResult = false;
					}
				}
			}

			// 結果を返す
			return loginResult;
		}
		
		public boolean insert(int user_id,String date,int category_id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B1?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				for(String work: work1) {
					// SQL文を準備する
					String sql = "INSERT INTO schedules (user_id,date,category_id) VALUES (?, ?, ?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);
	
					// SQL文を完成させる
					if (user_id != 0) {
						pStmt.setInt(1, user_id);
					} else {
						pStmt.setString(1, "");
					}
					if (date != null) {
						pStmt.setString(2, date);
					} else {
						pStmt.setString(2, "");
					}
					if (category_id != 0) {
						pStmt.setInt(3, category_id);
					} else {
						pStmt.setString(3, "");
					}
	
					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;
					}
				}catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			

			// 結果を返す
			return result;
		}

}*/

public class SchedulesDao {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/b1";
    private final String DB_USER = "root";
    private final String DB_PASS = "password";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insert(int userId, int categoryId, Timestamp date) {
        String sql = "INSERT INTO schedules (user_id, category_id, date, created_at, updated_at) VALUES (?, ?, ?, NOW(), NOW())";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, categoryId);
            stmt.setTimestamp(3, date);

            return stmt.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //ユーザーIDと今日で業務を取得する
    public List<String> getTodayCategories(int userId) {
        List<String> categories = new ArrayList<>();

        String sql = "SELECT c.category " +
                     "FROM schedules s " +
                     "JOIN categories c ON s.category_id = c.id " +
                     "WHERE s.user_id = ? AND DATE(s.date) = CURDATE()";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                categories.add(rs.getString("category"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
    }
}
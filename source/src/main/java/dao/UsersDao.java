package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dto.Users;

public class UsersDao {
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
			String sql = "select count(*) from users where email=? and pw=?";
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
	
	//ユーザー登録
	// 引数insertで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Users insert) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SQL文を準備する
				String sql = "insert into users values (0, ?, ?, ?, ?, default, default)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (insert.getName() != null) {
					pStmt.setString(1, insert.getName());
				}
				if (insert.getEmail() != null) {
					pStmt.setString(2, insert.getEmail());
				}
				if (insert.getPw() != null) {
					pStmt.setString(3, insert.getPw());
				}
				if (insert.getRole() != null) {
					pStmt.setString(4, insert.getRole());
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
				} catch (SQLException e) {
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
	
	
	// 情報更新
	// 引数updateで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Users update) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SQL文を準備する
				String sql = "update users set name=?, email=?, pw=?, role=?, updated_at=default WHERE id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (update.getName() != null) {
					pStmt.setString(1, update.getName());
				} 
				if (update.getEmail() != null) {
					pStmt.setString(2, update.getEmail());
				} 
				if (update.getPw() != null) {
					pStmt.setString(3, update.getPw());
				}
				if (update.getRole() != null) {
					pStmt.setString(4, update.getRole());
				}
				pStmt.setInt(5, update.getId());

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			} catch (SQLException e) {
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
		
		//情報取得
		public Users userInfo(String email) {
			Connection conn = null;
			boolean result = false;
			Users users = null;

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SQL文を準備する
				String sql = "select * from users where email = ?";	
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, email);
				
				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();
				
				if (rs.next()) {
					int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String mail = rs.getString("email");
	                String password = rs.getString("pw");
	                String other = rs.getString("role"); 
	                
	                Timestamp createdAt = rs.getTimestamp("created_at");
	                Timestamp updatedAt = rs.getTimestamp("updated_at");

	                users = new Users(id, name, mail, password, other, createdAt, updatedAt);
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
	       return users;
			
		}

		
		//社員用ホーム画面で今日のアルバイト一覧を取得するメソッド
		
		// UsersDao.java に追加
		public List<Users> getTodayParttimer() {
		    List<Users> ParttimerList = new ArrayList<>();
		    Connection conn = null;

		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        conn = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/b1?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
		            "root", "password");

		        String sql = """
		            select distinct u.* from schedules s
		            join users u on s.user_id = u.id
		            where date(s.date) = curdate()
		              and u.role = 'アルバイト'
		        """;

		        PreparedStatement ps = conn.prepareStatement(sql);
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            Users user = new Users(
		                rs.getInt("id"),
		                rs.getString("name"),
		                rs.getString("email"),
		                rs.getString("pw"),
		                rs.getString("role"),
		                rs.getTimestamp("created_at"),
		                rs.getTimestamp("updated_at")
		            );
		            ParttimerList.add(user);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        if (conn != null) {
		            try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		        }
		    }

		    return ParttimerList;
		}
		
}

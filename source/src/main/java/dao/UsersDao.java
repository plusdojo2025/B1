package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				String sql = "INSERT INTO USERS VALUES (0, ?, ?, ?, ?, DEFAULT, DEFAULT)";
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
	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Users card) {
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
				String sql = "UPDATE USERS SET name=?, email=?, pw=?, role=? WHERE id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getName() != null) {
					pStmt.setString(1, "%" + card.getName() + "%");
				} else {
					pStmt.setString(1, "%");
				}
				if (card.getEmail() != null) {
					pStmt.setString(2, "%" + card.getEmail() + "%");
				} else {
					pStmt.setString(2, "%");
				}
				if (card.getPw() != null) {
					pStmt.setString(3, "%" + card.getPw() + "%");
				} else {
					pStmt.setString(3, "%");
				}
				if (card.getRole() != null) {
					pStmt.setString(4, "%" + card.getRole() + "%");
				} else {
					pStmt.setString(4, "%");
				}
				pStmt.setInt(5, card.getId());

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

}

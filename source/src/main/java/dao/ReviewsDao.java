package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Reviews;

public class ReviewsDao {

	// データベースにアクセスするconnectionを用意（初期値をnullとする）
	// 最終的に結果を返すreviewsListを用意する
	// 評価の表示
	public List<Reviews> select(Reviews re) {
			Connection conn = null;
			List<Reviews> reList = new ArrayList<Reviews>();
			
			try {
				// JDBCドライバを読み込む
				// JDBC Javaからデータベースにアクセスするもの
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				//webapp、toot,password以外は定型文
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp2?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SQL文を準備する
				// connとsqlをまとめる→pstmt
				String sql = "SELECT id, manual_id, user_id, review, comment, createdAt, updatedAt FROM Reviews WHERE review LIKE ? AND comment LIKE ?  ORDER BY number";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				// != null よりも　!=""の方が分かりやすい
				if (re.getReview() != null) {
					pStmt.setString(1, "%" + re.getReview() + "%");
				} else {
					pStmt.setString(1, "%");
				}
				if (re.getComment() != null) {
					pStmt.setString(2, "%" + re.getComment() + "%");
				} else {
					pStmt.setString(2, "%");
				}
				// SQL文を実行し、結果表を取得する rsにexecuteQueryを代入
				ResultSet rs = pStmt.executeQuery();

				// 取り出した値をreListというArraylistに格納する
				while (rs.next()) {
					Reviews re = new Reviews(rs.getInt("id"),
								   rs.getInt("manual_id"),
								   rs.getInt("user_id"),
								   rs.getString("review"),
								   rs.getString("comment"),
								   rs.getTimestamp("createdAt"),
								   rs.getTimestamp("updatedAt"));
					reList.add(re);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				reList = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				reList = null;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						reList = null;
					}
				}
			}

			// 結果を返す
			return reList;
		}
			
			
	//評価の登録・追加
	//引数insertで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Reviews insert) {
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
			String sql = "INSERT INTO REVIEWS VALUES (0, ?, ?, ?, ?, NOW(), NOW())";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (insert.getReview() != null) {
				pStmt.setString(3, insert.getReview());
			}
			if (insert.getComment() != null) {
				pStmt.setString(4, insert.getComment());
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

	// 評価の更新
	// 引数updateで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Reviews update) {
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
			String sql = "UPDATE REVIEWS SET review=?, comment=?, updated_at=DEFAULT WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (update.getReview() != null) {
				pStmt.setString(1, update.getReview());
			} else {
				pStmt.setString(1, "");
			}
			if (update.getComment() != null) {
				pStmt.setString(2, update.getComment());
			} else {
				pStmt.setString(2, "");
			}
			pStmt.setInt(3, update.getId());
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

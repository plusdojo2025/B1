package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewsDao {

	// データベースにアクセスするconnectionを用意（初期値をnullとする）
	// Review(評価)の取得
	public int review_avg(int manual_id) {
			Connection conn = null;
					
			int score = 0;
			
			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B1?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SQL文を準備する
				// connとsqlをまとめる→pstmt
				String sql = "SELECT AVG(review) FROM reviews WHERE manual_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
//				// != null よりも　!=""の方が分かりやすい
//				if (manual_id == 0) {
//					pStmt.setInt(1, manual_id );
//				} else {
//					pStmt.setInt(1, 0);
//				}
				
				// SQL文を実行し、結果表を取得する rsにexecuteQueryを代入
				ResultSet rs = pStmt.executeQuery();


				rs.next();
				score = rs.getInt("AVG(review)");
			
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
			return score;
		}
			

	// データベースにアクセスするconnectionを用意（初期値をnullとする）
	// review_avg_half(更新してから１５日後の評価)の取得
	public int review_avg_half(int manual_id) {
			Connection conn = null;
					
			int score = 0;
			
			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B1?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SQL文を準備する
				// connとsqlをまとめる→pstmt
				String sql = "SELECT AVG(review) FROM (SELECT review FROM reviews WHERE manual_id = ? AND updated_at >= DATE_SUB(NOW(), INTERVAL 15 DAY) ) AS review_avg_half;";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
//				// != null よりも　!=""の方が分かりやすい
//				if (manual_id == 0) {
//					pStmt.setInt(1, manual_id );
//				} else {
//					pStmt.setInt(1, 0);
//				}
				
				// SQL文を実行し、結果表を取得する rsにexecuteQueryを代入
				ResultSet rs = pStmt.executeQuery();

				// 取り出した値をreListというArraylistに格納する
				rs.next();
				score = rs.getInt("AVG(review)");
			
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
			return score;
		}
	
	// データベースにアクセスするconnectionを用意（初期値をnullとする）
	// commentの取得
	public String comment(String comment) {
			Connection conn = null;
	
	try {
		// JDBCドライバを読み込む
		// JDBC Javaからデータベースにアクセスするもの
		Class.forName("com.mysql.cj.jdbc.Driver");

		// データベースに接続する
		//webapp、toot,password以外は定型文
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B1?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
				"root", "password");

		// SQL文を準備する
		// connとsqlをまとめる→pstmt
		String sql = "SELECT comment FROM reviews WHERE manual_id = ?;";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		
		// SQL文を実行し、結果表を取得する rsにexecuteQueryを代入
		ResultSet rs = pStmt.executeQuery();

		// 
		rs.next();
		comment = rs.getString("comment");
	
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
	return comment;
}
	

}

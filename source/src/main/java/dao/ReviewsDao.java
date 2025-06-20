package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				//String sql = "SELECT AVG(review) FROM (SELECT review FROM reviews WHERE manual_id = ? AND updated_at >= DATE_SUB(NOW(), INTERVAL 15 DAY) ) AS review_avg_half;";
				// マニュアルが更新されて以降の評価の平均点
				String sql = "SELECT AVG(review) FROM REVIEWS WHERE manual_id = ? AND created_at >( SELECT updated_at FROM MANUALS WHERE id = ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				// != null よりも　!=""の方が分かりやすい
				if (manual_id == 0) {
					pStmt.setInt(1, manual_id );
					pStmt.setInt(2, manual_id );
				} else {
					pStmt.setInt(1, 0);
				}
				
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
	// List型で表示する
	public List<String> getComments() {
        List<String> comments = new ArrayList<>();
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
			String sql = "SELECT comment from reviews where manual_id = ?  AND created_at >( SELECT updated_at FROM MANUALS WHERE id = ?);;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			
			
        	//SQLの実行結果を受け取るResultSetを取得
        	ResultSet rs = pStmt.executeQuery();
        	
       	 //ResultSetにデータがある限りループ
       	 while (rs.next()) {
       	   comments.add(rs.getString("comment"));
       	 }
		
       	 
       	 
        } catch (SQLException e) {
			e.printStackTrace();
			comments = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			comments = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					comments = null;
				}
			}
		}
        
        return comments;
		
		}
}
    



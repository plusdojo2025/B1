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
	
	
	//commentとreviewの追加（登録）
	public boolean insertReview(int user_id, int manual_id, int review, String comment) {
		Connection conn = null;
		
		// JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		// データベースに接続する
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		
	    String sql = "INSERT INTO Reviews (user_id, manual_id, review, comment, created_at, updated_at) " +
	                 "VALUES (?,  ?, ?, ?, NOW(), NOW())";

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, user_id);
	        pstmt.setInt(2, manual_id);
	        pstmt.setInt(3, review);
	        pstmt.setString(4, comment);

	        int rowsAffected = pstmt.executeUpdate();
	        return rowsAffected > 0;

	    }  catch (SQLException e) {
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
	        return false;
	    }
	
	// データベースにアクセスするconnectionを用意（初期値をnullとする）
	// Review(評価)の取得
	public int review_avg(int manual_id) {
			Connection conn = null;
					
			int score = 0;
			
			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
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
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
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
	//更新後マニュアルに対するコメントの取得
	//マニュアルが最後に更新された日時より後に投稿されたコメントをデータベースから取得して、List<String> で返す処理
	/*
	 * public List<String> getComments(int manualId) { List<String> comments = new
	 * ArrayList<>(); Connection conn = null; PreparedStatement pStmt = null;
	 * ResultSet rs = null;
	 * 
	 * try { // JDBCドライバを読み込む Class.forName("com.mysql.cj.jdbc.Driver");
	 * 
	 * // データベースに接続する conn = DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/B1?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
	 * "root", "password");
	 * 
	 * // SQL文を準備する String sql =
	 * "SELECT comment FROM reviews WHERE manual_id = ? AND created_at > (SELECT updated_at FROM manuals WHERE id = ?)"
	 * ; pStmt = conn.prepareStatement(sql); pStmt.setInt(1, manualId);
	 * pStmt.setInt(2, manualId);
	 * 
	 * // SQLを実行して結果を取得 rs = pStmt.executeQuery();
	 * 
	 * // 結果をリストに追加 while (rs.next()) { comments.add(rs.getString("comment")); }
	 * 
	 * } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }
	 * finally { // リソースのクローズ try { if (rs != null) rs.close(); if (pStmt != null)
	 * pStmt.close(); if (conn != null) conn.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 * 
	 * return comments; }
	 */

	// commentの取得
	//　マニュアルが登録されてから更新されるまでのcomment
	//日付関係なく全てのコメントを取得する
	public List<String> getComments(int manualId) {
	    List<String> comments = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pStmt = null;
	    ResultSet rs = null;

	    try {
	        // JDBCドライバを読み込む
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // データベースに接続する
	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/B1?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
	            "root", "password");

	        // SQL文を準備する
	        String sql = "SELECT comment FROM reviews WHERE manual_id = ?";
	        pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, manualId);

	        // SQLを実行して結果を取得
	        rs = pStmt.executeQuery();

	        // 結果をリストに追加
	        while (rs.next()) {
	            comments.add(rs.getString("comment"));
	        }

	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        // リソースのクローズ
	        try {
	            if (rs != null) rs.close();
	            if (pStmt != null) pStmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return comments;
	}

	 
				

    
//レビューがついてるマニュアルのIDを全て取得
public List<Reviews> getId() {
	Connection conn = null;
	List<Reviews> reviewsList = new ArrayList<Reviews>();

	try {
		// JDBCドライバを読み込む
		Class.forName("com.mysql.cj.jdbc.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
				"root", "password");

		// SQL文を準備する
		String sql = "SELECT manual_id from reviews";
				PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		while (rs.next()) {
			Reviews reviews = new Reviews(rs.getInt("manual_id"));
			reviewsList.add(reviews);
		}
	} catch (SQLException e) {
		e.printStackTrace();
		reviewsList = null;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		reviewsList = null;
	} finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				reviewsList = null;
			}
		}
	}

	// 結果を返す
	return reviewsList;
}

}

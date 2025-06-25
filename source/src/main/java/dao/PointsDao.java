package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PointsDao {

	// データベースにアクセスするconnectionを用意（初期値をnullとする）
	// Point(評価)の取得
	public int point(int user_id) {
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
				String sql = "select point from points where user_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
		        // プレースホルダーに値をセット
		        pStmt.setInt(1, user_id);
				
				// SQL文を実行し、結果表を取得する rsにexecuteQueryを代入
				ResultSet rs = pStmt.executeQuery();

				if (rs.next()) {
				    score = rs.getInt("point");
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
			return score;
		}
	
	// pointの追加
	public boolean addPoint(int user_id, int addValue) {
	    Connection conn = null;
	    boolean result = false;

	    try {
	        // JDBCドライバを読み込む
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // DB接続
	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/b1?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
	            "root", "password"
	        );

	        // SQL：加算処理
	        String sql = "update points set point = point + ? where user_id = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, addValue);     // 加算するポイント
	        pstmt.setInt(2, user_id);      // 対象ユーザーID

	        int rowsUpdated = pstmt.executeUpdate();

	        // 成功判定（1行以上更新されていれば成功）
	        result = (rowsUpdated > 0);

	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return result;
	}

	
	
}

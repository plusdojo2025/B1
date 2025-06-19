package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Points;

public class PointsDao {

	// データベースにアクセスするconnectionを用意（初期値をnullとする）
	// 最終的に結果を返すpointsListを用意する
	public List<Points> select(Points po) {
		Connection conn = null;
		List<Points> poList = new ArrayList<Points>();
	
		try {
			// JDBCドライバを読み込む
			// JDBC Javaからデータベースにアクセスするもの
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			//webapp、root,password以外は定型文
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp2?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
    
			// SQL文を準備する
			// connとsqlをまとめる→pstmt
			String sql = "SELECT id, user_id, point, createdAt;  updatedAt; FROM Points WHERE id LIKE ? AND user_id LIKE ? AND point LIKE ? AND createdAt LIKE ? AND updatedAt LIKE ? ORDER BY number";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			
		    // 2. ポイント更新
		    public void updatePoint(int id, int newPoint) throws SQLException {
		        String sql = "UPDATE points SET point = ? WHERE id = ?";
		        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		            stmt.setInt(1, newPoint);
		            stmt.setInt(2, id);
		            stmt.executeUpdate();
		        }
		    }
			
			
    		// データベースを切断
 			if (conn != null) {
 				try {
 					conn.close();
 				} catch (SQLException e) {
 					e.printStackTrace();
 				}
 			}
 		

 		// 結果を返す
 		return result;
 	}
}

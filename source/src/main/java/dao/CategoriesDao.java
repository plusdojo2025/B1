package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Categories;

public class CategoriesDao {
    // 業務一覧を取得（プルダウンや表示用）
    public List<Categories> findAll() {
    	Connection conn = null;
        List<Categories> list = new ArrayList<>();

        try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			//SQL文を準備
			String sql = "SELECT * FROM categories ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                Categories category = new Categories();
                category.setId(rs.getInt("id"));
                category.setCategory(rs.getString("category"));
                category.setCreatedAt(rs.getTimestamp("created_at"));
                category.setUpdatedAt(rs.getTimestamp("updated_at"));

                list.add(category);
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

        return list;
    }
    
    // 業務からIDを取得
 	public int getId(String category) {
 		Connection conn = null;
 		String id = null;
 		
 		try {
 		// JDBCドライバを読み込む
 		Class.forName("com.mysql.cj.jdbc.Driver");

 		// データベースに接続する
 		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
 				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
 				"root", "password");
 		
 		// SELECT文を準備する
 		String sql = "select * from categories where task = ?";
 		PreparedStatement pStmt = conn.prepareStatement(sql);
 		pStmt.setString(1, category);
 		
 		// SELECT文を実行し、結果表を取得する
 		ResultSet rs = pStmt.executeQuery();
 		
 		if (rs.next()) {
 		// 名前を取得
 		id = rs.getString("id");
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
 	   int category_id = Integer.parseInt(id);
        return category_id;
   }
 	
 	 
 
}

   


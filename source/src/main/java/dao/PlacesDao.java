package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Places;

public class PlacesDao {
	// 業務一覧を取得（プルダウンや表示用）
    public List<Places> findAll() {
    	Connection conn = null;
        List<Places> list = new ArrayList<>();

        try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			//SQL文を準備
			String sql = "SELECT * FROM places ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
            	Places place = new Places();
                place.setId(rs.getInt("id"));
                place.setPlace(rs.getString("place"));
                place.setCreatedAt(rs.getTimestamp("created_at"));
                place.setUpdatedAt(rs.getTimestamp("updated_at"));

                list.add(place);
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

}

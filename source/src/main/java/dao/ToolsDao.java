package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Tools;

public class ToolsDao {
    // 業務一覧を取得（プルダウンや表示用）
    public List<Tools> findAll() {
    	Connection conn = null;
        List<Tools> list = new ArrayList<>();

        try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			//SQL文を準備
			String sql = "SELECT * FROM tools ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
            	Tools tool = new Tools();
            	tool.setId(rs.getInt("id"));
            	tool.setTool(rs.getString("tool"));
            	tool.setCreatedAt(rs.getTimestamp("created_at"));
            	tool.setUpdatedAt(rs.getTimestamp("updated_at"));

                list.add(tool);
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
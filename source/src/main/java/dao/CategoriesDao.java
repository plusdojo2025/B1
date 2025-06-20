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
}

    /*
    // IDで業務を取得
    public TasksDto findById(int id) {
        String sql = "SELECT * FROM tasks WHERE id = ?";
        TasksDto task = null;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    task = new TasksDto();
                    task.setId(rs.getInt("id"));
                    task.setTask(rs.getString("task"));
                    task.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                    task.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return task;
    }
}
*/

package dao;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Manual;

	public class ChecksDao {
		
			    private final String JDBC_URL = "jdbc:mysql://localhost:3306/b1";
			    private final String DB_USER = "root";
			    private final String DB_PASS = "password";

			    
			    static {
			        try {
			            Class.forName("com.mysql.cj.jdbc.Driver");
			        } catch (ClassNotFoundException e) {
			            e.printStackTrace();
			        }
			    }

			    // 1. マニュアル確認の登録
			    public boolean insertCheck(int userId, int manualId) {
			        String sql = "INSERT INTO checks (user_id, manual_id, has_check, created_at, updated_at) "
			                   + "VALUES (?, ?, true, NOW(), NOW())";

			        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			             PreparedStatement stmt = conn.prepareStatement(sql)) {

			            stmt.setInt(1, userId);
			            stmt.setInt(2, manualId);

			            int result = stmt.executeUpdate();
			            return result == 1;
			        } catch (Exception e) {
			            e.printStackTrace();
			            return false;
			        }
			    }

			    // 2. 未確認マニュアル数の取得（ユーザー別）
			    public int countUncheckedManuals(int userId) {
			        String sql = """
			                SELECT COUNT(*) AS unchecked_count
			                FROM manuals m
			                WHERE NOT EXISTS (
			                    SELECT 1
			                    FROM checks c
			                    WHERE c.manual_id = m.id AND c.user_id = ?
			                )
			                """;

			        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			             PreparedStatement stmt = conn.prepareStatement(sql)) {

			            stmt.setInt(1, userId);

			            try (ResultSet rs = stmt.executeQuery()) {
			                if (rs.next()) {
			                    return rs.getInt("unchecked_count");
			                }
			            }
			        } catch (Exception e) {
			            e.printStackTrace();
			        }

			        return 0;
			    }

			    // Optional: すでにチェック済みかどうかを確認（重複登録防止）
			    public boolean hasChecked(int userId, int manualId) {
			        String sql = "SELECT COUNT(*) FROM checks WHERE user_id = ? AND manual_id = ?";

			        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			             PreparedStatement stmt = conn.prepareStatement(sql)) {

			            stmt.setInt(1, userId);
			            stmt.setInt(2, manualId);

			            try (ResultSet rs = stmt.executeQuery()) {
			                if (rs.next()) {
			                    return rs.getInt(1) > 0;
			                }
			            }
			        } catch (Exception e) {
			            e.printStackTrace();
			        }

			        return false;
			    }
			    
			 // 未チェックのmanual_idとtask_id、task名を取得（アルバイト用ホーム画面の更新通知表示用）
			    public List<Manual> getUncheckedManualsByUser(int userId) {
			        List<Manual> list = new ArrayList<>();
			        String sql = """
			            SELECT m.id, t.task AS taskName
			        	FROM manuals m
			        	JOIN tasks t ON m.task_id = t.id
			        	JOIN checks c ON m.id = c.manual_id
			        	WHERE c.user_id = ? AND c.has_check = false
			        	""";

			        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			             PreparedStatement stmt = conn.prepareStatement(sql)) {

			            stmt.setInt(1, userId);
			            ResultSet rs = stmt.executeQuery();

			            while (rs.next()) {
			                Manual manual = new Manual();
			                manual.setId(rs.getInt("id"));
			                manual.setTaskName(rs.getString("taskName"));
			                list.add(manual);
			            }
			        } catch (Exception e) {
			            e.printStackTrace();
			        }

			        return list;
			    }
			    
			
		}
	

	

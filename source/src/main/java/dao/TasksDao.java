package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.TasksDto;

public class TasksDao {
    private final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/b1?useSSL=false&serverTimezone=UTC";
    private final String DB_USER = "root";
    private final String DB_PASS = "password";
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 業務一覧を取得（プルダウンや表示用）
    public List<TasksDto> findAll() {
        List<TasksDto> list = new ArrayList<>();

        String sql = "SELECT * FROM tasks ORDER BY id";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TasksDto task = new TasksDto();
                task.setId(rs.getInt("id"));
                task.setTask(rs.getString("task"));
                task.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                task.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());

                list.add(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

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

    // 新しい業務を追加
    public boolean insert(String taskName) {
        String sql = "INSERT INTO tasks (task, created_at, updated_at) VALUES (?, NOW(), NOW())";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, taskName);
            int result = stmt.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
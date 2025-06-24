package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Manual;


public class ManualsDao {
	
    public List<Manual> getManuList() {
    	Connection conn = null;  
        List<Manual> list = new ArrayList<>();
        
        
        try {
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文の準備
        	PreparedStatement pStmt = conn.prepareStatement(
        			
        			//マニュアルテーブルをカテゴリ、タスクテーブルと結合
        			//必要な情報を取得（カテゴリ名、タスク名、本文、作成・更新日
        			"SELECT m.id, c.category AS categoryName, t.task AS taskName, " +
        			"m.body AS manualBody, m.created_at AS createdAt, m.updated_at AS updatedAt " +
        			"FROM MANUALS m " +
        			"JOIN CATEGORIES c ON m.category_id = c.id " +
        			"JOIN TASKS t ON m.task_id = t.id " +
        			"ORDER BY c.category, t.task "
        			);
        	
        	
        	//SQLの実行結果を受け取るResultSetを取得
        	ResultSet rs = pStmt.executeQuery();
         
        	 //ResultSetにデータがある限りループ
        	 while (rs.next()) {
        		 //Manualオブジェクトを作成し、カラムの値をセット
        		 Manual manual = new Manual();
        		 
        		 manual.setId(rs.getInt("id"));
        		 manual.setCategoryName(rs.getString("categoryName")); //カテゴリ名セット
        		 manual.setTaskName(rs.getString("taskName"));         //タスク名セット
        		 manual.setManualBody(rs.getString("manualBody"));     //マニュアル本文セット
        		 
        		 //日時系はDate型にセット
        		 manual.setCreatedAt(rs.getTimestamp("createdAt"));
        		 manual.setUpdatedAt(rs.getTimestamp("updatedAt"));
        		 
        		 //リストに追加
        		 list.add(manual);
        	 }
        	 
        } catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			list = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					list = null;
				}
			}
		}
        
        return list;

    }
    
    public Manual getManualByCategoryId(String categoryId) {
    	Manual manual = null;
    	
    	Connection conn = null;
    	
    	try {
    		//読み込み
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		//dbに接続
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
    		
    		// SQL文の準備
        	PreparedStatement pStmt = conn.prepareStatement(
        			
        			"SELECT m.id, c.category AS categoryName, t.task AS taskName, " +
        			"m.body AS manualBody, m.created_at AS createdAt, m.updated_at AS updatedAt " +
        			"FROM MANUALS m " +
        			"JOIN CATEGORIES c ON m.category_id = c.id " +
        			"JOIN TASKS t ON m.task_id = t.id " +
        			"WHERE m.category_id = ? " +
        			"LIMIT 1"
        			);
        	
        	//値セッツ
        	pStmt.setInt(1, Integer.parseInt(categoryId));
        	
        	//SQLの実行結果を受け取るResultSetを取得
        	ResultSet rs = pStmt.executeQuery();
        	
        	//Manualオブジェクトに詰める
        	if (rs.next()) {
        		manual = new Manual();
        		
        		 manual.setCategoryName(rs.getString("categoryName"));   // カテゴリ名
                 manual.setTaskName(rs.getString("taskName"));           // タスク名
                 manual.setManualBody(rs.getString("manualBody"));       // 本文
                 manual.setCreatedAt(rs.getTimestamp("createdAt"));    // 作成日
                 manual.setUpdatedAt(rs.getTimestamp("updateAt"));    // 更新日
        	}
        	
    	} catch (SQLException e) {
			e.printStackTrace();
			manual = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			manual = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					manual = null;
				}
			}
		}
    	
    	return manual;
    		
    }   
    public Manual getManualByTaskId(String taskId) {
        Manual manual = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/b1?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
                "root", "password"
            );
            PreparedStatement pStmt = conn.prepareStatement(
                "SELECT m.id, c.category AS categoryName, t.task AS taskName, " +
                "m.body AS manualBody, m.created_at AS createdAt, m.updated_at AS updatedAt " +
                "FROM MANUALS m " +
                "JOIN CATEGORIES c ON m.category_id = c.id " +
                "JOIN TASKS t ON m.task_id = t.id " +
                "WHERE m.task_id = ? " +
                "LIMIT 1"
            );
            pStmt.setInt(1, Integer.parseInt(taskId));
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                manual = new Manual();
                manual.setCategoryName(rs.getString("categoryName"));
                manual.setTaskName(rs.getString("taskName"));
                manual.setManualBody(rs.getString("manualBody"));
                manual.setCreatedAt(rs.getTimestamp("createdAt"));
                manual.setUpdatedAt(rs.getTimestamp("updatedAt"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            manual = null;
        } finally {
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
        return manual;
    }
    public Manual getManualById(int id) {
        Manual manual = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/b1?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
                "root", "password"
            );
            PreparedStatement pStmt = conn.prepareStatement(
                "SELECT m.id, c.category AS categoryName, t.task AS taskName, " +
                "m.body AS manualBody, m.created_at AS createdAt, m.updated_at AS updatedAt " +
                "FROM MANUALS m " +
                "JOIN CATEGORIES c ON m.category_id = c.id " +
                "JOIN TASKS t ON m.task_id = t.id " +
                "WHERE m.id = ? " +  // ← manualテーブルのIDで検索
                "LIMIT 1"
            );
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                manual = new Manual();
                manual.setId(rs.getInt("id"));
                manual.setCategoryName(rs.getString("categoryName"));
                manual.setTaskName(rs.getString("taskName"));
                manual.setCreatedAt(rs.getTimestamp("createdAt"));
                manual.setUpdatedAt(rs.getTimestamp("updatedAt"));
                
                String body = rs.getString("manualBody");
                if (body != null) {
                    body = body.replaceFirst("^[\\s　]+", "");  // 先頭の全角 or 半角スペースを除去
                }
                manual.setManualBody(body);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            manual = null;
        } finally {
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
        return manual;
    }
    
    //マニュア本体を登録
    public boolean insert(Manual manual) {
    	Connection conn = null;
		boolean result = false;
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "INSERT INTO manuals VALUES (0, ?, ?, ?, default, default)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を完成させる
			if (manual.getCategoryId() != null) {
				pStmt.setInt(1, manual.getCategoryId());
			}
			if (manual.getTaskId() != null) {
				pStmt.setInt(2, manual.getTaskId());
			}
			if (manual.getManualBody() != null) {
				pStmt.setString(3, manual.getManualBody());
			}
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
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
		return result;
    }
    
    //category_idとtask_idを使用してid,body（マニュアル本体）を取得する
   	public Manual getBody(int category_id, int task_id) {
   	    Connection conn = null;
   	    PreparedStatement pStmt = null;
   	    ResultSet rs = null;
       	Manual mn = new Manual();
   	    try {
   	        // JDBCドライバを読み込む
   	        Class.forName("com.mysql.cj.jdbc.Driver");

   	        // データベースに接続する
   	        conn = DriverManager.getConnection(
   	            "jdbc:mysql://localhost:3306/B1?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
   	            "root", "password");

   	    	        // SQL文を準備する
   	    	        String sql = "SELECT id,body FROM manuals WHERE category_id = ? AND task_id = ?;";
   	    	        pStmt = conn.prepareStatement(sql);
   	    	        pStmt.setInt(1, category_id);
   	    	        pStmt.setInt(2, task_id);

   	    	        // SQLを実行して結果を取得
   	    	        rs = pStmt.executeQuery();

   	    	        // 結果をリストに追加
   	    	        rs.next();

   	    	        	mn.setId(rs.getInt("id"));
   	    	        	mn.setManualBody(rs.getString("body"));					
   	   
   	    	        

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

   	    	    return mn;
   	    	}

    
}
package dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Users implements Serializable { 
	//フィールド
	private int id; 	   // 番号
	private String name;   // 名前
	private String email;  // ID(メール)
	private String pw;     // パスワード
	private String role;   // 役割
    private Timestamp createdAt; //作成日時
    private Timestamp updatedAt; //更新日時
	
	//ゲッターとセッター
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    //コンストラクタ　ログイン用
    public Users(String email, String pw) {
		this.email = email;
		this.pw = pw;
    }
	
	//コンストラクタ 情報変更用
    public Users(int id, String name, String email, String pw, String role) {
    	this.id= id;
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.role = role;
    }

}

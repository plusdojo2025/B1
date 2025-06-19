package dto;

import java.sql.Timestamp;

public class Checks {
	private int id;
	private int user_id;
	private int manual_id;
	private boolean has_check;
	private Timestamp created_at;
	private Timestamp updated_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getManual_id() {
		return manual_id;
	}
	public void setManual_id(int manual_id) {
		this.manual_id = manual_id;
	}
	public boolean isHas_check() {
		return has_check;
	}
	public void setHas_check(boolean has_check) {
		this.has_check = has_check;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdatedAt() {
		return updated_at;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updated_at = updatedAt;
	}
	
	//コンストラクタ 情報取得用
    public Checks(int id, int user_id, int manual_id, boolean has_check, Timestamp created_at,Timestamp updated_at) {
    	this.id= id;
		this.user_id = user_id;
		this.manual_id = manual_id;
		this.has_check = has_check;
		this.created_at = created_at;
		this.updated_at = updated_at;
    }
    
   
}

package dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Updates implements Serializable{
	//フィールド
	private int id;
	private int manual_id;       //どのマニュアルか
	private int user_id;         //コメントした人
	private boolean has_update;  //更新済みか
	private Timestamp createdAt; //作成日時
    private Timestamp updatedAt; //更新日時
    
    //ゲッターとセッター
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getManualId() {
		return manual_id;
	}
	public void setManualId(int manual_id) {
		this.id = manual_id;
	}
	public int getUserId() {
		return user_id;
	}
	public void setUserId(int user_id) {
		this.id = user_id;
	}
	public boolean isHas_update() {
		return has_update;
	}
	public void setHas_update(boolean has_update) {
		this.has_update = has_update;
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
	
	//コンストラクタ
	public Updates(int id, boolean has_update, Timestamp createdAt, Timestamp updatedAt) {
		this.id = id;
		this.manual_id = manual_id;
		this.user_id = user_id;
		this.has_update = has_update;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

}

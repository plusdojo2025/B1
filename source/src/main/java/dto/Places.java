package dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Places implements Serializable{
	//フィールド
	private int id;
	private String place;     //場所
	private Timestamp createdAt; //作成日時
    private Timestamp updatedAt; //更新日時
    
    //ゲッターとセッター
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
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
	public Places(int id, String place, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.place = place;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	//コンストラクタ　引数なし
	public Places() {}
	
}

package dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Categories implements Serializable{
	//フィールド
	private int id;
	private String category;     //カテゴリ
	private Timestamp createdAt; //作成日時
    private Timestamp updatedAt; //更新日時
    
    //ゲッターとセッター
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public Categories(int id, String category, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.category = category;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

}

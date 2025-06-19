package dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Tools implements Serializable{
	//フィールド
	private int id;
	private String tool;     //道具
	private Timestamp createdAt; //作成日時
    private Timestamp updatedAt; //更新日時
    
    //ゲッターとセッター
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTool() {
		return tool;
	}
	public void setTool(String tool) {
		this.tool = tool;
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
	public Tools(int id, String tool, Timestamp createdAt, Timestamp updatedAt) {
		this.id = id;
		this.tool = tool;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

}

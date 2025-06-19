package dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Points implements Serializable {
	//フィールド
	private int id; 	   		// 番号
	private int user_id;   		// 名前（ユーザーid）
	private int point;  		// ID(メール)
    private Timestamp createdAt; //登録日
    private Timestamp updatedAt; //更新日
    
  //ゲッターとセッター
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
  		this.id = user_id;
  	}
  	
  	public int getPoint() {
  		return point;
  	}
  	
  	public void setPoint(int point) {
  		this.id = point;
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

    
  //コンストラクタ 情報取得用
  	public Points(int id, int user_id, int point, Timestamp createdAt, Timestamp updatedAt) {
  		super();
  		this.id = id;
  		this.user_id = user_id;
  		this.point = point;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
  	}
  	
}

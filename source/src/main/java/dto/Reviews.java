package dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reviews implements Serializable {
	//フィールド
	private int id; 	   		// 番号
	private int manual_id;		//マニュアルID
	private int user_id;   		// 評価した人（ユーザーid）
	private int review;  	// 評価
	private String comment;		//コメント
    private Timestamp createdAt; //登録日
    private Timestamp updatedAt; //更新日
    
  //ゲッターとセッター
  	public int getId() {
  		return id;
  	}
  	
  	public void setId(int id) {
  		this.id = id;
  	}
  	
  	public int getManual_id() {
  		return manual_id;
  	}
  	
  	public void setManual_id(int manual_id) {
  		this.manual_id = manual_id;
  	}
  	
  	public int getUser_id() {
  		return user_id;
  	}
  	
  	public void setUser_id(int user_id) {
  		this.user_id = user_id;
  	}
  	
  	public int getReview() {
  		return review;
  	}
  	
  	public void setReview(int rating) {
  		this.review = rating;
  	}
  	
  	public String getComment() {
  		return comment;
  	}
  	
  	public void setComment(String comment) {
  		this.comment = comment;
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
    
    public String toString() {
        return "Reviews{id=" + id + 
               ", manual_id='" + manual_id + '\'' + 
               ", user_id='" + user_id + '\'' + 
               ", review='" + review + '\'' +
               ", comment='" + comment + '\'' +
               ", createdAt=" + createdAt +
               ", updatedAt=" + updatedAt + '}';
    }
    
  //コンストラクタ 情報取得用
  	public Reviews(int id, int manual_id, int user_id, int review, String comment, Timestamp createdAt, Timestamp updatedAt) {
  		super();
  		this.id = id;
  		this.manual_id = manual_id;
  		this.user_id = user_id;
  		this.review = review;
  		this.comment = comment;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
  	}

	public Reviews() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Reviews(int manual_id) {
	    this.manual_id = manual_id;
	}
  	
}


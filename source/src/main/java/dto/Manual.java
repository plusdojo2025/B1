package dto;

import java.sql.Timestamp;

public class Manual {
	private int id;
    private Integer categoryId; // カテゴリID
    private Integer taskId;     //業務ID
    private String categoryName;
    private String taskName;
	private String manualBody;   // 本文
    private Timestamp createdAt;  // 登録日
    private Timestamp updatedAt;  // 更新日
    
    //ゲッター・セッター
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getManualBody() {
		return manualBody;
	}
    public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public void setManualBody(String manualBody) {
		this.manualBody = manualBody;
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
	public Manual(int categoryId, int taskId, String manualBody) {
		this.categoryId = categoryId;
		this.taskId = taskId;
		this.manualBody = manualBody;
	}
	
	public Manual() {};

}


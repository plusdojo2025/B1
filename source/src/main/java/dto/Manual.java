package dto;

import java.util.Date;

public class Manual {
    private String categoryName; // カテゴリ名
    private String manualBody;   // 本文）
    private String taskName;     // 業務名
    private Date createDate;  // 登録日
    private Date updateDate;  // 更新日

    // ゲッター・セッター
    public String getCategoryName() {return categoryName;}
        
    public void setCategoryName(String categoryName) {this.categoryName = categoryName;}
        
    public String getManualBody() {return manualBody;}
        
    public void setManualBody(String manualBody) {this.manualBody = manualBody;}
   
    public String getTaskName() {return taskName;}
    public void setTaskName(String taskName) {this.taskName = taskName;}
    
    public Date getCreateDate() { return createDate; }
    public void setCreateDate(Date createDate) { this.createDate = createDate; }
    
    public Date getUpdateDate() { return updateDate; }
    public void setUpdateDate(Date updateDate) { this.updateDate = updateDate; }
}


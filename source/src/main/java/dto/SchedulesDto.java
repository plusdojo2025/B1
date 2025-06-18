package dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class SchedulesDto {
	private int id;
    private int user_id;
    private Date date;
    private int category_id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public SchedulesDto(int id, int user_id, Date date, int category_id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}

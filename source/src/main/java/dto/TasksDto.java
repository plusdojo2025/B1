package dto;

import java.time.LocalDateTime;

public class TasksDto {
	private int id;
	private String task;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public TasksDto() {}

	public TasksDto(int id, String task, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.task = task;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public String getTask() {
		return task;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
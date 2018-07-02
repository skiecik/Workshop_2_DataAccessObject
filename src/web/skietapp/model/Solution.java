package web.skietapp.model;

import java.sql.Timestamp;

public class Solution {

	private int id;
	private Timestamp created;
	private Timestamp updated;
	private String description;
	private int exerciseId;
	private int userId;
	
	public Solution(String description, int exerciseId, int userId) {
		this.description = description;
		this.exerciseId = exerciseId;
		this.userId = userId;
	}

	public Solution() {	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public int getUserId() {
		return userId;
	}

	public int getId() {
		return id;
	}

	public Timestamp getCreated() {
		return created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}	
}

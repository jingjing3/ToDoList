package com.hpeng2.todolist;

public class ToDoEvent {
	
	private String title;
	private String description;
	private Boolean checkFlag;
	private Boolean archiveFlag;
	
	ToDoEvent(String title){
		this.title = title;
		this.checkFlag = false;
		this.archiveFlag = false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(Boolean checkFlag) {
		this.checkFlag = checkFlag;
	}

	public Boolean getArchiveFlag() {
		return archiveFlag;
	}

	public void setArchiveFlag(Boolean archiveFlag) {
		this.archiveFlag = archiveFlag;
	}
	
	

}
package com.hpeng2.todolist;

import java.io.Serializable;

/*This class is the basic to do event class and it will declare the type for every single
 * to do event, the attribute will include the title, description and two flag, one is to
 * indicate whether it is completed or not and the other one is to indicate if the event
 * is archived or not. Getters and setters are used to get the private attribute */

public class ToDoEvent implements Serializable{
	
	/**
	 * toDoEvent Serializable ID
	 */
	private static final long serialVersionUID = 3077342873414218030L;
	
	private String title;
	private String description;
	private Boolean checkFlag;
	private Boolean archiveFlag;
	
	
	ToDoEvent(String title){
		this.title = title;
		this.checkFlag = false;
		this.archiveFlag = false;
		this.description = "";
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
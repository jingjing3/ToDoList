package com.hpeng2.todolist;

public class EmailMessage extends ToDoEvent{
	
	private static ToDoEvent emailMessage = new ToDoEvent("");
	
	public EmailMessage(String title) {
		super(title);
	}
	
	public static ToDoEvent getEmailMessage(){
		return emailMessage;
	}
	public static void setEmailMessage(ToDoEvent e){
		emailMessage = e;
	}


}

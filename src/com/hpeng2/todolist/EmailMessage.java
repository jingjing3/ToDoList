package com.hpeng2.todolist;

/*EmailMessage is a subclass of ToDoEvent, the purpose of this class is to trace
 * the user chosen event which will be email later */

@SuppressWarnings("serial")
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

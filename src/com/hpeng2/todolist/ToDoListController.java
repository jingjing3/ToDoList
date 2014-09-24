package com.hpeng2.todolist;



public class ToDoListController {
	
	//private static ToDoList toDoList = null;
	private static ToDoList archivedList = null;
	private static ToDoList unarchivedList = null;
	private static ToDoEvent EmailMessage= null;
	
	/*
	static public ToDoList getToDoList(){
		if (toDoList == null){
			toDoList = new ToDoList();
		}
		return toDoList;
	}
	*/
	
	static public ToDoList getUnarchivedList(){
		if(unarchivedList == null){
			unarchivedList = new ToDoList();
		}
		return unarchivedList;
		
	}
	
	static public ToDoList getArchivedList(){
		if(archivedList == null){
			archivedList = new ToDoList();
		}
		return archivedList;
		
	}
	
	public void addingAEventToUnarchiveList(ToDoEvent newEvent) {
		 getUnarchivedList().addToDoEventToUnarchivedList(newEvent);
	}
	
	public void addingAEventToarchiveList(ToDoEvent newEvent) {
		 getArchivedList().addToDoEventToArchivedList(newEvent);
	}
}	

package com.hpeng2.todolist;



public class ToDoListController {
	
	private static ToDoList toDoList = null;
	private static ToDoList archivedList = new ToDoList();
	private static ToDoList unarchivedList = new ToDoList();
	
	static public ToDoList getToDoList(){
		if (toDoList == null){
			toDoList = new ToDoList();
		}
		return toDoList;
	}
	
	static public ToDoList getUnarchivedList(){
		getToDoList();
		for (int i = 0; i<toDoList.size(); i++){
			if (toDoList.getElement(i).getArchiveFlag() == false){
				unarchivedList.addToDoEvent(toDoList.getElement(i));
			}
		}
		return unarchivedList;
		
	}
	
	static public ToDoList getArchivedList(){
		getToDoList();
		for (int i=0; i<toDoList.size(); i++){
			if (toDoList.getElement(i).getArchiveFlag() == true){
				archivedList.addToDoEvent(toDoList.getElement(i));
			}
		}
		return archivedList;
		
		
	}
	
	public void addingAEvent(ToDoEvent newEvent) {
		 getToDoList().addToDoEvent(newEvent);
	}

}

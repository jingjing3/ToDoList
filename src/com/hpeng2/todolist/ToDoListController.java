package com.hpeng2.todolist;

public class ToDoListController {
	
	private static ToDoList toDoList = null;
	private static ToDoList archivedList = null;
	
	static public ToDoList getToDoList(){
		if (toDoList == null){
			toDoList = new ToDoList();
		}
		return toDoList;
	}
	
	static public ToDoList getArchivedList(){
		if (toDoList == null){
			return null;
		}
		for (int i=0; i<toDoList.size(); i++){
			if (toDoList.getElement(i).getArchiveFlag() == true){
				archivedList.addToDoAction(toDoList.getElement(i));
			}
		}
		return archivedList;
		
		
	}

}

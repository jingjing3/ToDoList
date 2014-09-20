package com.hpeng2.todolist;

import java.util.ArrayList;
import java.util.Collection;

public class ToDoList {
	
	protected ArrayList<ToDoEvent> toDoList;
	
	public ToDoList(){
		this.toDoList = new ArrayList<ToDoEvent>();
	}
	
	public Collection<ToDoEvent> getToDoList(){
		return toDoList;
	}
	
	public void addToDoAction(ToDoEvent newToDoAction){
		toDoList.add(newToDoAction);
	}
	
	public void removeToDoAction(ToDoEvent targetToDoAction){
		toDoList.remove(targetToDoAction);
	}

}
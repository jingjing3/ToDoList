package com.hpeng2.todolist;

import java.util.ArrayList;
import java.util.Collection;

public class ToDoList {
	
	protected ArrayList<ToDoEvent> toDoList = null;
	protected ArrayList<Listener> listeners = null;
	//protected ToDoList archivedList = null;
	//protected ToDoList unarchivedList = null;
	
	public ToDoList(){
		toDoList = new ArrayList<ToDoEvent>();
		listeners = new ArrayList<Listener>();
	}
	
	private ArrayList<Listener> getListeners(){
		if (listeners == null){
			listeners = new ArrayList<Listener>();
		}
		return listeners;
	}
	
	public Collection<ToDoEvent> getToDoList(){
		return toDoList;
	}
	/*
	public ToDoList getArchivedLists(){
		if (archivedList == null){
			archivedList = new ToDoList();
		}
		return archivedList;
	}
	
	public ToDoList getUnarchivedLists(){
		if(unarchivedList == null){
			unarchivedList = new ToDoList();
		}
		return unarchivedList;
	}*/
	
	public void addToDoEvent(ToDoEvent newToDoEvent){
		toDoList.add(newToDoEvent);
		notifyListeners();
		
	}
	
	public void removeToDoEvent(ToDoEvent targetToDoEvent){
		toDoList.remove(targetToDoEvent);
		notifyListeners();
	}

	public int size(){
		return toDoList.size();
	}
	
	public ToDoEvent getElement(int i){
		return toDoList.get(i);
	}

	public void addListener(Listener l){
		listeners.add(l);
	}
	
	public void removeListener(Listener l){
		listeners.remove(l);
	}
	
	public void notifyListeners(){
		for (Listener listener:getListeners()){
			listener.update();
		}
	}
	

}
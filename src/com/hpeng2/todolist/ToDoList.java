package com.hpeng2.todolist;

import java.util.ArrayList;
import java.util.Collection;

public class ToDoList {
	
	//protected ArrayList<ToDoEvent> toDoList = null;
	protected ArrayList<Listener> listeners = null;
	
	protected ArrayList<ToDoEvent> archivedList = null;
	protected ArrayList<ToDoEvent> unarchivedList = null;
	private static ToDoEvent emailMessage = null; 
	
	public ToDoList(){
		//toDoList = new ArrayList<ToDoEvent>();
		archivedList = new ArrayList<ToDoEvent>();
		unarchivedList = new ArrayList<ToDoEvent>();
		listeners = new ArrayList<Listener>();
	}
	
	private ArrayList<Listener> getListeners(){
		if (listeners == null){
			listeners = new ArrayList<Listener>();
		}
		return listeners;
	}
	
	public Collection<ToDoEvent> getArchivedList(){
		return archivedList;
	}
	
	public Collection<ToDoEvent> getUnarchivedList(){
		return unarchivedList;
	}
	
	/*
	public Collection<ToDoEvent> getToDoList(){
		return toDoList;
	}
	*/
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
	
	public void addToDoEventToUnarchivedList(ToDoEvent newToDoEvent){
		unarchivedList.add(newToDoEvent);
		notifyListeners();
		
	}
	
	public void addToDoEventToArchivedList(ToDoEvent newToDoEvent){
		archivedList.add(newToDoEvent);
		notifyListeners();
		
	}
	
	public void removeToDoEventFromUnarchivedList(ToDoEvent targetToDoEvent){
		unarchivedList.remove(targetToDoEvent);
		notifyListeners();
	}
	
	public void removeToDoEventFromArchivedList(ToDoEvent targetToDoEvent){
		archivedList.remove(targetToDoEvent);
		notifyListeners();
	}
	
	
	public void setArchivedFlag(ToDoEvent targetToDoEvent){
		targetToDoEvent.setArchiveFlag(true);
		notifyListeners();
	}
	
	public void clearArchivedFlag(ToDoEvent targetToDoEvent){
		targetToDoEvent.setArchiveFlag(false);
		notifyListeners();
	}

	//public int sizeOfToDoList(){
	//	return toDoList.size();
	//}
	
	public int sizeOfArchivedList(){
		return archivedList.size();
	}
	
	public int sizeOfUnarchivedList(){
		return unarchivedList.size();
	}
	
	//public ToDoEvent getElementFromToDoList(int i){
	//	return toDoList.get(i);
	//}
	
	public ToDoEvent getElementFromArchivedList(int i){
		return archivedList.get(i);
	}

	public ToDoEvent getElementFromUnarchivedtLis(int i){
		return unarchivedList.get(i);
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
package com.hpeng2.todolist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

public class ToDoList {
	
	protected ArrayList<ToDoEvent> toDoList;
	protected ArrayList<Listener> listeners;
	
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
	
	public void addToDoEvent(ToDoEvent newToDoEvent){
		toDoList.add(newToDoEvent);
		notifyListeners();
		
	}
	
	public void removeToDoEvent(ToDoEvent targetToDoEvent){
		toDoList.remove(targetToDoEvent);
	}

	public int size(){
		return toDoList.size();
	}
	
	public ToDoEvent getElement(int i){
		return toDoList.get(i);
	}

	public ToDoEvent[] toArray(ToDoEvent[] toDoListArray) {
		Collections.addAll(toDoList, toDoListArray);
		return toDoListArray;
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
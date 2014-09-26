package com.hpeng2.todolist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class ToDoList implements Serializable{
	/*This class define to do list which will be a list of to do event, and it is build by
	 * creating two separate list, one is archive list and the other one is unarchied list 
	 * to implement. Listeners are added into this class to observe any changes of lists
	 * and some simplified function is implemented to ensure efficiency of the code outside
	 * of the class */

	/**
	 * toDoList serialization ID
	 */
	private static final long serialVersionUID = -7079365064015257526L;

	protected transient ArrayList<Listener> listeners = null;
	
	protected ArrayList<ToDoEvent> archivedList = null;
	protected ArrayList<ToDoEvent> unarchivedList = null;
	public ToDoList(){
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

	
	public int sizeOfArchivedList(){
		return archivedList.size();
	}
	
	public int sizeOfUnarchivedList(){
		return unarchivedList.size();
	}
	
	public ToDoEvent getElementFromArchivedList(int i){
		return archivedList.get(i);
	}

	public ToDoEvent getElementFromUnarchivedtList(int i){
		return unarchivedList.get(i);
	}
	
	public int numOfCompleteUnarchivedList(){
		int num =0;
		for(int i = 0; i < getUnarchivedList().size(); i++){
			if (getElementFromUnarchivedtList(i).getCheckFlag()){
				num++;
			}
		}
		return num;
	}
	
	public int numOfCompleteArchivedList() {
		int num =0;
		for(int i = 0; i < getArchivedList().size(); i++){
			if (getElementFromArchivedList(i).getCheckFlag()){
				num++;
			}
		}
		return num;
	}


	public void addListener(Listener l){
		getListeners().add(l);
	}
	
	public void removeListener(Listener l){
		getListeners().remove(l);
	}
	
	public void notifyListeners(){
		for (Listener listener:getListeners()){
			listener.update();
		}
	}


	
	

}
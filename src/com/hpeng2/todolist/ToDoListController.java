package com.hpeng2.todolist;

import java.io.IOException;

/*This class is used to connect the to do list to the activity, for activity, this class
 * will be called to get the archived list and unarchived list*/

public class ToDoListController {
	
	private static ToDoList archivedList = null;
	private static ToDoList unarchivedList = null;
	
	static public ToDoList getUnarchivedList(){
		if(unarchivedList == null){
			try {
				String file = ToDoListManager.getUFile();
				String key = ToDoListManager.getUKey();
				unarchivedList = ToDoListManager.getManager().loadToDoList(file,key);
				unarchivedList.addListener(new Listener(){
					public void update(){
						saveUnarchivedList();
					}
				});
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("could not deserialize studentlist from studentListManager");
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("could not deserialize studentlist from studentListManager");
			}
		}
		return unarchivedList;
		
	}
	
	static public void saveUnarchivedList(){
			try {
				String file = ToDoListManager.getUFile();
				String key = ToDoListManager.getUKey();
				ToDoListManager.getManager().saveToDoList(getUnarchivedList(),file,key);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("could not deserialize studentlist from studentListManager");
			}
	}
	
	
	static public ToDoList getArchivedList(){
		if(archivedList == null){
			try {
				String file = ToDoListManager.getAFile();
				String key = ToDoListManager.getAKey();
				archivedList = ToDoListManager.getManager().loadToDoList(file,key);
				archivedList.addListener(new Listener(){
					public void update(){
						saveArchivedList();
					}
				});
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("could not deserialize studentlist from studentListManager");
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("could not deserialize studentlist from studentListManager");
			}
		}
		return archivedList;
		
	}
	
	static public void saveArchivedList(){
		try {
			String file = ToDoListManager.getAFile();
			String key = ToDoListManager.getAKey();
			ToDoListManager.getManager().saveToDoList(getArchivedList(),file,key);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("could not deserialize studentlist from studentListManager");
		}
}
	
	public void addingAEventToUnarchiveList(ToDoEvent newEvent) {
		 getUnarchivedList().addToDoEventToUnarchivedList(newEvent);
	}
	
	public void addingAEventToarchiveList(ToDoEvent newEvent) {
		 getArchivedList().addToDoEventToArchivedList(newEvent);
	}
}	

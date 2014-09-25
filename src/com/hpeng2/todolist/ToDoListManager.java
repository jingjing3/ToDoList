package com.hpeng2.todolist;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

public class ToDoListManager {
	static final String upreFile = "UnarchivedToDoList";
	static final String utdlkey = "unarchivedtoDoList"; 
	static final String apreFile = "ArchivedToDoList";
	static final String atdlkey = "archivedToDoList";
	Context context;
	static private ToDoListManager toDoListManager = null;
	
	public static void initManager(Context context){
		if(toDoListManager ==null){
			toDoListManager = new ToDoListManager(context);
		}
		
	}
	static public ToDoListManager getManager(){
		return toDoListManager;
	}
	public ToDoListManager(Context context){
		this.context = context;
	}
	
	public ToDoList loadToDoList(String preFile, String tdlkey) throws ClassNotFoundException, IOException{
		SharedPreferences settings = context.getSharedPreferences(preFile, Context.MODE_PRIVATE);
		String toDoListData = settings.getString(tdlkey, "");
		if (toDoListData.equals("")){
			return new ToDoList();
		} else {
			return toDoListFromString(toDoListData);
		}
		
	}
	
	static public ToDoList toDoListFromString(String toDoListData) throws ClassNotFoundException, IOException{
		ByteArrayInputStream bi =  new ByteArrayInputStream(Base64.decode(toDoListData,Base64.DEFAULT));
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (ToDoList)oi.readObject();
	}
	
	static public String toDoListTostring(ToDoList tdl) throws IOException{
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(tdl);
		oo.close();
		byte bytes[] = bo.toByteArray();
		return  Base64.encodeToString(bytes,Base64.DEFAULT);
	}
		
	
	public void saveToDoList(ToDoList list,String preFile, String tdlkey) throws IOException{
		SharedPreferences settings = context.getSharedPreferences(preFile, Context.MODE_PRIVATE);
		Editor editor = settings.edit();
		editor.putString(tdlkey, toDoListTostring(list));
		editor.commit();
	}
	
	public static String getUFile(){
		return upreFile;
	}
	public static String getUKey(){
		return utdlkey;
	}
	public static String getAFile(){
		return apreFile;
	}
	public static String getAKey(){
		return atdlkey;
	}
	


}

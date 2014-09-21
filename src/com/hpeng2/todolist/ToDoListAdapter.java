package com.hpeng2.todolist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ToDoListAdapter extends ArrayAdapter<ToDoEvent>{
	
	ToDoEvent[] toDoListArray = null;
	Context context;
	
	public ToDoEvent[] convertArrayListToArray(){
		toDoListArray = new ToDoEvent[ToDoListController.getToDoList().size()];
		toDoListArray = (ToDoListController.getToDoList()).toArray(toDoListArray);
		return toDoListArray;
	}
	
	public ToDoListAdapter(Context context, ToDoEvent[] resource){
		super(context, R.layout.row, resource);
		this.context = context;
		this.toDoListArray = resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		
		 LayoutInflater inflater = ((Activity)context).getLayoutInflater();
		 convertView = inflater.inflate(R.layout.row, parent, false); 
		 TextView name = (TextView) convertView.findViewById(R.id.rowEventTitleTextView);
		 CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox);
		 name.setText(toDoListArray[position].getTitle());
		 if(toDoListArray[position].getCheckFlag() == true){
		 cb.setChecked(true);}
		 else{
		 cb.setChecked(false);}
		 return convertView;
	}

}

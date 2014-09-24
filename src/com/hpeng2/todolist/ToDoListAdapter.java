package com.hpeng2.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ToDoListAdapter extends ArrayAdapter<ToDoEvent>{
	
	ArrayList<ToDoEvent> toDoListArray = null;
	Context context;
	int cursor = 0;
	
	public ToDoListAdapter(Context context, ArrayList<ToDoEvent> resource){
		super(context, R.layout.row, resource);
		this.context = context;
		this.toDoListArray = resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		 cursor = position;
		 LayoutInflater inflater = ((Activity)context).getLayoutInflater();
		 convertView = inflater.inflate(R.layout.row, parent, false); 
		 TextView name = (TextView) convertView.findViewById(R.id.rowEventTitleTextView);
		 CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox);
		 cb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				toDoListArray.get(cursor).setCheckFlag(((CheckBox)v).isChecked());
			}
		});
		 name.setText(toDoListArray.get(cursor).getTitle());
		 if(toDoListArray.get(cursor).getCheckFlag() == true){
		 cb.setChecked(true);}
		 else{
		 cb.setChecked(false);}
		 return convertView;
	}

}

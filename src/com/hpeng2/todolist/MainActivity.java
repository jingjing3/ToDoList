package com.hpeng2.todolist;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import android.view.*;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView lv = (ListView) findViewById(R.id.toDoListView);
		/* Unqoute to test the listView with checkbox layout
		ToDoEvent[] test = new ToDoEvent[3];
		test[0] = new ToDoEvent("a");
		test[1] = new ToDoEvent("b");
		test[2] = new ToDoEvent("c");
		ToDoListAdapter adapter = new ToDoListAdapter(this, test);*/
		
		
		
		
		Collection<ToDoEvent> events = ToDoListController.getToDoList().getToDoList();
		final ArrayList<ToDoEvent> list = new ArrayList<ToDoEvent>(events);
		
		int size = events.size();
		ToDoEvent[] toDoListArray = new ToDoEvent[size];
		for (int i=0; i<size; i++){
			toDoListArray[i] = (ToDoListController.getToDoList().getElement(i));
		}
		
		final ToDoListAdapter adapter = new ToDoListAdapter(this, toDoListArray);
		//final ToDoListAdapter adapter = new ToDoListAdapter(this, toDoListArray);
		lv.setAdapter(adapter);
		
		//final ArrayList<ToDoEvent> list = new ArrayList<ToDoEvent>(ToDoListController.getToDoList().getToDoList());
		
		ToDoListController.getToDoList().addListener(new Listener(){

			@Override
			public void update() {
				list.clear();
				Collection<ToDoEvent> updateToDoList = ToDoListController.getToDoList().getToDoList();
				list.addAll(updateToDoList);
				adapter.notifyDataSetChanged();
				
			}
		
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void addEvent(MenuItem menu){
		Toast.makeText(this, "adding event", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this,AddEventActivity.class);
		startActivity(intent);
	}
	
	public void archievedEvents(MenuItem menu){
		Toast.makeText(this, "archieved events", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this,ArchivedEventActivity.class);
		startActivity(intent);
	}
	
	public void emailAllEvent(MenuItem menu){
		Toast.makeText(this, "emailing all", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this,EmailEventActivity.class);
		startActivity(intent);
	}
	
	public void statisticsEvent(MenuItem menu){
		Toast.makeText(this, "stats events", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this,StatisticsActivity.class);
		startActivity(intent);
	}

}

package com.hpeng2.todolist;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;
import android.view.*;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ListView lv = (ListView) findViewById(R.id.toDoListView);
		Collection<ToDoEvent> events = ToDoListController.getToDoList().getToDoList();
		final ArrayList<ToDoEvent> list = new ArrayList<ToDoEvent>(events);
		final ToDoListAdapter adapter = new ToDoListAdapter(this, list);
		lv.setAdapter(adapter);
		ToDoListController.getToDoList().addListener(new Listener(){

			@Override
			public void update() {
				list.clear();
				Collection<ToDoEvent> updateToDoList = ToDoListController.getToDoList().getToDoList();
				list.addAll(updateToDoList);
				adapter.notifyDataSetChanged();
				
			}
		
		});
		//ListView lv1 = getListView();
		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id){
				//Toast.makeText(MainActivity.this, "Deleting " + list.get(position).getTitle().toString(), Toast.LENGTH_SHORT).show();
				final String items[] = {"Cancel","Remove","Archive","Email"};
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
				alertDialogBuilder.setMessage("Choosing " + list.get(position).getTitle().toString() + " to: ");
				alertDialogBuilder.setItems(items, new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface d, int choice){
						if(choice == 0){
							
						}
						else if (choice == 1){
							
						}
						else if (choice == 2){
							
						}
						else if (choice == 3){
							
						}
					}
					
				});
				alertDialogBuilder.show();
				return true;
				
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

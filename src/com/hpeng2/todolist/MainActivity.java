package com.hpeng2.todolist;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ToDoListManager.initManager(this.getApplicationContext());
		
		final ListView lv = (ListView) findViewById(R.id.toDoListView);
		Collection<ToDoEvent> events = ToDoListController.getUnarchivedList().getUnarchivedList();
		final ArrayList<ToDoEvent> unarchivedlist = new ArrayList<ToDoEvent>(events);
		final ToDoListAdapter adapter = new ToDoListAdapter(this, unarchivedlist);
		lv.setAdapter(adapter);
		ToDoListController.getUnarchivedList().addListener(new Listener(){

			@Override
			public void update() {
				unarchivedlist.clear();
				Collection<ToDoEvent> updateToDoList = ToDoListController.getUnarchivedList().getUnarchivedList();
				unarchivedlist.addAll(updateToDoList);
				adapter.notifyDataSetChanged();
				
			}
		
		});
		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			int cursor = 0;
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id){
				final String items[] = {"Remove","Archive","Email"};
				cursor = position;
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
				alertDialogBuilder.setTitle("Choosing " + unarchivedlist.get(cursor).getTitle().toString() + " to: ");
				alertDialogBuilder.setCancelable(true);
				alertDialogBuilder.setItems(items, new DialogInterface.OnClickListener() {
					
					ToDoEvent targetEvent = unarchivedlist.get(cursor);
					public void onClick(DialogInterface d, int choice){
						if(choice == 0){
							ToDoListController.getUnarchivedList().removeToDoEventFromUnarchivedList(targetEvent);						}
						else if (choice == 1){
							ToDoListController.getUnarchivedList().setArchivedFlag(unarchivedlist.get(cursor));
							ToDoListController.getUnarchivedList().removeToDoEventFromUnarchivedList(targetEvent);
							ToDoListController.getArchivedList().addToDoEventToArchivedList(targetEvent);
							
							adapter.notifyDataSetChanged();
						}
						else if (choice == 2){
							Intent intent = new Intent(MainActivity.this,EmailEventActivity.class);
							startActivity(intent);
							EmailMessage.setEmailMessage(targetEvent);
							
						}
					}
					
				});
				alertDialogBuilder.create().show();
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

package com.hpeng2.todolist;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ArchivedEventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.archive_event);
		final ListView lv = (ListView) findViewById(R.id.archivedEventListView);
		Collection<ToDoEvent> events = ToDoListController.getArchivedList().getArchivedList();
		final ArrayList<ToDoEvent> archivedList = new ArrayList<ToDoEvent>(events);
		final ToDoListAdapter adapter = new ToDoListAdapter(this, archivedList);
		lv.setAdapter(adapter);
		ToDoListController.getArchivedList().addListener(new Listener(){

			@Override
			public void update() {
				archivedList.clear();
				Collection<ToDoEvent> updateToDoList = ToDoListController.getArchivedList().getArchivedList();
				archivedList.addAll(updateToDoList);
				adapter.notifyDataSetChanged();
				
			}
		
		});
		
		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			int cursor = 0;
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id){
				final String items[] = {"Remove","Unarchive","Email"};
				cursor = position;
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ArchivedEventActivity.this);
				alertDialogBuilder.setTitle("Choosing " + archivedList.get(cursor).getTitle().toString() + " to: ");
				alertDialogBuilder.setCancelable(true);
				alertDialogBuilder.setItems(items, new DialogInterface.OnClickListener() {
					
					ToDoEvent targetEvent = archivedList.get(cursor);
					public void onClick(DialogInterface d, int choice){
						if(choice == 0){
							ToDoListController.getArchivedList().removeToDoEventFromArchivedList(targetEvent);						}
						else if (choice == 1){
							ToDoListController.getArchivedList().clearArchivedFlag(archivedList.get(cursor));
							ToDoListController.getArchivedList().removeToDoEventFromArchivedList(targetEvent);
							ToDoListController.getUnarchivedList().addToDoEventToUnarchivedList(targetEvent);
							adapter.notifyDataSetChanged();
						}
						else if (choice == 2){
							Intent intent = new Intent(ArchivedEventActivity.this,EmailEventActivity.class);
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
		getMenuInflater().inflate(R.menu.archived_event, menu);
		return true;
	}

}

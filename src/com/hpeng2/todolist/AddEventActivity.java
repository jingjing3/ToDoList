package com.hpeng2.todolist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/* Add Event Activity Class is an android activity class which will be called
 * every time when users hit menu option: Add an Event, and it will bring a new
 * UI for users to input their descriptions and titles for the to do events. One
 * Implemented function included, it will be called every time when user press
 * and button.
 */

public class AddEventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_event, menu);
		return true;
	}
	
	public void AddAEvent(View v){
		ToDoListController lc = new ToDoListController();
		EditText titleview = (EditText) findViewById(R.id.addEventTitleTextField);
		EditText descriptionView = (EditText) findViewById(R.id.addEventDescriptionTextField);
		ToDoEvent newEvent = new ToDoEvent(titleview.getText().toString());
		lc.addingAEventToUnarchiveList(newEvent);
		if (!descriptionView.getText().toString().matches("")){
			newEvent.setDescription(descriptionView.getText().toString());
		}
		Toast.makeText(this, "Finishing Adding", Toast.LENGTH_SHORT).show();
		
	}

}

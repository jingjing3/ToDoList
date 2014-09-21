package com.hpeng2.todolist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
		Toast.makeText(this, "adding a event", Toast.LENGTH_SHORT).show();
		ToDoListController lc = new ToDoListController();
		EditText titleview = (EditText) findViewById(R.id.addEventTitleTextField);
		EditText descriptionView = (EditText) findViewById(R.id.addEventDescriptionTextField);
		ToDoEvent newEvent = new ToDoEvent(titleview.getText().toString());
		lc.addingAEvent(newEvent);
		if (!descriptionView.getText().toString().matches("")){
			newEvent.setDescription(descriptionView.getText().toString());
		}
		
	}

}

package com.hpeng2.todolist;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class EmailEventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email_event);
		ToDoListManager.initManager(this.getApplicationContext());
		//Collection<ToDoEvent> allEvents = null;
		ToDoEvent selectEvent = EmailMessage.getEmailMessage();
		ListView lv = (ListView) findViewById(R.id.EmailListView);
		//allEvents = ToDoListController.getArchivedList().getArchivedList();
		//allEvents.addAll(ToDoListController.getUnarchivedList().getUnarchivedList());
		ArrayList<ToDoEvent> list = new ArrayList<ToDoEvent>();
		list.add(selectEvent);
		ToDoListAdapter adapter = new ToDoListAdapter(this, list);
		lv.setAdapter(adapter);
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.email_event, menu);
		return true;
	}
	
	public void sendButtonPressed(View v){
		Toast.makeText(this, "Sending the ToDoEvent...", Toast.LENGTH_SHORT).show();
		ToDoEvent selectEvent = EmailMessage.getEmailMessage();
		EditText emailAddressField = (EditText) findViewById(R.id.emailAddressTextField);
		String emailAddress = emailAddressField.getText().toString();
		String emailTitle = selectEvent.getTitle();
		String emailDescription = null;
		if(selectEvent.getDescription()!= null){
			emailDescription = selectEvent.getDescription();
		}
		else{
			emailDescription = "No Description";
		}
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("message/rfc822");
		intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
		intent.putExtra(Intent.EXTRA_SUBJECT, emailTitle);
		intent.putExtra(Intent.EXTRA_TEXT,emailDescription);
		try{
			startActivity(Intent.createChooser(intent, "Sending mail"));
		} catch (android.content.ActivityNotFoundException ex){
			Toast.makeText(EmailEventActivity.this, "no email clints", Toast.LENGTH_SHORT).show();
		}
	}

}

package com.hpeng2.todolist;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/*EmailEventActivity is an android activity and will be called every time when user try
 * to email a chosen event by long clicking the target event. This activity bring out 
 * a layout for user to type an email address and email the chosen event
 * 
 * ArrayAdapter is used to keep track on the events in the list and it will get the 
 * Email information from the last activity. And use android build in method to send
 * the Email by the android email app.
 * 
 * The idea and implemented style is from http://stackoverflow.com/questions/2197741
 * /how-can-i-send-emails-from-my-android-application */

public class EmailEventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email_event);
		ToDoListManager.initManager(this.getApplicationContext());
		ToDoEvent selectEvent = EmailMessage.getEmailMessage();
		ListView lv = (ListView) findViewById(R.id.EmailListView);
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

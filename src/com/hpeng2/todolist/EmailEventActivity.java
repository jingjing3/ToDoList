package com.hpeng2.todolist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EmailEventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email_event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.email_event, menu);
		return true;
	}

}
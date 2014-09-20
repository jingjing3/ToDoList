package com.hpeng2.todolist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ArchivedEventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.archive_event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.archived_event, menu);
		return true;
	}

}

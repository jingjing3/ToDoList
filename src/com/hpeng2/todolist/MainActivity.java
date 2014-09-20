package com.hpeng2.todolist;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
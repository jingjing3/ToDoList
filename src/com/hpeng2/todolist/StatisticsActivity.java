package com.hpeng2.todolist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class StatisticsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stats_event);
		TextView stats = (TextView) findViewById(R.id.statsTextView);
		int totalEvent = ToDoListController.getToDoList().size();
		String sTotalEvent = new Integer(totalEvent).toString();
		int unarchivedEvent = ToDoListController.getUnarchivedList().size();
		String sUnarchivedEvent = new Integer(unarchivedEvent).toString();
		int archievedEvent = ToDoListController.getArchivedList().size();
		String sArchievedEvent = new Integer(archievedEvent).toString();
		stats.setText("Total todo Event is " + sTotalEvent +"\n" + 
					  "Total unarchieved Event is " + sUnarchivedEvent + "\n" +
					  "Total archived Event is " + sArchievedEvent );

		/*
		String testing_string = "";
		for(int i=0; i< ToDoListController.getToDoList().size(); i++){
			testing_string += ToDoListController.getToDoList().getElement(i).getTitle();
			testing_string += " ";
		}
		stats.setText(testing_string);*/
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.statistics, menu);
		return true;
	}

}

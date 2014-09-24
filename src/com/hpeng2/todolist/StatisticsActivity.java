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
		
		int NumOfUnarchivedEvent = ToDoListController.getUnarchivedList().sizeOfUnarchivedList();
		String sUnarchivedEvent = new Integer(NumOfUnarchivedEvent).toString();
		
		int NumOfarchievedEvent = ToDoListController.getArchivedList().sizeOfArchivedList();
		String sArchievedEvent = new Integer(NumOfarchievedEvent).toString();
		
		int NumOfTotalEvent = NumOfarchievedEvent+NumOfUnarchivedEvent;
		String sTotalEvent = new Integer(NumOfTotalEvent).toString();
		
		stats.setText("Total todo Event is " + sTotalEvent +"\n" + 
					  "Total unarchieved Event is " + sUnarchivedEvent + "\n" +
					  "Total archived Event is " + sArchievedEvent );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.statistics, menu);
		return true;
	}

}

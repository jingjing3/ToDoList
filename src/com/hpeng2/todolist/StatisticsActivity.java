package com.hpeng2.todolist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

/*This activity is used to show the statistics about the todolist, this activity will be
 * called through the menu from the main activity and can used the return button to get
 * back to the main.*/

public class StatisticsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stats_event);
		ToDoListManager.initManager(this.getApplicationContext());
		
	}
	@Override
	protected void onResume(){
		super.onResume();
		TextView stats = (TextView) findViewById(R.id.statsTextView);
		
		stats.setTextSize(18);
		
		int NumOfCompleteEventFromArchivedList = ToDoListController.getArchivedList().numOfCompleteArchivedList();
		String sNumOfCompleteEventFromArchivedList = new Integer(NumOfCompleteEventFromArchivedList).toString();
		
		int NumOfCompleteEventFromUnarchivedList = ToDoListController.getUnarchivedList().numOfCompleteUnarchivedList();
		
		int NumOfTotalCompleteEvent = NumOfCompleteEventFromArchivedList + NumOfCompleteEventFromUnarchivedList;
		String sNumOfCompleteTotalEvent = new Integer(NumOfTotalCompleteEvent).toString();
		
		int NumOfUnarchivedEvent = ToDoListController.getUnarchivedList().sizeOfUnarchivedList();
		String sUnarchivedEvent = new Integer(NumOfUnarchivedEvent).toString();
		
		int NumOfarchievedEvent = ToDoListController.getArchivedList().sizeOfArchivedList();
		String sArchievedEvent = new Integer(NumOfarchievedEvent).toString();
		
		int NumOfTotalEvent = NumOfarchievedEvent+NumOfUnarchivedEvent;
		String sTotalEvent = new Integer(NumOfTotalEvent).toString();
		
		int NumofTotalUncompleteEvent = NumOfTotalEvent - NumOfTotalCompleteEvent;
		String sNumofTotalUncompleteEvent = new Integer(NumofTotalUncompleteEvent).toString();
		
		int NumofTotalarchivedUncompleteEvent = NumOfarchievedEvent - NumOfCompleteEventFromArchivedList;
		String sNumofTotalarchivedUncompleteEvent = new Integer(NumofTotalarchivedUncompleteEvent).toString();
		
		stats.setText("Total # of Todo Event is " + sTotalEvent +"\n" + "\n" +
					  "Total # of Unarchieved Event is " + sUnarchivedEvent + "\n" +
					  "Total # of Archived Event is " + sArchievedEvent + "\n" + "\n" +
					  "Total # of Uncompleted Event is " + sNumofTotalUncompleteEvent + "\n" +
					  "Total # of Completed Event is " + sNumOfCompleteTotalEvent + "\n" + "\n" +
					  "Total # of Archived Completed Event is " + sNumOfCompleteEventFromArchivedList + "\n" +
					  "Total # of Archived Uncomplete Event is " + sNumofTotalarchivedUncompleteEvent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.statistics, menu);
		return true;
	}

}

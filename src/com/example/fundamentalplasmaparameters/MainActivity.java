package com.example.fundamentalplasmaparameters;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ArrayList<String> nameList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.setTitle(R.string.label_name); //set the Top title bar to the
		
		initList();
		ListView optionList = (ListView) findViewById(R.id.listView);
		ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameList);
		optionList.setAdapter(adapter); //populates list
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initList(){
		nameList.add("Frequencies");
		nameList.add("Lengths");
		nameList.add("Velocities");
		nameList.add("Dimensionless");
		nameList.add("Miscellaneous");
		nameList.add("About");
	}	
}
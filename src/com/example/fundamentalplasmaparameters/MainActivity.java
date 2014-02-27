package com.example.fundamentalplasmaparameters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	
	List<Map<String, String>> optionsList = new ArrayList<Map<String, String>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.setTitle(R.string.label_name); //set the Top title bar to the
		
		initList();
		ListView lv = (ListView) findViewById(R.id.listView);
		
		SimpleAdapter adapter =  new SimpleAdapter(this, optionsList, android.R.layout.simple_list_item_1, new String[] {"option"}, new int[] {android.R.id.text1});
		lv.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initList(){
		optionsList.add(createOption("option", "Option 1"));
		optionsList.add(createOption("option", "Option 2"));
		optionsList.add(createOption("option", "Option 1"));
		optionsList.add(createOption("option", "Option 2"));
		optionsList.add(createOption("option", "Option 1"));
		optionsList.add(createOption("option", "Option 2"));
		optionsList.add(createOption("option", "Option 1"));
		optionsList.add(createOption("option", "Option 2"));
		optionsList.add(createOption("option", "Option 1"));
		optionsList.add(createOption("option", "Option 2"));
		optionsList.add(createOption("option", "Option 1"));
		optionsList.add(createOption("option", "Option 2"));
		optionsList.add(createOption("option", "Option 1"));
		optionsList.add(createOption("option", "Option 2"));
		optionsList.add(createOption("option", "Option 1"));
		optionsList.add(createOption("option", "Option 2"));
		optionsList.add(createOption("option", "Option 1"));
		optionsList.add(createOption("option", "Option 2"));
	}
	
	private HashMap<String, String> createOption(String key, String name){
		HashMap<String, String> option = new HashMap<String, String>();
		option.put(key, name);
		return option;
	}
}
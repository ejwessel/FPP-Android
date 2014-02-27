package com.example.fundamentalplasmaparameters;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	ArrayList<String> nameList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.setTitle(R.string.label_name); //set the Top title bar to the
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		initList();
		ListView optionList = (ListView) findViewById(R.id.listView);
		ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameList);
		optionList.setAdapter(adapter); //populates list
		optionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			     public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
			         TextView clickedView = (TextView) view;
			         String textClicked = clickedView.getText().toString();
			         
			         startActivity(new Intent(MainActivity.this, MainActivity.class));
			         overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
			     }
		});
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
	
	@Override
	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(MainActivity.this,MainActivity.class));
        onBackPressed();
        return true;
    }
}
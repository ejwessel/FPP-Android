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

public class FrequenciesActivity extends Activity {

	ArrayList<String> nameList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frequencies);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		initList();
		ListView optionList = (ListView) findViewById(R.id.listView1);
		ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameList);
		optionList.setAdapter(adapter); //populates list
		optionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			     public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
			         TextView clickedView = (TextView) view;
			         String textClicked = clickedView.getText().toString();
			         
			         switch(position){
				         case 0: startActivity(new Intent(FrequenciesActivity.this, ElectronGyrofrequency.class));
					         	 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
					         	 break;
				         case 1: startActivity(new Intent(FrequenciesActivity.this, IonGyrofrequency.class));
				         		 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
				         		 break;
				         case 2: startActivity(new Intent(FrequenciesActivity.this, ElectronPlasmaFrequency.class));
				         		 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
				         		 break;
				         case 3: startActivity(new Intent(FrequenciesActivity.this, IonPlasmaFrequency.class));
		         		 		 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
		         		 		 break;
				         case 4: startActivity(new Intent(FrequenciesActivity.this, ElectronTrappingRate.class));
         		 		 	 	 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
         		 		 	 	 break;
				         case 5: startActivity(new Intent(FrequenciesActivity.this, IonTrappingRate.class));
 		 		 	 	 		 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
 		 		 	 	 		 break;
				         case 6: startActivity(new Intent(FrequenciesActivity.this, ElectronCollisionRate.class));
	 		 	 	 		 	 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
	 		 	 	 		 	 break;
				         case 7: startActivity(new Intent(FrequenciesActivity.this, IonCollisionRate.class));
		 	 	 		 	 	 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
		 	 	 		 	 	 break;
			         }
			         
			     }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.frequencies, menu);
		return true;
	}

	public void initList(){
		nameList.add("Electron Gyrofrequency");
		nameList.add("Ion Gyrofrequency");
		nameList.add("Electron Plasma Frequency");
		nameList.add("Ion Plasma Frequency");
		nameList.add("Electron Trapping Rate");
		nameList.add("Ion Trapping Rate");
		nameList.add("Electron Collision Rate");
		nameList.add("Ion Collision Rate");
	}
	
	@Override
	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(FrequenciesActivity.this, MainActivity.class));
        onBackPressed();
        return true;
    }
}

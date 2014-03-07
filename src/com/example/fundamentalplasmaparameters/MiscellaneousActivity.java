package com.example.fundamentalplasmaparameters;

import java.util.ArrayList;

import com.ewit.FPP.*;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MiscellaneousActivity extends Activity {

	ArrayList<String> nameList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.miscellaneous);
		
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
			         case 0: startActivity(new Intent(MiscellaneousActivity.this, BohmDiffusionCoefficient.class));
				         	 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
				         	 break;
			         case 1: startActivity(new Intent(MiscellaneousActivity.this, SpitzerResistivity.class));
		         	 		 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
		         	 		 break;
		         }
		     }
		});
	}

	public void initList(){
		nameList.add("Bohm Diffusion Coefficient");
		nameList.add("Spitzer Resistivity");
	}
	
	@Override
	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(MiscellaneousActivity.this, MainActivity.class));
        onBackPressed();
        return true;
    }
}

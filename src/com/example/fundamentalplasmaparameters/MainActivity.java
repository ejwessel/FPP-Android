package com.example.fundamentalplasmaparameters;

import java.util.ArrayList;

import com.ewit.FPP.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
				
		initList();
		ListView optionList = (ListView) findViewById(R.id.listView1);
		ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameList);
		optionList.setAdapter(adapter); //populates list
		optionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			     public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
			         TextView clickedView = (TextView) view;
			         String textClicked = clickedView.getText().toString();
			         
			         switch(position){
			         	case 0: startActivity(new Intent(MainActivity.this, FrequenciesActivity.class));
				         		overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
				         		break;
			         	case 1: startActivity(new Intent(MainActivity.this, LengthsActivity.class));
		         				overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
		         				break;
			         	case 2: startActivity(new Intent(MainActivity.this, VelocitiesActivity.class));
		         				overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
		         				break;
			         	case 3: startActivity(new Intent(MainActivity.this, DimensionlessActivity.class));
		         				overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
		         				break;
			         	case 4: startActivity(new Intent(MainActivity.this, MiscellaneousActivity.class));
		         				overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
		         				break;
			         	case 5: startActivity(new Intent(MainActivity.this, AboutActivity.class));
		         				overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
		         				break;
			         }
			     }
		});
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
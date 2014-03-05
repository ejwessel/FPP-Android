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

public class DimensionlessActivity extends Activity {

	ArrayList<String> nameList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dimensionless);
		
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
			         case 0: startActivity(new Intent(DimensionlessActivity.this, ElectronProtonMassRatio.class));
				         	 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
				         	 break;
			         case 1: startActivity(new Intent(DimensionlessActivity.this, NumOfParticlesDebyeSphere.class));
			         		 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
			         		 break;
//			         case 2: startActivity(new Intent(DimensionlessActivity.this, AlfvenVelocityLight.class));
//			         		 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
//			         		 break;
//			         case 3: startActivity(new Intent(DimensionlessActivity.this, ElectronPlasmaGyroRatio.class));
//	         		 		 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
//	         		 		 break;
//			         case 4: startActivity(new Intent(DimensionlessActivity.this, IonPlasmaGyroRatio.class));
//     		 		 	 	 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
//     		 		 	 	 break;
//			         case 5: startActivity(new Intent(DimensionlessActivity.this, ThermalMagEnergyRatio.class));
//		 		 	 	 		 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
//		 		 	 	 		 break;
//			         case 6: startActivity(new Intent(DimensionlessActivity.this, MagIonEnergyRatio.class));
// 		 	 	 		 	 overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
// 		 	 	 		 	 break;
		         }
		     }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dimensionless, menu);
		return true;
	}

	public void initList(){
		nameList.add("Electron/Proton Mass Ratio");
		nameList.add("Number of Particles Debye Sphere");
		nameList.add("Alfven Velocity/Spd. of Light");
		nameList.add("Elect. Plas./Gyrofreq. Ratio");
		nameList.add("Ion Plas./Gyrofreq. Ratio");
		nameList.add("Thermal/Mag. Energy Ratio");
		nameList.add("Mag./Ion Rest Energy Ratio");
	}
	
	@Override
	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(DimensionlessActivity.this, MainActivity.class));
        onBackPressed();
        return true;
    }
}

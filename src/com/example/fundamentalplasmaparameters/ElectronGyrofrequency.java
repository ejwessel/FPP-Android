package com.example.fundamentalplasmaparameters;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class ElectronGyrofrequency extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.electron_gyrofrequency);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.electron_gyrofrequency, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(ElectronGyrofrequency.this, FrequenciesActivity.class));
        onBackPressed();
        return true;
    }
}

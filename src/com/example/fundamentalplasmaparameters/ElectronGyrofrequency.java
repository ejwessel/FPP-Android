package com.example.fundamentalplasmaparameters;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ElectronGyrofrequency extends Activity {
	
	EditText bInput;
	EditText bExponent;
	EditText fAnswer;
	EditText wAnswer;

	double fValue;
	double wValue;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.electron_gyrofrequency);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);		
		
		bInput = (EditText)findViewById(R.id.bInput);
		bInput.addTextChangedListener(inputWatcher);
		
		bExponent = (EditText)findViewById(R.id.bExponent);
		bExponent.addTextChangedListener(inputWatcher);

		fAnswer = (EditText)findViewById(R.id.answer_f);
		wAnswer = (EditText)findViewById(R.id.answer_w);
		
		fValue = 0;
		wValue = 0;
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

	private final TextWatcher inputWatcher = new TextWatcher() {
        
        public void beforeTextChanged(CharSequence s, int start, int count, int after){
        }

        public void onTextChanged(CharSequence s, int start, int before, int count){
        }

        public void afterTextChanged(Editable s){
        	calculate();
        }
        
        public void calculate(){
        	if(!(bInput.getText().toString().equals("") 
        			|| bExponent.getText().toString().equals("")
        			|| bExponent.getText().toString().contains("."))){
	    		double bValue = Double.parseDouble(bInput.getText().toString());
	    		double bExponentValue = Double.parseDouble(bExponent.getText().toString());
	        	double fValue = 2.80 * Math.pow(10,6) * bValue * Math.pow(10,bExponentValue);
	        	double wValue = 1.76 * Math.pow(10,7) * bValue * Math.pow(10,bExponentValue);
	        	
	        	fAnswer.setText(String.format("%.3E", fValue));
	        	wAnswer.setText(String.format("%.3E", wValue));
	    	}
	    	else{
	    		fAnswer.setText("Invalid Input");
	    		wAnswer.setText("Invalid Input");
	    	}
        }
	};
}

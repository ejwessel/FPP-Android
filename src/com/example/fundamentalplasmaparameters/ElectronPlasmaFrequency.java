package com.example.fundamentalplasmaparameters;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class ElectronPlasmaFrequency extends Activity {

	EditText nInput;
	EditText nExponent;
	EditText fAnswer;
	EditText wAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.electron_plasma_frequency);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		
		nInput = (EditText)findViewById(R.id.nInput);
		nInput.addTextChangedListener(inputWatcher);
		
		nExponent = (EditText)findViewById(R.id.nInput);
		nExponent.addTextChangedListener(inputWatcher);
		
		fAnswer = (EditText)findViewById(R.id.answer_f);
		wAnswer = (EditText)findViewById(R.id.answer_w);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.electron_plasma_frequency, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(ElectronPlasmaFrequency.this, FrequenciesActivity.class));
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
        	if(!(nInput.getText().toString().equals("") 
    			|| nExponent.getText().toString().equals("")
    			|| nExponent.getText().toString().contains("."))){
	    		double nValue = Double.parseDouble(nInput.getText().toString());
	    		double nExponentValue = Double.parseDouble(nExponent.getText().toString());
	    		nValue = Math.pow(nValue, nExponentValue);
	    		
	        	double fValue = 8.98 * Math.pow(10,3) * Math.pow(nValue, .5);
	        	double wValue = 5.64 * Math.pow(10,4) * Math.pow(nValue, .5);
	        	
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

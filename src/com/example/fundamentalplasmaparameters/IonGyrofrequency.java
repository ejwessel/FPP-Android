package com.example.fundamentalplasmaparameters;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class IonGyrofrequency extends Activity {

	EditText zInput;
	EditText muInput;
	EditText bInput;
	EditText zExponent;
	EditText muExponent;
	EditText bExponent;
	EditText fAnswer;
	EditText wAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ion_gyrofrequency);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		
		zInput = (EditText)findViewById(R.id.zInput);
		zInput.addTextChangedListener(inputWatcher);
		
		muInput = (EditText)findViewById(R.id.muInput);
		muInput.addTextChangedListener(inputWatcher);
		
		bInput = (EditText)findViewById(R.id.bInput);
		bInput.addTextChangedListener(inputWatcher);
		
		zExponent = (EditText)findViewById(R.id.zExponent);
		zExponent.addTextChangedListener(inputWatcher);
		
		muExponent = (EditText)findViewById(R.id.muExponent);
		muExponent.addTextChangedListener(inputWatcher);
		
		bExponent = (EditText)findViewById(R.id.bExponent);
		bExponent.addTextChangedListener(inputWatcher);
		
		fAnswer = (EditText)findViewById(R.id.answer_f);
		wAnswer = (EditText)findViewById(R.id.answer_w);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ion_gyrofrequency, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(IonGyrofrequency.this, FrequenciesActivity.class));
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
        		|| bInput.getText().toString().equals("-")
    			|| bExponent.getText().toString().equals("")
    			|| bExponent.getText().toString().contains(".")
    			|| bExponent.getText().toString().equals("-")
    			
    			|| zInput.getText().toString().equals("")
    			|| zInput.getText().toString().equals("-")
    			|| zExponent.getText().toString().equals("")
    			|| zExponent.getText().toString().contains(".")
    			|| zExponent.getText().toString().equals("-")
    			
    			|| muInput.getText().toString().equals("")
    			|| muInput.getText().toString().equals("-")
    			|| muExponent.getText().toString().equals("")
    			|| muExponent.getText().toString().contains(".")
    			|| muExponent.getText().toString().equals("-"))){
	    		double bValue = Double.parseDouble(bInput.getText().toString());
	    		double bExponentValue = Double.parseDouble(bExponent.getText().toString());
	    		bValue = bValue * Math.pow(10, bExponentValue);
	    		double zValue = Double.parseDouble(zInput.getText().toString());
	    		double zExponentValue = Double.parseDouble(zExponent.getText().toString());
	    		zValue = zValue * Math.pow(10, zExponentValue);
	    		double muValue = Double.parseDouble(muInput.getText().toString());
	    		double muExponentValue = Double.parseDouble(muExponent.getText().toString());
	    		muValue = muValue * Math.pow(10, muExponentValue);
	    		
	        	double fValue = 1.52 * Math.pow(10,3) * zValue * Math.pow(muValue, -1) * bValue;
	        	double wValue = 9.58 * Math.pow(10,3) * zValue * Math.pow(muValue, -1) * bValue;
	        	
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

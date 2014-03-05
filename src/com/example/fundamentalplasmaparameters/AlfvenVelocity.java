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

public class AlfvenVelocity extends Activity {

	EditText muInput;
	EditText muExponent;
	EditText nInput;
	EditText nExponent;
	EditText bInput;
	EditText bExponent;
	EditText vAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alfven_velocity);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		
		muInput = (EditText)findViewById(R.id.muInput);
		muInput.addTextChangedListener(inputWatcher);
		
		muExponent = (EditText)findViewById(R.id.muExponent);
		muExponent.addTextChangedListener(inputWatcher);
		
		nInput = (EditText)findViewById(R.id.nInput);
		nInput.addTextChangedListener(inputWatcher);
		
		nExponent = (EditText)findViewById(R.id.nExponent);
		nExponent.addTextChangedListener(inputWatcher);
		
		bInput = (EditText)findViewById(R.id.bInput);
		bInput.addTextChangedListener(inputWatcher);
		
		bExponent = (EditText)findViewById(R.id.bExponent);
		bExponent.addTextChangedListener(inputWatcher);
		
		vAnswer = (EditText)findViewById(R.id.answer_v);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alfven_velocity, menu);
		return true;
	}

	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(AlfvenVelocity.this, VelocitiesActivity.class));
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
        	if(!(muInput.getText().toString().equals("")
    			|| muInput.getText().toString().equals("-")
    			|| muExponent.getText().toString().equals("")
    			|| muExponent.getText().toString().equals("-")
    			|| muExponent.getText().toString().contains(".")
    			
    			|| nInput.getText().toString().equals("")
    			|| nInput.getText().toString().equals("-")
    			|| nExponent.getText().toString().equals("")
    			|| nExponent.getText().toString().equals("-")
    			|| nExponent.getText().toString().contains(".")
    			
    			|| bInput.getText().toString().equals("")
    			|| bInput.getText().toString().equals("-")
    			|| bExponent.getText().toString().equals("")
    			|| bExponent.getText().toString().equals("-")
    			|| bExponent.getText().toString().contains("."))){
	    		double muValue = Double.parseDouble(muInput.getText().toString());
	    		double muExponentValue = Double.parseDouble(muExponent.getText().toString());
	    		muValue = muValue * Math.pow(10, muExponentValue);
	    		double nValue = Double.parseDouble(nInput.getText().toString());
	    		double nExponentValue = Double.parseDouble(nExponent.getText().toString());
	    		nValue = nValue * Math.pow(10,nExponentValue);
	    		double bValue = Double.parseDouble(bInput.getText().toString());
	    		double bExponentValue = Double.parseDouble(bExponent.getText().toString());
	    		bValue = bValue * Math.pow(10,bExponentValue);
	    		
	        	double vValue = 2.18 * Math.pow(10,11) * Math.pow(muValue, -.5) * Math.pow(nValue, -.5) * bValue; 	
	        	vAnswer.setText(String.format("%.3E", vValue));
	    	}
	    	else{
	    		vAnswer.setText("Invalid Input");
	    	}
        }
	};
}

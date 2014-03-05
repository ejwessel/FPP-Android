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

public class ElectronInertialLength extends Activity {

	EditText nInput;
	EditText nExponent;
	EditText answer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.electron_inertial_length);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		
		nInput = (EditText)findViewById(R.id.nInput);
		nInput.addTextChangedListener(inputWatcher);
		
		nExponent = (EditText)findViewById(R.id.nExponent);
		nExponent.addTextChangedListener(inputWatcher);
		
		answer = (EditText)findViewById(R.id.answer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.electron_inertial_length, menu);
		return true;
	}

	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(ElectronInertialLength.this, LengthsActivity.class));
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
    			|| nInput.getText().toString().equals("-")
    			|| nExponent.getText().toString().equals("")
    			|| nExponent.getText().toString().equals("-")
    			|| nExponent.getText().toString().contains("."))){
        		double nValue = Double.parseDouble(nInput.getText().toString());
	    		double nExponentValue = Double.parseDouble(nExponent.getText().toString());
	    		nValue = nValue * Math.pow(10, nExponentValue);
        		
	        	double answerValue = 5.31 * Math.pow(10, 5) * Math.pow(nValue, -.5);   	
	        	answer.setText(String.format("%.3E", answerValue));
	    	}
	    	else{
	    		answer.setText("Invalid Input");
	    	}
        }
	};
}

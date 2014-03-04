package com.example.fundamentalplasmaparameters;

import com.example.fundamentalplasmaparameters.R;
import com.example.fundamentalplasmaparameters.R.anim;
import com.example.fundamentalplasmaparameters.R.id;
import com.example.fundamentalplasmaparameters.R.layout;
import com.example.fundamentalplasmaparameters.R.menu;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class ElectronTrappingRate extends Activity {

	EditText kInput;
	EditText kExponent;
	EditText eInput;
	EditText eExponent;
	EditText vAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.electron_trapping_rate);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		
		kInput = (EditText)findViewById(R.id.kInput);
		kInput.addTextChangedListener(inputWatcher);
		
		kExponent = (EditText)findViewById(R.id.kExponent);
		kExponent.addTextChangedListener(inputWatcher);
		
		eInput = (EditText)findViewById(R.id.eInput);
		eInput.addTextChangedListener(inputWatcher);
		
		eExponent = (EditText)findViewById(R.id.eExponent);
		eExponent.addTextChangedListener(inputWatcher);
		
		vAnswer = (EditText)findViewById(R.id.answer_v);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.electron_trapping_rate, menu);
		return true;
	}

	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(ElectronTrappingRate.this, FrequenciesActivity.class));
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
        	if(!(kInput.getText().toString().equals("")
    			|| kInput.getText().toString().equals("-")
    			|| kExponent.getText().toString().equals("")
    			|| kExponent.getText().toString().equals("-")
    			|| kExponent.getText().toString().contains(".")
    			
    			|| eInput.getText().toString().equals("")
    			|| eInput.getText().toString().equals("-")
    			|| eExponent.getText().toString().equals("")
    			|| eExponent.getText().toString().equals("-")
    			|| eExponent.getText().toString().contains("."))){
        		double kValue = Double.parseDouble(kInput.getText().toString());
	    		double kExponentValue = Double.parseDouble(kExponent.getText().toString());
	    		kValue = kValue * Math.pow(10, kExponentValue);
        		double eValue = Double.parseDouble(eInput.getText().toString());
	    		double eExponentValue = Double.parseDouble(eExponent.getText().toString());
	    		eValue = eValue * Math.pow(10, eExponentValue);
        		
	        	double vValue = 7.26 * Math.pow(10,8) * Math.pow(kValue, .5) * Math.pow(eValue, .5);
	        	
	        	vAnswer.setText(String.format("%.3E", vValue));
	    	}
	    	else{
	    		vAnswer.setText("Invalid Input");
	    	}
        }
	};
}

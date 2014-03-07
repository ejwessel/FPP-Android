package com.example.fundamentalplasmaparameters;

import com.ewit.FPP.*;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

public class IonTrappingRate extends Activity {

	EditText zInput;
	EditText zExponent;
	EditText kInput;
	EditText kExponent;
	EditText eInput;
	EditText eExponent;
	EditText muInput;
	EditText muExponent;
	EditText vAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ion_trapping_rate);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		
		zInput = (EditText)findViewById(R.id.zInput);
		zInput.addTextChangedListener(inputWatcher);
		
		zExponent = (EditText)findViewById(R.id.zExponent);
		zExponent.addTextChangedListener(inputWatcher);
		
		kInput = (EditText)findViewById(R.id.kInput);
		kInput.addTextChangedListener(inputWatcher);
		
		kExponent = (EditText)findViewById(R.id.kExponent);
		kExponent.addTextChangedListener(inputWatcher);
		
		eInput = (EditText)findViewById(R.id.eInput);
		eInput.addTextChangedListener(inputWatcher);
		
		eExponent = (EditText)findViewById(R.id.eExponent);
		eExponent.addTextChangedListener(inputWatcher);
		
		muInput = (EditText)findViewById(R.id.muInput);
		muInput.addTextChangedListener(inputWatcher);
		
		muExponent = (EditText)findViewById(R.id.muExponent);
		muExponent.addTextChangedListener(inputWatcher);
		
		vAnswer = (EditText)findViewById(R.id.answer_v);
	}

	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(IonTrappingRate.this, FrequenciesActivity.class));
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
        	if(!(zInput.getText().toString().equals("")
    			|| zInput.getText().toString().equals("-")
    			|| zExponent.getText().toString().equals("")
    			|| zExponent.getText().toString().equals("-")
    			|| zExponent.getText().toString().contains(".")
    			
    			|| muInput.getText().toString().equals("")
    			|| muInput.getText().toString().equals("-")
    			|| muExponent.getText().toString().equals("")
    			|| muExponent.getText().toString().equals("-")
    			|| muExponent.getText().toString().contains(".")
    			
    			|| kInput.getText().toString().equals("")
    			|| kInput.getText().toString().equals("-")
    			|| kExponent.getText().toString().equals("")
    			|| kExponent.getText().toString().equals("-")
    			|| kExponent.getText().toString().contains(".")
    			
    			|| eInput.getText().toString().equals("")
    			|| eInput.getText().toString().equals("-")
    			|| eExponent.getText().toString().equals("")
    			|| eExponent.getText().toString().equals("-")
    			|| eExponent.getText().toString().contains("."))){
        		double zValue = Double.parseDouble(zInput.getText().toString());
	    		double zExponentValue = Double.parseDouble(zExponent.getText().toString());
	    		zValue = zValue * Math.pow(10, zExponentValue);
        		double muValue = Double.parseDouble(muInput.getText().toString());
	    		double muExponentValue = Double.parseDouble(muExponent.getText().toString());
	    		muValue = muValue * Math.pow(10, muExponentValue);
        		double kValue = Double.parseDouble(kInput.getText().toString());
	    		double kExponentValue = Double.parseDouble(kExponent.getText().toString());
	    		kValue = kValue * Math.pow(10, kExponentValue);
	    		double eValue = Double.parseDouble(eInput.getText().toString());
	    		double eExponentValue = Double.parseDouble(eExponent.getText().toString());
	    		eValue = eValue * Math.pow(10, eExponentValue);
	    		
	        	double vValue = 1.69 * Math.pow(10,7) * Math.pow(zValue, .5) * Math.pow(kValue, .5) * Math.pow(eValue, .5) * Math.pow(muValue, -.5);
	        	vAnswer.setText(String.format("%.3E", vValue));
	    	}
	    	else{
	    		vAnswer.setText("Invalid Input");
	    	}
        }
	};
}

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

public class IonPlasmaFrequency extends Activity {

	EditText zInput;
	EditText zExponent;
	EditText muInput;
	EditText muExponent;
	EditText nInput;
	EditText nExponent;
	EditText fAnswer;
	EditText wAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ion_plasma_frequency);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		
		nInput = (EditText)findViewById(R.id.nInput);
		nInput.addTextChangedListener(inputWatcher);
		
		nExponent = (EditText)findViewById(R.id.nExponent);
		nExponent.addTextChangedListener(inputWatcher);
		
		zInput = (EditText)findViewById(R.id.zInput);
		zInput.addTextChangedListener(inputWatcher);
		
		zExponent = (EditText)findViewById(R.id.zExponent);
		zExponent.addTextChangedListener(inputWatcher);

		muInput = (EditText)findViewById(R.id.muInput);
		muInput.addTextChangedListener(inputWatcher);
		
		muExponent = (EditText)findViewById(R.id.muExponent);
		muExponent.addTextChangedListener(inputWatcher);
		
		fAnswer = (EditText)findViewById(R.id.answer_f);
		wAnswer = (EditText)findViewById(R.id.answer_w);
	}

	@Override
	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(IonPlasmaFrequency.this, FrequenciesActivity.class));
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
    			
    			|| nInput.getText().toString().equals("")
    			|| nInput.getText().toString().equals("-")
    			|| nExponent.getText().toString().equals("")
    			|| nExponent.getText().toString().equals("-")
    			|| nExponent.getText().toString().contains("."))){
        		double zValue = Double.parseDouble(zInput.getText().toString());
	    		double zExponentValue = Double.parseDouble(zExponent.getText().toString());
	    		zValue = zValue * Math.pow(10, zExponentValue);
        		double muValue = Double.parseDouble(muInput.getText().toString());
	    		double muExponentValue = Double.parseDouble(muExponent.getText().toString());
	    		muValue = muValue * Math.pow(10, muExponentValue);
        		double nValue = Double.parseDouble(nInput.getText().toString());
	    		double nExponentValue = Double.parseDouble(nExponent.getText().toString());
	    		nValue = nValue * Math.pow(10, nExponentValue);
	    		
	        	double fValue = 2.10 * Math.pow(10,2) * zValue * Math.pow(muValue, -.5) * Math.pow(nValue, .5);
	        	double wValue = 1.32 * Math.pow(10,3) * zValue * Math.pow(muValue, -.5) * Math.pow(nValue, .5);
	        	
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

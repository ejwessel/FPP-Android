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

public class ElectronCollisionRate extends Activity {

	EditText nInput;
	EditText nExponent;
	EditText lambdaInput;
	EditText lambdaExponent;
	EditText tInput;
	EditText tExponent;
	EditText vAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.electron_collision_rate);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		
		nInput = (EditText)findViewById(R.id.nInput);
		nInput.addTextChangedListener(inputWatcher);
		
		nExponent = (EditText)findViewById(R.id.nExponent);
		nExponent.addTextChangedListener(inputWatcher);
		
		lambdaInput = (EditText)findViewById(R.id.lambdaInput);
		lambdaInput.addTextChangedListener(inputWatcher);
		
		lambdaExponent = (EditText)findViewById(R.id.lambdaExponent);
		lambdaExponent.addTextChangedListener(inputWatcher);
		
		tInput = (EditText)findViewById(R.id.tInput);
		tInput.addTextChangedListener(inputWatcher);
		
		tExponent = (EditText)findViewById(R.id.tExponent);
		tExponent.addTextChangedListener(inputWatcher);
		
		vAnswer = (EditText)findViewById(R.id.answer_v);
	}

	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(ElectronCollisionRate.this, FrequenciesActivity.class));
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
        	if(!(lambdaInput.getText().toString().equals("")
    			|| lambdaInput.getText().toString().equals("-")
    			|| lambdaExponent.getText().toString().equals("")
    			|| lambdaExponent.getText().toString().equals("-")
    			|| lambdaExponent.getText().toString().contains(".")
    			
    			|| tInput.getText().toString().equals("")
    			|| tInput.getText().toString().equals("-")
    			|| tExponent.getText().toString().equals("")
    			|| tExponent.getText().toString().equals("-")
    			|| tExponent.getText().toString().contains(".")
    			
    			|| nInput.getText().toString().equals("")
    			|| nInput.getText().toString().equals("-")
    			|| nExponent.getText().toString().equals("")
    			|| nExponent.getText().toString().equals("-")
    			|| nExponent.getText().toString().contains("."))){
        		double nValue = Double.parseDouble(nInput.getText().toString());
	    		double nExponentValue = Double.parseDouble(nExponent.getText().toString());
	    		nValue = nValue * Math.pow(10, nExponentValue);
        		double lambdaValue = Double.parseDouble(lambdaInput.getText().toString());
	    		double lambdaExponentValue = Double.parseDouble(lambdaExponent.getText().toString());
	    		lambdaValue = lambdaValue * Math.pow(10, lambdaExponentValue);
        		double tValue = Double.parseDouble(tInput.getText().toString());
	    		double tExponentValue = Double.parseDouble(tExponent.getText().toString());
	    		tValue = tValue * Math.pow(10, tExponentValue);
	    		
	        	double vValue = 2.91 * Math.pow(10,-6) * nValue * lambdaValue * Math.pow(tValue, -1.5);
	        	
	        	vAnswer.setText(String.format("%.3E", vValue));
	    	}
	    	else{
	    		vAnswer.setText("Invalid Input");
	    	}
        }
	};
}

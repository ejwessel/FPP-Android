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

public class ElectronDeBroglieLength extends Activity {

	EditText tInput;
	EditText tExponent;
	EditText lambdaAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.electron_de_broglie_length);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		
		tInput = (EditText)findViewById(R.id.tInput);
		tInput.addTextChangedListener(inputWatcher);
		
		tExponent = (EditText)findViewById(R.id.tExponent);
		tExponent.addTextChangedListener(inputWatcher);
		
		lambdaAnswer = (EditText)findViewById(R.id.answer_lambda);
	}

	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(ElectronDeBroglieLength.this, LengthsActivity.class));
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
        	if(!(tInput.getText().toString().equals("")
    			|| tInput.getText().toString().equals("-")
    			|| tExponent.getText().toString().equals("")
    			|| tExponent.getText().toString().equals("-")
    			|| tExponent.getText().toString().contains("."))){
        		double tValue = Double.parseDouble(tInput.getText().toString());
	    		double tExponentValue = Double.parseDouble(tExponent.getText().toString());
	    		tValue = tValue * Math.pow(10, tExponentValue);
        		
	        	double lambaValue = 2.76 * Math.pow(10,-8) * Math.pow(tValue, -.5);   	
	        	lambdaAnswer.setText(String.format("%.3E", lambaValue));
	    	}
	    	else{
	    		lambdaAnswer.setText("Invalid Input");
	    	}
        }
	};
}

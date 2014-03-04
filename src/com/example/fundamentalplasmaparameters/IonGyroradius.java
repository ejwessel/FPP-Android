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

public class IonGyroradius extends Activity {

	EditText muInput;
	EditText muExponent;
	EditText zInput;
	EditText zExponent;
	EditText tInput;
	EditText tExponent;
	EditText bInput;
	EditText bExponent;
	EditText rAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ion_gyroradius);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		
		muInput = (EditText)findViewById(R.id.muInput);
		muInput.addTextChangedListener(inputWatcher);
		
		muExponent = (EditText)findViewById(R.id.muExponent);
		muExponent.addTextChangedListener(inputWatcher);
		
		zInput = (EditText)findViewById(R.id.zInput);
		zInput.addTextChangedListener(inputWatcher);
		
		zExponent = (EditText)findViewById(R.id.zExponent);
		zExponent.addTextChangedListener(inputWatcher);
		
		tInput = (EditText)findViewById(R.id.tInput);
		tInput.addTextChangedListener(inputWatcher);
		
		tExponent = (EditText)findViewById(R.id.tExponent);
		tExponent.addTextChangedListener(inputWatcher);
		
		bInput = (EditText)findViewById(R.id.bInput);
		bInput.addTextChangedListener(inputWatcher);
		
		bExponent = (EditText)findViewById(R.id.bExponent);
		bExponent.addTextChangedListener(inputWatcher);
		
		rAnswer = (EditText)findViewById(R.id.answer_r);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ion_gyroradius, menu);
		return true;
	}

	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(IonGyroradius.this, LengthsActivity.class));
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
    			|| tExponent.getText().toString().contains(".")
        		
    			|| muInput.getText().toString().equals("")
    			|| muInput.getText().toString().equals("-")
    			|| muExponent.getText().toString().equals("")
    			|| muExponent.getText().toString().equals("-")
    			|| muExponent.getText().toString().contains(".")
    			
    			|| zInput.getText().toString().equals("")
    			|| zInput.getText().toString().equals("-")
    			|| zExponent.getText().toString().equals("")
    			|| zExponent.getText().toString().equals("-")
    			|| zExponent.getText().toString().contains(".")
    			
    			|| bInput.getText().toString().equals("")
    			|| bInput.getText().toString().equals("-")
    			|| bExponent.getText().toString().equals("")
    			|| bExponent.getText().toString().equals("-")
    			|| bExponent.getText().toString().contains("."))){
        		double tValue = Double.parseDouble(tInput.getText().toString());
	    		double tExponentValue = Double.parseDouble(tExponent.getText().toString());
	    		tValue = tValue * Math.pow(10, tExponentValue);
	    		double muValue = Double.parseDouble(muInput.getText().toString());
	    		double muExponentValue = Double.parseDouble(muExponent.getText().toString());
	    		muValue = muValue * Math.pow(10, muExponentValue);
	    		double zValue = Double.parseDouble(zInput.getText().toString());
	    		double zExponentValue = Double.parseDouble(zExponent.getText().toString());
	    		zValue = zValue * Math.pow(10, zExponentValue);
	    		double bValue = Double.parseDouble(bInput.getText().toString());
	    		double bExponentValue = Double.parseDouble(bExponent.getText().toString());
	    		bValue = bValue * Math.pow(10, bExponentValue);
        		
	        	double rValue = 1.02 * Math.pow(10,2) * Math.pow(muValue, .5) * Math.pow(zValue, -1) * Math.pow(tValue, .5) * Math.pow(bValue, -1);   	
	        	rAnswer.setText(String.format("%.3E", rValue));
	    	}
	    	else{
	    		rAnswer.setText("Invalid Input");
	    	}
        }
	};
	
}

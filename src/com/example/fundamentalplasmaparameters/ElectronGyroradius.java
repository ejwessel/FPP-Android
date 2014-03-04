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

public class ElectronGyroradius extends Activity {

	EditText tInput;
	EditText tExponent;
	EditText bInput;
	EditText bExponent;
	EditText rAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.electron_gyroradius);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		
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
		getMenuInflater().inflate(R.menu.electron_gyroradius, menu);
		return true;
	}

	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(ElectronGyroradius.this, LengthsActivity.class));
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
    			
    			|| bInput.getText().toString().equals("")
    			|| bInput.getText().toString().equals("-")
    			|| bExponent.getText().toString().equals("")
    			|| bExponent.getText().toString().equals("-")
    			|| bExponent.getText().toString().contains("."))){
        		double tValue = Double.parseDouble(tInput.getText().toString());
	    		double tExponentValue = Double.parseDouble(tExponent.getText().toString());
	    		tValue = tValue * Math.pow(10, tExponentValue);
	    		double bValue = Double.parseDouble(bInput.getText().toString());
	    		double bExponentValue = Double.parseDouble(bExponent.getText().toString());
	    		bValue = bValue * Math.pow(10, bExponentValue);
        		
	        	double lambaValue = 2.38 * Math.pow(tValue, .5) * Math.pow(bValue, -1);   	
	        	rAnswer.setText(String.format("%.3E", lambaValue));
	    	}
	    	else{
	    		rAnswer.setText("Invalid Input");
	    	}
        }
	};
}

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

public class SpitzerResistivity extends Activity {

	EditText zInput;
	EditText zExponent;
	EditText lambdaInput;
	EditText lambdaExponent;
	EditText tInput;
	EditText tExponent;
	EditText perpendicularAnswer;
	EditText parallelAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spitzer_resistivity);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		
		zInput = (EditText)findViewById(R.id.zInput);
		zInput.addTextChangedListener(inputWatcher);
		
		zExponent = (EditText)findViewById(R.id.zExponent);
		zExponent.addTextChangedListener(inputWatcher);
		
		lambdaInput = (EditText)findViewById(R.id.lambdaInput);
		lambdaInput.addTextChangedListener(inputWatcher);
		
		lambdaExponent = (EditText)findViewById(R.id.tExponent);
		lambdaExponent.addTextChangedListener(inputWatcher);

		tInput = (EditText)findViewById(R.id.tInput);
		tInput.addTextChangedListener(inputWatcher);
		
		tExponent = (EditText)findViewById(R.id.tExponent);
		tExponent.addTextChangedListener(inputWatcher);

		
		perpendicularAnswer = (EditText)findViewById(R.id.answer_perp);
		parallelAnswer = (EditText)findViewById(R.id.answer_parallel);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spitzer_resistivity, menu);
		return true;
	}

	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(SpitzerResistivity.this, MiscellaneousActivity.class));
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
        		
    			|| zInput.getText().toString().equals("")
    			|| zInput.getText().toString().equals("-")
    			|| zExponent.getText().toString().equals("")
    			|| zExponent.getText().toString().equals("-")
    			|| zExponent.getText().toString().contains(".")
    			
    			|| lambdaInput.getText().toString().equals("")
    			|| lambdaInput.getText().toString().equals("-")
    			|| lambdaExponent.getText().toString().equals("")
    			|| lambdaExponent.getText().toString().equals("-")
    			|| lambdaExponent.getText().toString().contains("."))){
	    		double tValue = Double.parseDouble(tInput.getText().toString());
	    		double tExponentValue = Double.parseDouble(tExponent.getText().toString());
	    		tValue = tValue * Math.pow(10, tExponentValue);
	    		double zValue = Double.parseDouble(zInput.getText().toString());
	    		double zExponentValue = Double.parseDouble(zExponent.getText().toString());
	    		zValue = zValue * Math.pow(10, zExponentValue);
	    		double lambdaValue = Double.parseDouble(lambdaInput.getText().toString());
	    		double lambdaExponentValue = Double.parseDouble(lambdaExponent.getText().toString());
	    		lambdaValue = lambdaValue * Math.pow(10, lambdaExponentValue);
	    		
	        	double perpValue = 1.03 * Math.pow(10,-2) * zValue * lambdaValue * Math.pow(tValue, -1.5);
	        	double paraValue = perpValue / 2;
	        	   	
	        	perpendicularAnswer.setText(String.format("%.3E", perpValue));
	        	parallelAnswer.setText(String.format("%.3E", paraValue));
	    	}
	    	else{
	    		perpendicularAnswer.setText("Invalid Input");
	    		parallelAnswer.setText("Invalid Input");
	    	}
        }
	};
}

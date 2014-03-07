package com.example.fundamentalplasmaparameters;

import com.ewit.FPP.*;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		TextView feedback = (TextView) findViewById(R.id.site);
		feedback.setText(Html.fromHtml("<a href=\"mailto:fundamentalplasmaparams@gmail.com?subject=Feedback or Suggestions\">Send Feedback</a>"));
		feedback.setMovementMethod(LinkMovementMethod.getInstance());
	}

	@Override
	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem menuItem){       
        startActivity(new Intent(AboutActivity.this, MainActivity.class));
        onBackPressed();
        return true;
    }    
}

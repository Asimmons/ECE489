package com.asimmons.ece489.HW2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText editText;
	private Button go;
	private NumberPicker numPick;
	private TextView output;
	private CheckBox alphaNum;
	private static int maxVal = 26;
	private static int minVal = 1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dual.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			//@Override
			//public boolean onMenuItemClick(MenuItem item) {
					//DualActivity da = new DualActivity(); 
					//da.setVisible(true);
					//ma.setVisible(false);
				//return false;
			//}
		//});
        
        editText = (EditText)findViewById(R.id.main_text);
        go = (Button)findViewById(R.id.go_button);
        numPick = (NumberPicker)findViewById(R.id.num_pick);
        numPick.setMaxValue(maxVal);
        numPick.setMinValue(minVal);
        output = (TextView)findViewById(R.id.output);
        alphaNum = (CheckBox)findViewById(R.id.check);
        go.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if(arg0 instanceof Button) {
					shiftText();
				}
				
			}        	
        });
    }
    
    private void shiftText() {
    	if(alphaNum.isChecked()) {
    		char[] in = editText.getText().toString().toCharArray();
    		int shift = numPick.getValue();
    		for (int i = 0; i < in.length; i++) {
    			if (in[i] >= ' ' && in[i] <= '~') {
	    			if ((int)in[i]+shift > (int)'~') {
	    				in[i] = (char)((int)' ' + ((int)in[i])+shift-1-((int)'~'));
	    			}
	    			else {
	    				in[i] = (char)(((int)in[i])+shift);
	    			}
	    		}
    		}
    		output.setText(new String(in));
    	}
    	else {
    		char[] in = editText.getText().toString().toUpperCase().toCharArray();
    		int shift = numPick.getValue();
    		for (int i = 0; i < in.length; i++) {
    			if (in[i] >= 'A' && in[i] <= 'Z') {
	    			if ((int)in[i]+shift > (int)'Z') {
	    				in[i] = (char)((int)'A' + ((int)in[i])+shift-1-((int)'Z'));
	    			}
	    			else {
	    				in[i] = (char)(((int)in[i])+shift);
	    			}
	    		}
    		}
    		output.setText(new String(in));
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		startActivity(new Intent(getBaseContext(),DualActivity.class));
		return false;
	}
    
}

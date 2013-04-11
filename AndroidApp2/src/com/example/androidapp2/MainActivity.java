package com.example.androidapp2;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
//import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.Button;
//import android.widget.LinearLayout;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		
		
		AbsoluteLayout _layout = (AbsoluteLayout) findViewById(R.id.mainLayout);	
        Button _button = new Button(this);
        
        AbsoluteLayout.LayoutParams _buttonLayoutParams = new AbsoluteLayout.LayoutParams(200, 100, 10, 10);
        _button.setText(R.string.strClickButton);
        _button.setId(100);
        _button.setLayoutParams(_buttonLayoutParams);
        
        try {
            _layout.addView(_button);
        }
        catch(Exception exc){
        	Log.e("add button", exc.toString());
        }
        
        _button.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void onClick(View v) {
		Button _button = (Button)v;

        AbsoluteLayout _layout = (AbsoluteLayout) findViewById(R.id.mainLayout);
        
        int _x = new Random().nextInt(_layout.getWidth()/2);
        int _y = new Random().nextInt(_layout.getHeight()/2);
                
        Log.i("button location", "X: " + _x + "; Y: " + _y);
		
        AbsoluteLayout.LayoutParams _buttonLayoutParams = new AbsoluteLayout.LayoutParams(200, 100, _x, _y);
        _button.setLayoutParams(_buttonLayoutParams);
		
		//finish();
	}

}

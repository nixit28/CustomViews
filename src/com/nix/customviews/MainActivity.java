package com.nix.customviews;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
	private ImageCheckedTextView viewLinux, viewMac, viewWindows;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        viewLinux = (ImageCheckedTextView)findViewById(R.id.viewLinux);
        viewWindows = (ImageCheckedTextView)findViewById(R.id.viewWindows);
        viewMac = (ImageCheckedTextView)findViewById(R.id.viewMac);
        
        viewLinux.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				viewLinux.getWrapedChkTxtView().setChecked(!viewLinux.getWrapedChkTxtView().isChecked());
//				viewLinux.getWrapedChkTxtView().setText("Wow I Love linux");
				Log.i(TAG, "I have clicked onLinux");
				
			}
		});
        viewMac.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		Log.i(TAG, "I have clicked onMac");
        		viewMac.getWrapedChkTxtView().setChecked(!viewMac.getWrapedChkTxtView().isChecked());
//        		viewMac.getWrapedChkTxtView().setText("I won't buy one");
        		
        	}
        });
        viewWindows.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		viewWindows.getWrapedChkTxtView().setChecked(!viewWindows.getWrapedChkTxtView().isChecked());
        		Log.i(TAG, "I have clicked onWindows");
//        		viewWindows.getWrapedChkTxtView().setText("I have malewares");
        	}
        });
    }

}

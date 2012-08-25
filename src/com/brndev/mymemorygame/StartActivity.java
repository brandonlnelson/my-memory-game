package com.brndev.mymemorygame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.appbrain.AppBrain;
import com.apperhand.device.android.AndroidSDKProvider;

//import com.google.ads.AdView;

import com.tapfortap.AdView;
import com.tapfortap.TapForTap;

public class StartActivity extends Activity {

	private Button button;
	private AdView adView;

	
	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
	     
	        AndroidSDKProvider.initSDK(this);
        
       resetSplash();
     
		
	}
	
	
	
	
	public void resetSplash() {
		
		AppBrain.init(this);
        
        TapForTap.setDefaultAppId("5fe5e740-d09a-012f-fc52-4040d804a637");
        TapForTap.checkIn(this);
        
		setContentView(R.layout.activity_start);
	
	button = (Button) findViewById(R.id.button);
	
	button.setOnClickListener(
			new OnClickListener() {
		public void onClick(View v) {
			
			startGame();
		}
		
	});
    
	adView = (AdView) findViewById(R.id.ad_view);

	adView.loadAds();
    
    
   

	}
	
	
	
	
	
	public void startGame() {
		Intent i = new Intent(this, MainActivity.class);
		
		startActivity(i);
	}

	
	
	@Override
	public void onResume() {
		super.onResume();
		
resetSplash();

      
	}
	
	@Override
	public void onBackPressed() {
    	AppBrain.getAds().showInterstitial(this);
	    finish();
	}
}

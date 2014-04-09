package com.helloword.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

import com.helloword.R;

public class OpenActivity extends BaseActivity {
    
    private final int OPEN_DURATION = 3000; //milliseconds
    private ImageView background;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_open);
		
		background = (ImageView) findViewById(R.id.open_bg);
	}
	
	@Override
	protected void onStart() {
	    super.onStart();		
		AnimationListener animEnd = new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
                goMainInterfaceActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
                
            }
		};
		fadeIn(background, OPEN_DURATION, animEnd);
		
	}
	
	@Override
	protected void onStop() {
	    super.onStop();
	    clearAnim(background);
	}
	
	public void goMainInterfaceActivity() {
		Intent intent = new Intent(this, MainInterfaceActivity.class);
		startActivity(intent);
		finish();
	}
}
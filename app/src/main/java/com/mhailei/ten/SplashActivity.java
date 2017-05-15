package com.mhailei.ten;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class SplashActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
    }

    private void initView() {
        mImageView = ((ImageView) findViewById(R.id.splash_image));
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.image_translate);
        mImageView.startAnimation(animation);
    }
}

package com.mhailei.ten.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mhailei.ten.FavouriteActivity;
import com.mhailei.ten.R;

/**
 * Created by mhailei on 2017/5/15.
 */

public class PersonalFragment extends BaseFragment {

    public static final String TAG = PersonalFragment.class.getName();
    private RelativeLayout mRelativeLayout;
    private ImageView mImageView;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initView() {
        mRelativeLayout = ((RelativeLayout) findViewById(R.id.favorite));
        mImageView = ((ImageView) findViewById(R.id.login));
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),FavouriteActivity.class));
            }
        });

    }
}

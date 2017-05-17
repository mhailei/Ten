package com.mhailei.ten.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.mhailei.ten.R;

/**
 * Created by mhailei on 2017/5/16.
 */

public class PersonalItemView  extends RelativeLayout{
    public PersonalItemView(Context context) {
        super(context,null);
    }

    public PersonalItemView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public PersonalItemView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

        View.inflate(context,R.layout.persenal_item_view,this);
    }
}

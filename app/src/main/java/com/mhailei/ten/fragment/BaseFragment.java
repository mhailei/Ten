package com.mhailei.ten.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mhailei on 2017/5/15.
 */

public abstract class BaseFragment extends Fragment {

    protected View layout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(getLayoutID(),container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }
    protected abstract int getLayoutID();
    protected abstract void initView();
    protected View findViewById(int id){
        return layout.findViewById(id);
    }
}

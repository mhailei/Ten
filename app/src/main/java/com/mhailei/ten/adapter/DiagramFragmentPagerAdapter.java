package com.mhailei.ten.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mhailei.ten.bean.DiagramListBean;
import com.mhailei.ten.constants.TranslateConfig;
import com.mhailei.ten.fragment.DiagramContentFragment;

import java.util.List;

/**
 * Created by mhailei on 2017/5/16.
 */

public class DiagramFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<DiagramListBean.DiagramBean> data;

    public DiagramFragmentPagerAdapter(FragmentManager fm,List<DiagramListBean.DiagramBean> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        DiagramListBean.DiagramBean diagramBean = data.get(position);
        //实例Fragment
        DiagramContentFragment diagramContentFragment = new DiagramContentFragment();

        Bundle bundle = new Bundle();
        int id = diagramBean.getId();
        bundle.putString(TranslateConfig.ID,id+"");
        diagramContentFragment.setArguments(bundle);

        return diagramContentFragment;
    }

    @Override
    public int getCount() {
        return data.size();
    }
}

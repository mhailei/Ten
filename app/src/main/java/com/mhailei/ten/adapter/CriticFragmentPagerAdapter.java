package com.mhailei.ten.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mhailei.ten.bean.CriticListBean;
import com.mhailei.ten.constants.TranslateConfig;
import com.mhailei.ten.fragment.CriticContentFragment;

import java.util.List;

/**
 * Created by mhailei on 2017/5/17.
 */

public class CriticFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<CriticListBean.CriticBean> data;

    public CriticFragmentPagerAdapter(FragmentManager fm,List<CriticListBean.CriticBean> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        CriticListBean.CriticBean criticBean = data.get(position);
        //实例化Fragment
        CriticContentFragment criticContentFragment = new CriticContentFragment();

        Bundle bundle = new Bundle();
        int id = criticBean.getId();
        bundle.putString(TranslateConfig.ID, id +"");
        criticContentFragment.setArguments(bundle);
        return criticContentFragment;
    }

    @Override
    public int getCount() {
        return data.size();
    }
}

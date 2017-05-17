package com.mhailei.ten.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mhailei.ten.bean.NovelListBean;
import com.mhailei.ten.constants.TranslateConfig;
import com.mhailei.ten.fragment.NovelContentFragment;

import java.util.List;

/**
 * Created by mhailei on 2017/5/17.
 */

public class NovelFragmentPagerAdapter extends FragmentStatePagerAdapter {


    private List<NovelListBean.NovelBean> data;

    public NovelFragmentPagerAdapter(FragmentManager fm, List<NovelListBean.NovelBean> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        NovelListBean.NovelBean novelBean = data.get(position);
        NovelContentFragment novelContentFragment = new NovelContentFragment();

        Bundle bundle = new Bundle();
        int id = novelBean.getId();
        bundle.putString(TranslateConfig.ID, id+"");
        novelContentFragment.setArguments(bundle);
        return novelContentFragment;
    }

    @Override
    public int getCount() {
        return data.size();
    }
}

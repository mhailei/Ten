package com.mhailei.ten.fragment;

import android.support.v4.view.ViewPager;
import android.util.Log;

import com.mhailei.ten.R;
import com.mhailei.ten.adapter.CriticFragmentPagerAdapter;
import com.mhailei.ten.api.ApiClient;
import com.mhailei.ten.api.ApiService;
import com.mhailei.ten.bean.CriticListBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mhailei on 2017/5/15.
 */

public class CriticFragment extends BaseFragment {

    public static final String TAG = CriticFragment.class.getName();
    private ViewPager mViewPager;
    private List<CriticListBean.CriticBean> mCriticBeen;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_critic;
    }

    @Override
    protected void initView() {
        mViewPager = ((ViewPager) findViewById(R.id.critic_pager));

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        setupView();
    }

    private void setupView() {
        ApiService apiService = ApiClient.getApiService();
        Call<CriticListBean> criticList = apiService.getCriticList();
        criticList.enqueue(new Callback<CriticListBean>() {
            @Override
            public void onResponse(Call<CriticListBean> call, Response<CriticListBean> response) {
                Log.e(TAG, "onResponse: ");
                mCriticBeen = response.body().getResult();

                mViewPager.setAdapter(new CriticFragmentPagerAdapter(getChildFragmentManager(),mCriticBeen));
            }

            @Override
            public void onFailure(Call<CriticListBean> call, Throwable t) {
                Log.e(TAG, "onFailure: " );
            }
        });

    }
}

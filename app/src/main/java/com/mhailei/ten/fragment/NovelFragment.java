package com.mhailei.ten.fragment;

import android.support.v4.view.ViewPager;

import com.mhailei.ten.R;
import com.mhailei.ten.adapter.NovelFragmentPagerAdapter;
import com.mhailei.ten.api.ApiClient;
import com.mhailei.ten.api.ApiService;
import com.mhailei.ten.bean.NovelListBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mhailei on 2017/5/15.
 */

public class NovelFragment extends BaseFragment {

    public static final String TAG = NovelFragment.class.getName();
    private ViewPager mViewPager;
    private List<NovelListBean.NovelBean> mNovelBeens;
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_novel;
    }

    @Override
    protected void initView() {
        mViewPager = ((ViewPager) findViewById(R.id.novel_pager));

        setupView();
    }

    private void setupView() {
        ApiService apiService = ApiClient.getApiService();
        Call<NovelListBean> novelList = apiService.getNovelList();
        novelList.enqueue(new Callback<NovelListBean>() {


            @Override
            public void onResponse(Call<NovelListBean> call, Response<NovelListBean> response) {
                mNovelBeens = response.body().getResult();

                mViewPager.setAdapter(new NovelFragmentPagerAdapter(getChildFragmentManager(),mNovelBeens));
            }

            @Override
            public void onFailure(Call<NovelListBean> call, Throwable t) {

            }
        });
    }
}

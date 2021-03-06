package com.mhailei.ten.fragment;

import android.support.v4.view.ViewPager;
import android.util.Log;

import com.mhailei.ten.R;
import com.mhailei.ten.adapter.DiagramFragmentPagerAdapter;
import com.mhailei.ten.api.ApiClient;
import com.mhailei.ten.api.ApiService;
import com.mhailei.ten.bean.DiagramListBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mhailei on 2017/5/15.
 */

public class DiagramFragment extends BaseFragment {

    public static final String TAG = DiagramFragment.class.getName();
    private ViewPager mViewPager;
    private List<DiagramListBean.DiagramBean> mDiagramBeens;
    private int mId;
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_diagram;
    }

    @Override
    protected void initView() {

        mViewPager = ((ViewPager) findViewById(R.id.diagram_pager));

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                mId = mDiagramBeens.get(position).getId();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupView();
    }

    private void setupView() {
        ApiService apiService = ApiClient.getApiService();
        Call<DiagramListBean> diagramList = apiService.getDiagramList();
        diagramList.enqueue(new Callback<DiagramListBean>() {
            @Override
            public void onResponse(Call<DiagramListBean> call, Response<DiagramListBean> response) {
                Log.e(TAG, "onResponse: " );
                mDiagramBeens = response.body().getResult();


                mViewPager.setAdapter(new DiagramFragmentPagerAdapter(getChildFragmentManager(),mDiagramBeens));

            }

            @Override
            public void onFailure(Call<DiagramListBean> call, Throwable t) {
                Log.e(TAG, "onFailure: " );

            }
        });


    }
}

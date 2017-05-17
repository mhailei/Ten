package com.mhailei.ten.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mhailei.ten.R;
import com.mhailei.ten.api.ApiClient;
import com.mhailei.ten.api.ApiService;
import com.mhailei.ten.bean.NovelBean;
import com.mhailei.ten.constants.TranslateConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mhailei on 2017/5/17.
 */

public class NovelContentFragment extends BaseFragment {

    public static final String TAG = "NovelContentFragment";
    private TextView title;
    private TextView novel_author;
    private TextView times;
    private TextView novel_summary;
    private TextView novel_text;
    private TextView novel_author1;
    private TextView novel_authorbrief;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_novel_content;
    }

    @Override
    protected void initView() {
        title = ((TextView) findViewById(R.id.novel_title));
        novel_author = ((TextView) findViewById(R.id.novel_author));
        times = ((TextView) findViewById(R.id.times));
        novel_summary = ((TextView) findViewById(R.id.novel_summary));
        novel_text = ((TextView) findViewById(R.id.novel_text));
        novel_author1 = ((TextView) findViewById(R.id.novel_author1));
        novel_authorbrief = ((TextView) findViewById(R.id.novel_authorbrief));

        Bundle bundle = getArguments();
        String id = bundle.getString(TranslateConfig.ID);

        ApiService apiService = ApiClient.getApiService();
        Call<NovelBean> novelBean = apiService.getNovelBean(id);
        novelBean.enqueue(new Callback<NovelBean>() {
            @Override
            public void onResponse(Call<NovelBean> call, Response<NovelBean> response) {
                Log.e(TAG, "onResponse: ");
                NovelBean bean = response.body();
                title.setText(bean.getTitle());
                novel_author.setText(bean.getAuthor());
               times.setText(bean.getTimes()+"");
                novel_summary.setText(bean.getSummary());
                novel_text.setText(bean.getText());
                novel_author1.setText(bean.getAuthor());
                novel_authorbrief.setText(bean.getAuthorbrief());
            }

            @Override
            public void onFailure(Call<NovelBean> call, Throwable t) {

            }
        });


    }
}

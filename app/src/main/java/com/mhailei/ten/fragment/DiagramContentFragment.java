package com.mhailei.ten.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.mhailei.ten.R;
import com.mhailei.ten.api.ApiClient;
import com.mhailei.ten.api.ApiService;
import com.mhailei.ten.bean.DiagramBean;
import com.mhailei.ten.constants.HttpParams;
import com.mhailei.ten.constants.TranslateConfig;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mhailei on 2017/5/16.
 */

public class DiagramContentFragment extends BaseFragment {

    public static final String TAG="DiagramContentFragment";

    private DiagramBean mBean;
    private TextView title;
    private TextView author;
    private TextView content;
    private TextView from;
    private ImageView mImageView;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_diagram_content;
    }

    @Override
    protected void initView() {

        mImageView = ((ImageView) findViewById(R.id.iv_diagram));
        title = ((TextView) findViewById(R.id.tv_title));
        author = ((TextView) findViewById(R.id.tv_author));
        content = ((TextView) findViewById(R.id.tv_content));
        from = ((TextView) findViewById(R.id.tv_from));

        Bundle bundle = getArguments();
        String id = bundle.getString(TranslateConfig.ID);
        Log.e(TAG, "initView: "+id );

        ApiService apiService = ApiClient.getApiService();
        Call<DiagramBean> diagramBean = apiService.getDiagramBean(id);
        diagramBean.enqueue(new Callback<DiagramBean>() {


            @Override
            public void onResponse(Call<DiagramBean> call, Response<DiagramBean> response) {
                mBean = response.body();


                Picasso.with(getContext()).load(HttpParams.BASE_URL+"/"+mBean.getImage1()).into(mImageView);
                title.setText(mBean.getTitle());
                author.setText(mBean.getAuthorbrief());
                content.setText(mBean.getText1());
                from.setText(mBean.getText2());

            }

            @Override
            public void onFailure(Call<DiagramBean> call, Throwable t) {

            }
        });

    }

}

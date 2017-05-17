package com.mhailei.ten.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.mhailei.ten.R;
import com.mhailei.ten.api.ApiClient;
import com.mhailei.ten.api.ApiService;
import com.mhailei.ten.bean.CriticBean;
import com.mhailei.ten.constants.HttpParams;
import com.mhailei.ten.constants.TranslateConfig;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mhailei on 2017/5/17.
 */

public class CriticContentFragment extends BaseFragment {
    public static final String TAG = "CriticContentFragment";
    private ImageView imageforplay;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private TextView title;
    private TextView times;
    private TextView author;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView authorbrief;
    private TextView critic_author1;
    private CriticBean mBean;
    private TextView text5;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_critic_content;
    }

    @Override
    protected void initView() {
        imageforplay = ((ImageView) findViewById(R.id.critic_imageforplay));
        image1 = ((ImageView) findViewById(R.id.image1));
        image2 = ((ImageView) findViewById(R.id.image2));
        image3 = ((ImageView) findViewById(R.id.image3));
        image4 = ((ImageView) findViewById(R.id.image4));

        title = ((TextView) findViewById(R.id.critic_title));
        author = ((TextView) findViewById(R.id.critic_author));
        times = ((TextView) findViewById(R.id.critic_times));

        text1 = ((TextView) findViewById(R.id.text1));
        text2 = ((TextView) findViewById(R.id.text2));
        text3 = ((TextView) findViewById(R.id.text3));
        text4 = ((TextView) findViewById(R.id.text4));
        text5 = ((TextView) findViewById(R.id.text5));

        critic_author1 = ((TextView) findViewById(R.id.critic_author1));

        authorbrief = ((TextView) findViewById(R.id.authorbrief));

        Bundle bundle = getArguments();
        String id = bundle.getString(TranslateConfig.ID);

        Log.e(TAG, "initView: "+id );

        ApiService apiService = ApiClient.getApiService();
        Call<CriticBean> criticBean = apiService.getCriticBean(id);
        criticBean.enqueue(new Callback<CriticBean>() {
            @Override
            public void onResponse(Call<CriticBean> call, Response<CriticBean> response) {

                Log.e(TAG, "onResponse: ");
                mBean = response.body();

                Picasso.with(getContext()).load(HttpParams.BASE_URL+"/"+mBean.getImageforplay()).into(imageforplay);
                Picasso.with(getContext()).load(HttpParams.BASE_URL+"/"+mBean.getImage1()).into(image1);
                Picasso.with(getContext()).load(HttpParams.BASE_URL+"/"+mBean.getImage2()).into(image2);
                Picasso.with(getContext()).load(HttpParams.BASE_URL+"/"+mBean.getImage3()).into(image3);
                Picasso.with(getContext()).load(HttpParams.BASE_URL+"/"+mBean.getImage4()).into(image4);

                title.setText(mBean.getTitle());
                author.setText(mBean.getAuthor());
                //times.setText(mBean.getTimes());
                text1.setText(mBean.getText1());
                text2.setText(mBean.getText2());
                text3.setText(mBean.getText3());
                text4.setText(mBean.getText4());
                text5.setText(mBean.getText5());

                critic_author1.setText(mBean.getAuthor());
                authorbrief.setText(mBean.getAuthorbrief());
            }

            @Override
            public void onFailure(Call<CriticBean> call, Throwable t) {

            }
        });

        setupView();

    }

    private void setupView() {


    }
}

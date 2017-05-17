package com.mhailei.ten.api;

import com.mhailei.ten.bean.CriticBean;
import com.mhailei.ten.bean.CriticListBean;
import com.mhailei.ten.bean.DiagramBean;
import com.mhailei.ten.bean.DiagramListBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mhailei on 2017/5/16.
 */

public interface ApiService {

    @GET("/api/Diagram/GetDiagramList")
    Call<DiagramListBean> getDiagramList();

    @GET("/api/Diagram/GetDiagramContent")
    Call<DiagramBean> getDiagramBean(@Query("id") String id);

    @GET("/api/Critic/GetCriticList")
    Call<CriticListBean> getCriticList();

    @GET("/api/Critic/GetCriticContent")
    Call<CriticBean> getCriticBean(@Query("id") String id);

}

package com.huangyu.easyframework.http;

import com.huangyu.easyframework.bean.NewsResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by huangyu on 2017-4-11.
 */
public interface APIService {

    @GET("wxnew/")
    Observable<NewsResponse> getWeChatNews(@Query("key") String key, @Query("num") String num);

}

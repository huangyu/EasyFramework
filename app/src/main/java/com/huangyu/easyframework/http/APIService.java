package com.huangyu.easyframework.http;

import com.huangyu.easyframework.bean.Weather;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by huangyu on 2017-4-11.
 */
public interface APIService {

    @GET("{url}")
    Observable<Weather> getDailyWeather(@Path("url") String url);

}

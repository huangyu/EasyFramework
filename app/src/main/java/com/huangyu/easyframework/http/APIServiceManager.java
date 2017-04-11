package com.huangyu.easyframework.http;

import com.huangyu.easyframework.bean.Weather;
import com.huangyu.library.http.RetrofitManager;

import rx.Observable;

/**
 * Created by huangyu on 2017-4-11.
 */
public class APIServiceManager {

    protected static final APIService service = RetrofitManager.getInstance().create(APIService.class);

    private static class SingletonHolder {
        private static final APIServiceManager INSTANCE = new APIServiceManager();
    }

    public static APIServiceManager getInstance() {
        return APIServiceManager.SingletonHolder.INSTANCE;
    }

    public Observable<Weather> getDailyWeather(String url) {
        return service.getDailyWeather(url);
    }

}

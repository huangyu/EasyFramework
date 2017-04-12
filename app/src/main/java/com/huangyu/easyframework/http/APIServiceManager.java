package com.huangyu.easyframework.http;

import com.huangyu.easyframework.bean.NewsResponse;
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

    public Observable<NewsResponse> getWeChatNews(String key, int num, int page) {
        return service.getWeChatNews(key, num, page);
    }

}

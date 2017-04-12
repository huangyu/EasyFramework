package com.huangyu.easyframework.mvp.model;

import com.huangyu.easyframework.app.AppConstants;
import com.huangyu.easyframework.bean.NewsResponse;
import com.huangyu.easyframework.http.APIServiceManager;
import com.huangyu.easyframework.mvp.contract.IMainContract;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by huangyu on 2017-4-11.
 */
public class MainModel implements IMainContract.IMainModel {

    @Override
    public Observable<NewsResponse> getWeChatNews() {
        return APIServiceManager.getInstance().getWeChatNews(AppConstants.TIAN_XING_KEY, "20")
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}

package com.huangyu.easyframework.mvp.model;

import com.huangyu.easyframework.app.AppConstants;
import com.huangyu.easyframework.bean.NewsResponse;
import com.huangyu.easyframework.http.APIServiceManager;
import com.huangyu.easyframework.mvp.contract.INewsListContract;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by huangyu on 2017-4-11.
 */
public class MainModel implements INewsListContract.INewsListModel {

    @Override
    public Observable<NewsResponse> getWeChatNews(int page, int num) {
        return APIServiceManager.getInstance().getWeChatNews(AppConstants.TIAN_XING_KEY, num, page)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}

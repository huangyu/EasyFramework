package com.huangyu.easyframework.mvp.model;

import com.huangyu.easyframework.app.AppConstants;
import com.huangyu.easyframework.bean.NewsResponse;
import com.huangyu.easyframework.http.APIServiceManager;
import com.huangyu.easyframework.mvp.contract.INewsListContract;
import com.huangyu.library.rx.RxHelper;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by huangyu on 2017-4-11.
 */
public class NewsListModel implements INewsListContract.INewsListModel {

    @Override
    public Subscription getWeChatNews(int page, int num, Subscriber<NewsResponse> subscriber) {
        return APIServiceManager.getInstance().getWeChatNews(AppConstants.TIAN_XING_KEY, num, page)
                .compose(RxHelper.<NewsResponse>handleResult()).subscribe(subscriber);
    }

}

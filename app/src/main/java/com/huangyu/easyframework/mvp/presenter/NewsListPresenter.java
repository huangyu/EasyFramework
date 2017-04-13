package com.huangyu.easyframework.mvp.presenter;

import com.huangyu.easyframework.bean.NewsResponse;
import com.huangyu.easyframework.mvp.contract.INewsListContract;
import com.huangyu.easyframework.mvp.model.MainModel;
import com.huangyu.library.rx.RxManager;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by huangyu on 2017-4-11.
 */
public class NewsListPresenter extends INewsListContract.ANewsListPresenter {

    private MainModel mainModel;

    @Override
    public void create() {
        mainModel = new MainModel();
    }

    @Override
    public void getWeChetNews(final int page, int num) {
        Observable<NewsResponse> observable = mainModel.getWeChatNews(page, num);
        RxManager.getInstance().add(observable.subscribe(new Subscriber<NewsResponse>() {
            @Override
            public void onCompleted() {
                mView.loadComplete();
            }

            @Override
            public void onError(Throwable e) {
                mView.showError(e.getMessage());
            }

            @Override
            public void onNext(NewsResponse newsResponse) {
                Integer code = newsResponse.getCode();
                String msg = newsResponse.getMsg();
                if (code == 200) {
                    if (page == 1) {
                        mView.setData(newsResponse.getNewslist());
                    } else {
                        mView.addData(newsResponse.getNewslist());
                    }
                } else {
                    mView.showError(msg);
                }
            }
        }));
    }

}

package com.huangyu.easyframework.mvp.presenter;

import com.huangyu.easyframework.bean.NewsResponse;
import com.huangyu.easyframework.mvp.contract.IMainContract;
import com.huangyu.easyframework.mvp.model.MainModel;
import com.huangyu.library.rx.RxManager;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by huangyu on 2017-4-11.
 */
public class MainPresenter extends IMainContract.AMainPresenter {

    private MainModel mainModel;

    @Override
    public void create() {
        mainModel = new MainModel();

        getWeChetNews();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void getWeChetNews() {
        Observable<NewsResponse> observable = mainModel.getWeChatNews();
        RxManager.getInstance().add(observable.subscribe(new Subscriber<NewsResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(NewsResponse newsResponse) {
                Integer code = newsResponse.getCode();
                if (code == 200) {
                    mView.setData(newsResponse.getNewslist());
                } else {

                }
            }
        }));
    }

}

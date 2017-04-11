package com.huangyu.easyframework.mvp.presenter;

import com.huangyu.easyframework.bean.Weather;
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

        queryDailyWeather();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void queryDailyWeather() {
        Observable<Weather> observable = mainModel.queryDailyWeather();
        RxManager.getInstance().add(observable.subscribe(new Subscriber<Weather>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Weather weather) {
                mView.setText("123");
            }
        }));
    }

}

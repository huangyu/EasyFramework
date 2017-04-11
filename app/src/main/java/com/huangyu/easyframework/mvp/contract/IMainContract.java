package com.huangyu.easyframework.mvp.contract;

import com.huangyu.easyframework.bean.Weather;
import com.huangyu.library.mvp.BasePresenter;
import com.huangyu.library.mvp.IBaseModel;
import com.huangyu.library.mvp.IBaseView;

import rx.Observable;

/**
 * Created by huangyu on 2017-4-11.
 */
public interface IMainContract {

    interface IMainModel extends IBaseModel {
        Observable<Weather> queryDailyWeather();
    }

    interface IMainView extends IBaseView {
        void setText(String text);
    }

    abstract class AMainPresenter extends BasePresenter<IMainView> {
        protected abstract void queryDailyWeather();
    }

}

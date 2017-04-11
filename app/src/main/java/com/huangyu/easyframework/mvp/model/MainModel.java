package com.huangyu.easyframework.mvp.model;

import com.huangyu.easyframework.bean.Weather;
import com.huangyu.easyframework.http.APIServiceManager;
import com.huangyu.easyframework.mvp.contract.IMainContract;
import com.huangyu.easyframework.util.SeniverseUtils;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by huangyu on 2017-4-11.
 */
public class MainModel implements IMainContract.IMainModel {

    @Override
    public Observable<Weather> queryDailyWeather() {
        String url = null;
        try {
            url = SeniverseUtils.generateGetDiaryWeatherURL("guangzhou", "zh-Hans", "c", "1", "1");
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return APIServiceManager.getInstance().getDailyWeather(url)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}

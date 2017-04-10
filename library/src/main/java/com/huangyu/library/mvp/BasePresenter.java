package com.huangyu.library.mvp;

import android.content.Context;

/**
 * MVP Presenter 基类
 * Created by huangyu on 2017-4-10.
 */
public abstract class BasePresenter<V extends IBaseView> {

    protected Context mContext;
    protected V mView;

    public void attachView(V view) {
        this.mView = view;
    }

    public abstract void create();

    public abstract void destroy();

}

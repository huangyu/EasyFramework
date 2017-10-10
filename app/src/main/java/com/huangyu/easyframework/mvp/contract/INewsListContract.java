package com.huangyu.easyframework.mvp.contract;

import com.huangyu.easyframework.bean.News;
import com.huangyu.easyframework.bean.NewsResponse;
import com.huangyu.library.mvp.BasePresenter;
import com.huangyu.library.mvp.IBaseModel;
import com.huangyu.library.mvp.IBaseView;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by huangyu on 2017-4-11.
 */
public interface INewsListContract {

    interface INewsListView extends IBaseView {
        void setData(List<News> data);
        void addData(List<News> data);
        void loadComplete();
        void showError(String msg);
        void setLoadError();
    }

    interface INewsListModel extends IBaseModel {
        Subscription getWeChatNews(int page, int num, Subscriber<NewsResponse> subscriber);
    }

    abstract class ANewsListPresenter extends BasePresenter<INewsListView> {
        public abstract void getWeChetNews(int page, int num);
    }

}

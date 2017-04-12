package com.huangyu.easyframework.mvp.contract;

import com.huangyu.easyframework.bean.News;
import com.huangyu.easyframework.bean.NewsResponse;
import com.huangyu.library.mvp.BasePresenter;
import com.huangyu.library.mvp.IBaseModel;
import com.huangyu.library.mvp.IBaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by huangyu on 2017-4-11.
 */
public interface IMainContract {

    interface IMainModel extends IBaseModel {
        Observable<NewsResponse> getWeChatNews(int page, int num);
    }

    interface IMainView extends IBaseView {
        void setData(List<News> data);
        void addData(List<News> data);
    }

    abstract class AMainPresenter extends BasePresenter<IMainView> {
        public abstract void getWeChetNews(int page, int num);
    }

}

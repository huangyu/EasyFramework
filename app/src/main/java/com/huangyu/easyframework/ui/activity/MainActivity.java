package com.huangyu.easyframework.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.huangyu.easyframework.R;
import com.huangyu.easyframework.bean.News;
import com.huangyu.easyframework.mvp.contract.IMainContract;
import com.huangyu.easyframework.mvp.presenter.MainPresenter;
import com.huangyu.easyframework.ui.adapter.NewsListAdapter;
import com.huangyu.library.ui.BaseActivity;

import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity<IMainContract.IMainView, MainPresenter> implements IMainContract.IMainView {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    private NewsListAdapter newsListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected IMainContract.IMainView initAttachView() {
        return this;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        newsListAdapter = new NewsListAdapter();
        recyclerView.setAdapter(newsListAdapter);
    }

    @Override
    public void setData(List<News> data) {
        newsListAdapter.setData(data);
        newsListAdapter.notifyDataSetChanged();
    }

}

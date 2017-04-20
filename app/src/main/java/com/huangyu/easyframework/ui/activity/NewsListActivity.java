package com.huangyu.easyframework.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.huangyu.easyframework.R;
import com.huangyu.easyframework.bean.News;
import com.huangyu.easyframework.mvp.contract.INewsListContract;
import com.huangyu.easyframework.mvp.presenter.NewsListPresenter;
import com.huangyu.easyframework.ui.adapter.NewsListAdapter;
import com.huangyu.easyframework.ui.widget.refreshandload.CommonRecyclerAdapter;
import com.huangyu.easyframework.ui.widget.refreshandload.RefreshAndLoadListener;
import com.huangyu.easyframework.ui.widget.refreshandload.RefreshAndLoadView;
import com.huangyu.library.ui.BaseActivity;
import com.huangyu.library.util.NetworkUtils;

import java.util.List;

import butterknife.Bind;

public class NewsListActivity extends BaseActivity<INewsListContract.INewsListView, NewsListPresenter> implements INewsListContract.INewsListView {

    @Bind(R.id.refresh_and_load_view)
    RefreshAndLoadView mRefreshAndLoadView;

    private NewsListAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_newslist;
    }

    @Override
    protected INewsListContract.INewsListView initAttachView() {
        return this;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mAdapter = new NewsListAdapter(this, new NewsListAdapter.IReload() {
            @Override
            public void reload() {
                load();
            }
        });
        mAdapter.setOnItemClick(new CommonRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                loadComplete();
                String url = mAdapter.getItem(position).getUrl();
                Intent intent = new Intent(NewsListActivity.this, NewsDetailActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
        mRefreshAndLoadView.setLayoutManager(new LinearLayoutManager(NewsListActivity.this)).setAdapter(mAdapter).setRefreshAndLoadListener(new RefreshAndLoadListener() {
            @Override
            public void onRefresh() {
                refresh();
            }

            @Override
            public void onLoad() {
                load();
            }
        }).startRefresh();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void setData(List<News> data) {
        mAdapter.clearData();
        mAdapter.addAllData(data);
    }

    @Override
    public void addData(List<News> data) {
        mAdapter.addAllData(data);
    }

    @Override
    public void loadComplete() {
        mRefreshAndLoadView.setComplete();
    }

    @Override
    public void showError(String msg) {
        setLoadError();
        Toast.makeText(NewsListActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setLoadError() {
        mAdapter.setLoadError(true);
        mAdapter.notifyItemChanged(mAdapter.getItemCount() - 1);
    }

    private void refresh() {
        mAdapter.getPage().setPage(1);
        mPresenter.getWeChetNews(mAdapter.getPage().getPage(), mAdapter.getPage().getNum());
    }

    private void load() {
        if (!NetworkUtils.isConnected()) {
            showError("网络出错，请检查手机网络");
            return;
        }

        int page = mAdapter.getPage().getPage();
        mAdapter.getPage().setPage(++page);
        mPresenter.getWeChetNews(mAdapter.getPage().getPage(), mAdapter.getPage().getNum());
    }

}

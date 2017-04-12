package com.huangyu.easyframework.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.huangyu.easyframework.R;
import com.huangyu.easyframework.bean.News;
import com.huangyu.easyframework.mvp.contract.IMainContract;
import com.huangyu.easyframework.mvp.presenter.MainPresenter;
import com.huangyu.easyframework.ui.adapter.NewsListAdapter;
import com.huangyu.easyframework.ui.widget.refreshandload.CommonRecyclerAdapter;
import com.huangyu.easyframework.ui.widget.refreshandload.RefreshAndLoadView;
import com.huangyu.library.ui.BaseActivity;

import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity<IMainContract.IMainView, MainPresenter> implements IMainContract.IMainView {

    @Bind(R.id.refresh_and_load_view)
    RefreshAndLoadView refreshAndLoadView;

    private NewsListAdapter adapter;

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
        adapter = new NewsListAdapter(this);
        adapter.setOnItemClick(new CommonRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "click item " + position, Toast.LENGTH_SHORT).show();
            }
        });
//        refreshAndLoadView.setLayoutManager(new LinearLayoutManager(MainActivity.this)).setAdapter(adapter).setRefreshAndLoadListener(new RefreshAndLoadListener() {
//            @Override
//            public void onRefresh() {
//                refresh();
//            }
//
//            @Override
//            public void onLoad() {
//                load();
//            }
//        }).startRefresh();
    }

    @Override
    public void setData(List<News> data) {
        adapter.setData(data);
    }

//    private void loadData(final boolean isRefresh) {
//        refreshAndLoadView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (adapter != null) {
//                    if (isRefresh) {
//                        adapter.clearData();
//                    }
//                    addData(mGroupSize, mGroupCount);
//                }
//                refreshAndLoadView.setComplete();
//            }
//        }, 2000);
//    }
//
//    private void addData(int groupSize, int groupCount) {
//        int start = groupSize * (groupCount - 1);
//        for (int i = start; i < groupSize * groupCount; i++) {
//            adapter.addItem("item" + i);
//        }
//    }
//
//    private void refresh() {
//        mGroupCount = 1;
//        loadData(true);
//    }
//
//    private void load() {
//        mGroupCount++;
//        loadData(false);
//    }

}

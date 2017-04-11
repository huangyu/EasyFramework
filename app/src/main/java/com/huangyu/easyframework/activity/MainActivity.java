package com.huangyu.easyframework.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.huangyu.easyframework.R;
import com.huangyu.easyframework.mvp.contract.IMainContract;
import com.huangyu.easyframework.mvp.presenter.MainPresenter;
import com.huangyu.library.ui.BaseActivity;

import butterknife.Bind;

public class MainActivity extends BaseActivity<IMainContract.IMainView, MainPresenter> implements IMainContract.IMainView {

    @Bind(R.id.tv_result)
    TextView tvResult;

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

    }

    @Override
    public void setText(String text) {
        tvResult.setText(text);
    }

}

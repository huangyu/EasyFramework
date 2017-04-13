package com.huangyu.easyframework.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.huangyu.easyframework.R;
import com.huangyu.easyframework.ui.widget.webview.AdvancedWebView;
import com.huangyu.library.mvp.IBaseView;
import com.huangyu.library.ui.BaseActivity;

import butterknife.Bind;

public class NewsDetailActivity extends BaseActivity {

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.advanced_webview)
    AdvancedWebView mAdvancedWebView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_newsdetail;
    }

    @Override
    protected IBaseView initAttachView() {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        final String url = getIntent().getStringExtra("url");
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mAdvancedWebView.loadUrl(url);
            }
        });
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mAdvancedWebView.setListener(this, new AdvancedWebView.Listener() {
            @Override
            public void onPageStarted(String url, Bitmap favicon) {
                mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override
            public void onPageFinished(String url) {
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onPageError(int errorCode, String description, String failingUrl) {

            }

            @Override
            public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {

            }

            @Override
            public void onExternalPageRequest(String url) {

            }
        });
        mAdvancedWebView.loadUrl(url);
    }

}

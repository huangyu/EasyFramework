package com.huangyu.easyframework.ui.widget.webview;

import android.content.Context;
import android.content.Intent;

import com.huangyu.easyframework.ui.activity.BrowserImageActivity;

/**
 * Created by huangyu on 2017-4-14.
 */
public class SetImageSrcClick {

    private Context mContext;

    public SetImageSrcClick(Context context) {
        this.mContext = context;
    }

    /**
     * 点击图片启动新的 ShowImageFromWebActivity，并传入点击图片对应的 url
     * 和页面所有图片对应的 url
     *
     * @param url 点击图片对应的 url
     */
    @android.webkit.JavascriptInterface
    public void openImage(String url) {
        Intent intent = new Intent();
        intent.putExtra("url", url);
        intent.setClass(mContext, BrowserImageActivity.class);
        mContext.startActivity(intent);
    }

}
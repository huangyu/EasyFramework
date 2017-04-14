package com.huangyu.easyframework.ui.activity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.huangyu.easyframework.R;
import com.huangyu.library.mvp.IBaseView;
import com.huangyu.library.ui.BaseActivity;

import butterknife.Bind;

/**
 * Created by huangyu on 2017-4-14.
 */
public class BrowserImageActivity extends BaseActivity {

    @Bind(R.id.photo_view)
    PhotoView photoView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_browserimage;
    }

    @Override
    protected IBaseView initAttachView() {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        String url = getIntent().getStringExtra("url");
        Glide.with(this).load(url).into(photoView);
    }

}

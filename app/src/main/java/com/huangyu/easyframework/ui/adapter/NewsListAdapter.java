package com.huangyu.easyframework.ui.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.huangyu.easyframework.R;
import com.huangyu.easyframework.bean.News;
import com.huangyu.library.ui.CommonRecyclerViewAdapter;
import com.huangyu.library.ui.CommonRecyclerViewHolder;

/**
 * Created by huangyu on 2017-4-12.
 */
public class NewsListAdapter extends CommonRecyclerViewAdapter<News> {

    @Override
    public void convert(CommonRecyclerViewHolder holder, News data, int position) {
        ImageView ivPic = holder.getView(R.id.iv_pic);
        TextView tvTitle = holder.getView(R.id.tv_title);
        TextView tvDescription = holder.getView(R.id.tv_description);


    }

    @Override
    public int getLayoutResource() {
        return R.layout.list_item_news;
    }

}

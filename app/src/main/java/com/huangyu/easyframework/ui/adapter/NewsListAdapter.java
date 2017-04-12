package com.huangyu.easyframework.ui.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huangyu.easyframework.R;
import com.huangyu.easyframework.bean.News;
import com.huangyu.easyframework.bean.Page;
import com.huangyu.easyframework.ui.widget.refreshandload.CommonRecyclerAdapter;
import com.huangyu.easyframework.ui.widget.refreshandload.CommonRecyclerViewHolder;

/**
 * Created by huangyu on 2017-4-12.
 */
public class NewsListAdapter extends CommonRecyclerAdapter<News> {

    private Page mPage;

    public Page getPage() {
        return this.mPage;
    }

    public void setPage(Page page) {
        this.mPage = page;
    }

    public NewsListAdapter(Context context) {
        super(context);
        mPage = new Page();
    }

    @Override
    public void convert(CommonRecyclerViewHolder holder, News data, int position) {
        int itemType = getItemViewType(position);
        if (itemType == TYPE_HEADER || itemType == TYPE_NORMAL) {
            ImageView ivPic = holder.getView(R.id.iv_pic);
            TextView tvTitle = holder.getView(R.id.tv_title);
            TextView tvDescription = holder.getView(R.id.tv_description);

            Glide.with(mContext).load(data.getPicUrl()).into(ivPic);
            tvTitle.setText(data.getTitle());
            tvDescription.setText(data.getDescription());
        }
    }

    @Override
    public int getLayoutResource() {
        return R.layout.list_item_news;
    }

    @Override
    public int getHeadLayoutResource() {
        return R.layout.list_item_news;
    }

    @Override
    public int getFootLayoutResource() {
        return R.layout.list_item_foot;
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size() + 1;
    }

}

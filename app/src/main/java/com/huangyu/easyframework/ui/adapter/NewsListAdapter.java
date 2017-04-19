package com.huangyu.easyframework.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huangyu.easyframework.R;
import com.huangyu.easyframework.bean.News;
import com.huangyu.easyframework.bean.PageBean;
import com.huangyu.easyframework.ui.widget.refreshandload.CommonRecyclerAdapter;
import com.huangyu.easyframework.ui.widget.refreshandload.CommonRecyclerViewHolder;

/**
 * Created by huangyu on 2017-4-12.
 */
public class NewsListAdapter extends CommonRecyclerAdapter<News> {

    private PageBean mPage;

    public PageBean getPage() {
        return this.mPage;
    }

    public void setPage(PageBean page) {
        this.mPage = page;
    }

    public NewsListAdapter(Context context) {
        super(context);
        mPage = new PageBean();
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
        } else {
            ProgressBar pbLoading = holder.getView(R.id.progress_bar);
            TextView tvTips = holder.getView(R.id.tv_tips);
//            tvTips.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
            if (isLoadError) {
                pbLoading.setVisibility(View.GONE);
                tvTips.setVisibility(View.VISIBLE);
            } else {
                pbLoading.setVisibility(View.VISIBLE);
                tvTips.setVisibility(View.GONE);
            }
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

}

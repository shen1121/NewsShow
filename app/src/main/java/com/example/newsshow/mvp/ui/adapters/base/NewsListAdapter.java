package com.example.newsshow.mvp.ui.adapters.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


import com.example.newsshow.R;
import com.example.newsshow.mvp.model.apis.entity.netease.NewsSummary;
import com.example.newsshow.utils.DeminUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/11/20.
 */

public class NewsListAdapter extends BaseRecyclerViewAdapter<NewsSummary> {

    public  static  final  int TYEP_PHOTO_SET = 2;

    private final float photoThreeHeigth;
    private final float photoTwoHeigth;
    private final float photoOneHeigth;
    private PhotoSetViewHolder itemOnClikEvent;

    public NewsListAdapter(List<NewsSummary> list) {
        super(list);
        photoThreeHeigth = DeminUtils.dp2px(90);
        photoTwoHeigth = DeminUtils.dp2px(120);
        photoOneHeigth = DeminUtils.dp2px(150);
    }

    @Override
    public int getItemViewType(int position) {
        if (mIsitemFooter && isFooterPosition(position)) {
            return TYPE_FOOTER;
        }else if ("photoset".equals(mList.get(position).getSkipType())){
            return  TYEP_PHOTO_SET;
        }else {
            return  TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_FOOTER:
                return new FooterViewHolder(getView(parent, R.layout.adapter_footer_item));

            case TYEP_PHOTO_SET:
                PhotoSetViewHolder photoSetViewHolder = new PhotoSetViewHolder(getView(parent, R.layout.adapter_footer_item));
                setItemOnClikEvent(photoSetViewHolder);
                return  photoSetViewHolder;

            case TYPE_ITEM:
            default:
                NormalViewHolder normalViewHolder=new NormalViewHolder(getView(parent,R.layout.adapter_footer_item));
                setItemOnClikEvent(normalViewHolder);
                return normalViewHolder;

        }
//        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    public void setItemOnClikEvent(RecyclerView.ViewHolder holder) {




    }


    public class NormalViewHolder extends RecyclerView.ViewHolder{

        public NormalViewHolder(View itemView) {
            super(itemView);
        }
    }


    public  class  PhotoSetViewHolder extends  RecyclerView.ViewHolder{

        public PhotoSetViewHolder(View itemView) {
            super(itemView);
        }
    }

}

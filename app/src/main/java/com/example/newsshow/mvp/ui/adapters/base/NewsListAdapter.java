package com.example.newsshow.mvp.ui.adapters.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.newsshow.MyApplication;
import com.example.newsshow.R;
import com.example.newsshow.mvp.model.apis.entity.netease.NewsSummary;
import com.example.newsshow.mvp.ui.adapters.base.listener.MyRecyclerListener;
import com.example.newsshow.utils.DeminUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/11/20.
 */

public class NewsListAdapter extends BaseRecyclerViewAdapter<NewsSummary> {

    public static final int TYPE_PHOTO_SET = 2;

    private final float photoThreeHeigth;
    private final float photoTwoHeigth;
    private final float photoOneHeigth;
    private PhotoSetViewHolder itemOnClikEvent;
    private MyRecyclerListener mOnItemClickListener;
    private float photoHeigth;

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
        } else if ("photoset".equals(mList.get(position).getSkipType())) {
            return TYPE_PHOTO_SET;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_FOOTER:
                return new FooterViewHolder(getView(parent, R.layout.adapter_footer_item));
            case TYPE_PHOTO_SET:
                PhotoSetViewHolder photoSetViewHolder = new PhotoSetViewHolder(getView(parent, R.layout.adapter_new_3_img_item));
                setItemOnClikEvent(photoSetViewHolder);
                return photoSetViewHolder;

            case TYPE_ITEM:
            default:
                NormalViewHolder normalViewHolder = new NormalViewHolder(getView(parent, R.layout.adapter_new_1_img_item));
                setItemOnClikEvent(normalViewHolder);
                return normalViewHolder;

        }
//        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        super.onBindViewHolder(holder, position);
        int itemViewType = getItemViewType(position);
        if (itemViewType == TYPE_PHOTO_SET) {
            updataPhotoSetView((PhotoSetViewHolder) holder, position);
        } else if (itemViewType == TYPE_ITEM) {
            updataNormalView((NormalViewHolder) holder, position);
        }
    }

    private void updataPhotoSetView(PhotoSetViewHolder holder, int position) {
        NewsSummary data = mList.get(position);
        holder.newsSourceTv.setText(data.getSource());
        holder.newsTimeTv.setText(data.getPtime());
        holder.newsTitleTv.setText(data.getTitle());
        ViewGroup.LayoutParams layoutParams = holder.imageGroup.getLayoutParams();
        String imagePath1 = data.getImgsrc();
        String imagePath2 = null;
        String imagePath3 = null;
        photoHeigth = photoOneHeigth;
        if (data.getImgsrc() != null) {
            int size = data.getImgextra().size();
            if (size >= 2) {
                imagePath2 = data.getImgextra().get(0).getImgsrc();
                imagePath3 = data.getImgextra().get(1).getImgsrc();
                photoHeigth = photoThreeHeigth;

            } else {
                imagePath2 = data.getImgextra().get(0).getImgsrc();
                photoHeigth = photoTwoHeigth;
            }
        }

        layoutParams.height = (int) photoHeigth;
        holder.imageGroup.setLayoutParams(layoutParams);
        showAndPhotoSet(holder, imagePath1, imagePath2, imagePath3);

    }

    private void showAndPhotoSet(PhotoSetViewHolder holder, String imagePath1, String imagePath2, String imagePath3) {
        if (imagePath1 != null) {
            loadImage(holder.newsImg1, imagePath1);
        } else {
            holder.newsImg1.setVisibility(View.GONE);
        }

        if (imagePath2 != null) {
            loadImage(holder.newsImg2, imagePath2);
        } else {
            holder.newsImg2.setVisibility(View.GONE);
        }

        if (imagePath3 != null) {
            loadImage(holder.newsImg3, imagePath3);
        } else {
            holder.newsImg3.setVisibility(View.GONE);
        }

    }

    private void loadImage(ImageView view, String path) {

        view.setVisibility(View.VISIBLE);
        Glide.with(MyApplication.getInstance())
                .load(path)
                .placeholder(R.color.image_place_holder)
                .error(R.mipmap.ic_load_fail)
                .into(view);

    }


    private void updataNormalView(NormalViewHolder holder, int position) {
        NewsSummary data = mList.get(position);
        String imgsrcPath = data.getImgsrc();
        Glide.with(MyApplication.getInstance())
                .load(imgsrcPath)
                .placeholder(R.color.image_place_holder)
                .error(R.mipmap.ic_load_fail)
                .into(holder.newsPicture);


        holder.newsSourceTv.setText(data.getSource());
        holder.newsTime.setText(data.getPtime());
        holder.newsTitle.setText(data.getTitle());

    }


    public void setItemOnClikEvent(final RecyclerView.ViewHolder holder) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.OnItemClikListener(view, holder.getAdapterPosition());
                }
            });
        }


    }


    public class NormalViewHolder extends RecyclerView.ViewHolder {

        private final TextView newsTitle;
        private final TextView newsTime;
        private final ImageView newsPicture;
        private final TextView newsSourceTv;


        public NormalViewHolder(View itemView) {
            super(itemView);

            newsTitle = itemView.findViewById(R.id.new_title_tv);
            newsTime = itemView.findViewById(R.id.new_time_tv);
            newsPicture = itemView.findViewById(R.id.new_picture_iv);
            newsSourceTv = itemView.findViewById(R.id.new_source_tv);

        }
    }


    public class PhotoSetViewHolder extends RecyclerView.ViewHolder {


        private final ImageView newsImg1;
        private final ImageView newsImg2;
        private final ImageView newsImg3;
        private final LinearLayout imageGroup;
        private final TextView newsSourceTv;
        private final TextView newsTimeTv;
        private final TextView newsTitleTv;

        public PhotoSetViewHolder(View itemView) {
            super(itemView);
            newsImg1 = itemView.findViewById(R.id.new_picture_1_iv);
            newsImg2 = itemView.findViewById(R.id.new_picture_2_iv);
            newsImg3 = itemView.findViewById(R.id.new_picture_3_iv);
            imageGroup = itemView.findViewById(R.id.news_group_img);
            newsSourceTv = itemView.findViewById(R.id.new_source_tv);
            newsTimeTv = itemView.findViewById(R.id.new_time_tv);
            newsTitleTv = itemView.findViewById(R.id.new_title_tv);
        }
    }

}

package com.example.newsshow.mvp.ui.adapters.base;

import android.content.Context;
import android.net.wifi.aware.PublishConfig;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsshow.mvp.ui.adapters.base.listener.MyRecyclerListener;

import java.util.List;

/**
 * Created by Administrator on 2017/11/17.
 */

public class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public  static  final  int TYPE_ITEM=0;
    public static final int TYPE_FOOTER = 1;
    public boolean mIsitemFooter;

    protected List<T> mList;

    private MyRecyclerListener onItemClikListener;

    public BaseRecyclerViewAdapter(List<T> list) {
        this.mList = list;
    }

    public void setList(List<T> list) {
        mList = list;
    }

    public List<T> getList() {
        return mList;
    }

    //添加更多
    public void addMore(List<T> list) {
        int startPosition = mList.size();
        mList.addAll(list);
        notifyItemRangeChanged(startPosition, mList.size());
    }

    //添加数据
    public void add(int position, T time) {
        mList.add(position, time);
        notifyItemInserted(position);
    }

    //移除数据
    public void remove(int position, T time) {
        mList.remove(position);
        notifyItemRemoved(position);
    }


    public void setOnItemClikListner(MyRecyclerListener myRecyclerListener) {
        onItemClikListener = myRecyclerListener;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_FOOTER) {
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                    StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();

                    params.setFullSpan(true);
                }
            }
        }

    }

    @Override
    public int getItemCount() {

        if (mList == null)
            return 0;
        int itemSize = mList.size();
        if (mIsitemFooter) {
            itemSize += 1;
        }
        return itemSize;

    }

    /**
     * 是否显示footer
     *
     * @param position
     * @return
     */
    public boolean isFooterPosition(int position) {
        return (getItemCount() - 1) == position;
    }

    public View getView(ViewGroup parent, int layoutId) {
        return LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
    }

    /*
     显示footer
     */
    public void showFooter() {
        mIsitemFooter = true;
        notifyItemInserted(getItemCount());
    }

    /**
     * 影藏footer
     */
    public void hideFooter() {
        mIsitemFooter = true;
        notifyItemRemoved(getItemCount());
    }

    protected class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }


}

package com.project.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.project.R;
import com.project.mvp.model.ShowApiGifModel;

import java.util.List;

/**
 * Created by 于德海 on 2018/3/22.
 * package com.project.ui.adapter
 * email : yudehai0204@163.com
 *
 * @describe
 */

public class ShowApiGifAdapter extends RecyclerView.Adapter<ShowApiGifAdapter.ViewHolder> {
    private List<ShowApiGifModel.Bean.Body.Content> mList;
    private Context mContext;
    private RequestOptions mGlideOption;

    public ShowApiGifAdapter(Context mContext) {
        this.mContext = mContext;
        mGlideOption = new RequestOptions();
        mGlideOption.placeholder(R.mipmap.default_img);
        mGlideOption.diskCacheStrategy(DiskCacheStrategy.DATA);
    }

    public void setList(List<ShowApiGifModel.Bean.Body.Content> list) {
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_frag_item_gif,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).asGif().load(mList.get(position).getImg()).apply(mGlideOption).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImage;
        CardView mCardView;
        public ViewHolder(View itemView) {
            super(itemView);
            mImage= itemView.findViewById(R.id.mImage);
            mCardView= itemView.findViewById(R.id.mCardView);
        }
    }
}

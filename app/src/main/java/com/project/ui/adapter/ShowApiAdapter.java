package com.project.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.R;
import com.project.mvp.model.ShowApiModel;

import java.util.List;

/**
 * Created by 于德海 on 2018/3/22.
 * package com.project.ui.adapter
 * email : yudehai0204@163.com
 *
 * @describe
 */

public class ShowApiAdapter extends RecyclerView.Adapter<ShowApiAdapter.ViewHolder> {
    private List<ShowApiModel.Bean.Body.Content> mList;
    private Context mContext;
    private int [] colors= new int[]{Color.parseColor("#DA70D6"),Color.parseColor("#4B0082"),
            Color.parseColor("#483D8B"),Color.parseColor("#191970"),
            Color.parseColor("#90EE90"),Color.parseColor("#FAFAD2"),
            Color.parseColor("#FFF8DC"),Color.parseColor("#FFEFD5"),
            Color.parseColor("#FFFAFA"),Color.parseColor("#B22222")};

    public ShowApiAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setList(List<ShowApiModel.Bean.Body.Content> list) {
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_item_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int card_color_index = colors[(int) (Math.random()*10)];
        int tv_title_color_index =colors[(int) (Math.random()*10)];
        int tv_content_color_index =colors[(int) (Math.random()*10)];
        if(tv_title_color_index==card_color_index){
            tv_title_color_index = card_color_index==9?card_color_index-1:card_color_index+1;
        }
        if(tv_content_color_index==card_color_index){
            tv_content_color_index = card_color_index==9?card_color_index-1:card_color_index+1;
        }
        holder.mCardView.setCardBackgroundColor(card_color_index);
        holder.tv_title.setTextColor(tv_title_color_index);
        holder.tv_content.setTextColor(tv_content_color_index);
        holder.tv_title.setText(mList.get(position).getTitle());
        holder.tv_content.setText(mList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title,tv_content;
        CardView mCardView;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_title= itemView.findViewById(R.id.tv_title);
            tv_content= itemView.findViewById(R.id.tv_content);
            mCardView= itemView.findViewById(R.id.mCardView);
        }
    }
}

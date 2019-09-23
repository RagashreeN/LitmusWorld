package com.litmus.interview.common.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.litmus.interview.R;
import com.litmus.interview.common.model.PagesItem;
import com.litmus.interview.feature.home.HomeView;
import java.util.List;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder>{
    private List<PagesItem> listdata;
    private Context context;
    private HomeView homeView;
    public SearchListAdapter(List<PagesItem> listdata, Context context, HomeView homeView) {
        this.listdata = listdata;
        this.context = context;
        this.homeView = homeView;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final PagesItem myListData = listdata.get(position);
        holder.textView.setText(myListData.getTitle());
        if(myListData!=null && myListData.getTerms()!=null
                && myListData.getTerms().getDescription()!=null
                && myListData.getTerms().getDescription().size()>0){
            holder.tvDescription.setText(myListData.getTerms().getDescription().get(0));
        }
        if(myListData.getThumbnail()!=null && myListData.getThumbnail().getSource()!=null) {
            Glide.with(context)
                    .load(myListData.getThumbnail().getSource())
                    .apply(new RequestOptions().fitCenter().placeholder(
                            ContextCompat.getDrawable(context, R.drawable.place_holder)
                    ).dontAnimate())
                    .into(holder.imageView);
        }
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeView.getClickedPosition(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView,tvDescription;
        public LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.tvList);
            this.tvDescription = (TextView) itemView.findViewById(R.id.tvListDescription);
            this.linearLayout = (LinearLayout) itemView.findViewById(R.id.ll_listItem);
        }
    }
}
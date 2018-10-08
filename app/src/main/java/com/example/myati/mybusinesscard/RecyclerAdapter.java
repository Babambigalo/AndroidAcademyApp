package com.example.myati.mybusinesscard;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private final List<NewsItem> items;
    private final Context context;
    private final LayoutInflater inflater;
    private static final String KEY_TITLE = "TITLE_KEY";
    private static final String KEY_TEXT = "TEXT_KEY";
    private static final String KEY_DATE = "DATE_KEY";
    private static final String KEY_IMGURL = "IMGURL_KEY";
    private static final String KEY_CATEGORY = "CATEGORY_KEY";
    private final int TYPE_ITEM1 = 0;
    private final int TYPE_ITEM2 = 1;


    public RecyclerAdapter(Context context, List<NewsItem> items) {

        this.items = items;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView category;
        public final TextView title;
        public final TextView text;
        public final TextView date;
        public final ImageView image;
        Intent intent = new Intent(context, NewsDetailsActivity.class);


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            category = itemView.findViewById(R.id.item_category);
            title = itemView.findViewById(R.id.item_title);
            text = itemView.findViewById(R.id.item_preview_text);
            date = itemView.findViewById(R.id.item_publish_date);
            image = itemView.findViewById(R.id.item_image);


        }


        public void bind(NewsItem item) {
            category.setText(item.getCategory().getName());
            title.setText(item.getTitle());
            text.setText(item.getFullText());
            date.setText(item.getPublishDate().toString());
            Glide.with(context).load(item.getImageUrl()).into(image);


        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                intent.putExtra(KEY_TITLE, items.get(position).getTitle());
                intent.putExtra(KEY_DATE, items.get(position).getPublishDate().toString());
                intent.putExtra(KEY_TEXT, items.get(position).getFullText());
                intent.putExtra(KEY_IMGURL, items.get(position).getImageUrl());
                intent.putExtra(KEY_CATEGORY, items.get(position).getCategory().getName());
                context.startActivity(intent);


            }

        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_ITEM1:
                return new ViewHolder(inflater.inflate(R.layout.news_item,parent,false));
            case TYPE_ITEM2:
                return new ViewHolder(inflater.inflate(R.layout.news_item_2,parent,false));


        }
        return new ViewHolder(
                inflater.inflate(R.layout.news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position).getCategory().getId() == 1 || items.get(position).getCategory().getId() == 2) {
            return TYPE_ITEM1;

        } else {
            return TYPE_ITEM2;
        }
    }

}

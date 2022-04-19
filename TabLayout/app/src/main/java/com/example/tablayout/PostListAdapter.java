package com.example.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Dictionary;
import java.util.LinkedList;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostViewHolder> {
    private LinkedList<Bundle> mPostList;
    private final LayoutInflater mInflater;

    class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final LinearLayout postItemView;
        public TextView mTitle;
        public TextView mContent;
        final PostListAdapter mAdapter;

        public PostViewHolder(View itemView, PostListAdapter adapter) {
            super(itemView);
            postItemView = itemView.findViewById(R.id.post);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            // TODO maybe
        }
    }

    public PostListAdapter(Context context, LinkedList<Bundle> postList) {
        mInflater = LayoutInflater.from(context);
        this.mPostList = postList;
    }

    @Override
    public PostListAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(
                R.layout.postlist_item, parent, false);
        PostViewHolder holder = new PostViewHolder(mItemView, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(PostListAdapter.PostViewHolder holder, int position) {
        Bundle mCurrent = mPostList.get(position);
        // Add the data to the view holder.
        //holder.postItemView.setText(mCurrent);
        holder.mTitle = holder.postItemView.findViewById(R.id.item_title);
        holder.mContent = holder.postItemView.findViewById(R.id.item_content);
        holder.mTitle.setText(mCurrent.getString("title"));
        holder.mContent.setText(mCurrent.getString("content"));
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }
}

package com.example.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Dictionary;
import java.util.LinkedList;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostViewHolder> {
    private LinkedList<String> mPostList;
    private final LayoutInflater mInflater;

    class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView postItemView;
        final PostListAdapter mAdapter;

        public PostViewHolder(View itemView, PostListAdapter adapter) {
            super(itemView);
            postItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            // TODO maybe
        }
    }

    public PostListAdapter(Context context, LinkedList<String> postList) {
        mInflater = LayoutInflater.from(context);
        this.mPostList = postList;
    }

    @Override
    public PostListAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(
                R.layout.postlist_item, parent, false);
        return new PostViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(PostListAdapter.PostViewHolder holder, int position) {
        String mCurrent = mPostList.get(position);
        // Add the data to the view holder.
        holder.postItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }
}

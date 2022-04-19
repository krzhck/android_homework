package com.example.tablayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BrowseAllFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrowseAllFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //private LinkedList<String> mPostList = new LinkedList<>();
    private LinkedList<Bundle> mPostList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private PostListAdapter mAdapter;

    public BrowseAllFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BrowseAllFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BrowseAllFragment newInstance(String param1, String param2) {
        BrowseAllFragment fragment = new BrowseAllFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        for (int i = 0; i < 10; i++) {
            Bundle post = new Bundle();
            post.putString("title", "this is a title");
            post.putString("content", "This is the content.");
            mPostList.addFirst(post);
        }
        /*
        getParentFragmentManager().setFragmentResultListener("add_post_key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Log.d("tag", "add post");
                mPostList.addFirst(result);
            }
        });*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_browse_all, container, false);
        mRecyclerView = rootView.findViewById(R.id.all_recycler);

        mAdapter = new PostListAdapter(this.getContext(), mPostList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        /*
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScroll(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!recyclerView.canScrollVertically(1)) {
                    if (mPage)
                }
            }
        });*/

        getParentFragmentManager().setFragmentResultListener("add_post_key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Log.d("tag", "add post");
                mPostList.addFirst(result);
                //mRecyclerView.scrollToPosition(0);
            }
        });
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("tag", "browseall onSaveInstanceState");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("tag", "browseall onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("tag", "browseall onResume");
    }
}
package com.example.tablayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PublishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PublishFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextInputEditText mInputTitle;
    private TextInputEditText mInputContent;
    private String mTitle;
    private String mContent;
    private FloatingActionButton mSendButton;



    public PublishFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PublishFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PublishFragment newInstance(String param1, String param2) {
        PublishFragment fragment = new PublishFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_publish, container, false);
        mInputTitle = rootView.findViewById(R.id.input_title);
        mInputContent = rootView.findViewById(R.id.input_content);
        mSendButton = rootView.findViewById(R.id.send_button);

        mSendButton.setOnClickListener(view -> {
            mTitle = mInputTitle.getText().toString();
            mContent = mInputContent.getText().toString();
            // ??????????????????
            if (mTitle == null || mTitle.isEmpty() || mContent == null || mContent.isEmpty())
            {
                return;
            }
            mInputTitle.setText("");
            mInputContent.setText("");
            Bundle result = new Bundle();
            result.putString("title", mTitle);
            result.putString("content", mContent);
            getParentFragmentManager().setFragmentResult("send_key", result);
            Log.d("tag", "send");
        });
        return rootView;
    }

}
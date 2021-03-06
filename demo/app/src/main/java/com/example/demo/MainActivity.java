package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Class name for Log tag
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Unique tag required for the intent extra
    public static final String EXTRA_MESSAGE
            = "com.example.demo.extra.MESSAGE";
    public static final String EXTRA_URL
            = "com.example.demo.extra.URL";
    public static final String EXTRA_LOCATION
            = "com.example.demo.extra.LOCATION";
    // Unique tag for the intent reply
    public static final int TEXT_REQUEST = 1;

    private TextView mText;
    private  TextView[] mPosts = new TextView[2];

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Log the start of the onCreate() method.
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        mPosts[0] = findViewById(R.id.post_0);
        mPosts[1] = findViewById(R.id.post_0);

        // Restore the state.
        if (savedInstanceState != null) {
            for (TextView i: mPosts)
            {
                i.setVisibility(View.VISIBLE);
            }
        }
    }


    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Text clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        mText = findViewById(view.getId());
        String message = mText.getText().toString();
        String url = getString(R.string.str_url);
        String location = getString(R.string.str_location);
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(EXTRA_URL, url);
        intent.putExtra(EXTRA_LOCATION, location);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST && resultCode == RESULT_OK) {
            for (TextView i: mPosts)
            {
                i.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}
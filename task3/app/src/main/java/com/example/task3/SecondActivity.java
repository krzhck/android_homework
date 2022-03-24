package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG
            = SecondActivity.class.getSimpleName();

    private String message;
    private String text_url;
    private String text_location;

    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        text_url = intent.getStringExtra(MainActivity.EXTRA_URL);
        text_location = intent.getStringExtra(MainActivity.EXTRA_LOCATION);
        TextView textView = findViewById(R.id.post_detail);
        TextView textViewURL = findViewById(R.id.text_url);
        TextView textViewLOC = findViewById(R.id.text_location);
        textView.setText(message);
        textViewURL.setText(text_url);
        textViewLOC.setText(text_location);
    }

    public void returnReply(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }

    public void openWebsite(View view) {
        String url = text_url;
        Log.d(LOG_TAG, "Open Web " + url);
        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void openLocation(View view) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        String loc = text_location;

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Start the activity.
        startActivity(intent);


    }

    public void shareText(View view) {
        Log.d(LOG_TAG, "Share " + message);
        String txt = message;
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_text_with)
                .setText(txt)
                .startChooser();
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
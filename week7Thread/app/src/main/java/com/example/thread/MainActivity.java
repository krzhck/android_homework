package com.example.thread;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {

    private ProgressBar bar1, bar2,bar3;
    private Thread th = null;
    private MyTask myTask = null;
    private Future<Integer> future = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.btn1);
        findViewById(R.id.btn2);
        findViewById(R.id.btn3);
        bar1 = findViewById(R.id.progressBar1);
        bar2 = findViewById(R.id.progressBar2);
        bar3 = findViewById(R.id.progressBar3);

        // TO DO
    }

    public void onButton1Click(View v){
        // TO DO
        if(th!=null) {
            th.interrupt();
        }
        th = new Thread(new mThread());
        th.start();
    }

    public void onButton2Click(View v){
        // TO DO
        if(myTask!=null) {
            myTask.cancel(true);
        }
        myTask = new MyTask();
        myTask.executeOnExecutor(Executors.newFixedThreadPool(1));
    }

    public void onButton3Click(View v){
        // TO DO
        if(future!=null) {
            future.cancel(true);
        }
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        future = threadPool.submit(new CallableThread());
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    bar1.setProgress(msg.arg1,true);
                    break;
                case 3:
                    bar3.setProgress(msg.arg1,true);
                    break;
                default:
                    break;
            }

        }
    };


    public class mThread implements Runnable{
        @Override
        public void run() {
            try{
                for(int i=0;i<100;i++) {
                    Thread.sleep(10);
                    Message msg = new Message();
                    msg.what = 1;
                    msg.arg1 = i+1;
                    handler.sendMessage(msg);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class MyTask extends AsyncTask<Void, Integer, Void>
    {
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Void... params) {
            try{
                for(int i=0;i<100;i++) {
                    Thread.sleep(10);
                    publishProgress(i+1);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... progresses) {
            bar2.setProgress(progresses[0],true);
        }

        @Override
        protected void onPostExecute(Void result) {

        }

        @Override
        protected void onCancelled() {

        }
    }

    public class CallableThread implements Callable<Integer> {
        @Override
        public Integer call() {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(10);
                    Message msg = new Message();
                    msg.what = 3;
                    msg.arg1 = i+1;
                    handler.sendMessage(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
    }
}



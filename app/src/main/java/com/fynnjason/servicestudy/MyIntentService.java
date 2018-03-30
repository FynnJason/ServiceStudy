package com.fynnjason.servicestudy;

import android.app.IntentService;
import android.content.Intent;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Author：FynnJason
 * Describe：
 */
public class MyIntentService extends IntentService {

    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        boolean isMainThread = Thread.currentThread() == Looper.getMainLooper().getThread();

        Log.e("MyIntentService", "is main thread:" + isMainThread);

        downFile();

    }


    @Override
    public void onCreate() {
        Log.e("MyIntentService", "onCreate：");
        super.onCreate();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.e("MyIntentService", "onStartCommand：");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("MyIntentService", "onDestroy：");
        super.onDestroy();
    }

    private void downFile() {
        try {
            Thread.sleep(5000);
            Log.e("MyIntentService", "downFile：下载完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

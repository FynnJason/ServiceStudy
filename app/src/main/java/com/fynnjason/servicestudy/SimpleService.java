package com.fynnjason.servicestudy;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Author：FynnJason
 * Describe：
 */
public class SimpleService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("SimpleService", "onBind：");
        return new MyBinder();
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("SimpleService", "onUnbind：");
        return super.onUnbind(intent);
    }

     class MyBinder extends Binder {
        public String getStringInfo() {
            return "我是服务返回的数据";
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("SimpleService", "onStartCommand：");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        Log.e("SimpleService", "onCreate：");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.e("SimpleService", "onDestroy：");
        super.onDestroy();
    }

}

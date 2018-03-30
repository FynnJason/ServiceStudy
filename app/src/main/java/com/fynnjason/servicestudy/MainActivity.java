package com.fynnjason.servicestudy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    SimpleService.MyBinder binder;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            // 绑定
            binder = (SimpleService.MyBinder) iBinder;
            // 与服务通信，这里拿到数据
            String info = binder.getStringInfo();
            // 拿到数据，就界面来显示看看
            Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            // 解绑，释放
            binder = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intent = new Intent(this, SimpleService.class);
    }

    public void onBindClick(View view) {
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    public void onUnBindClick(View view) {
        unbindService(connection);
    }
    public void onStartClick(View view) {
        startService(intent);
    }

    public void onStopClick(View view) {
        stopService(intent);
    }
}

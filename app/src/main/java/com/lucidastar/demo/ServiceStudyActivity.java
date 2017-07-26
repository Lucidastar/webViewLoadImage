package com.lucidastar.demo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lucidastar.demo.service.TestMyService;
import com.lucidastar.demo.utils.Utils;

import java.util.Set;

public class ServiceStudyActivity extends AppCompatActivity {

    private Intent intentService;
    private static final String TAG = "TestMyService";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_study);
    }

    //开启服务
    public void openService(View view){
        intentService = new Intent(this, TestMyService.class);
//        intentService.setAction("com.lucidastar.demo.TESTMYSERVICE");
//        intentService.setPackage(getPackageName());
        startService(intentService);
    }
    //关闭服务
    public void closeService(View view){
        stopService(intentService);
    }

    //绑定服务
    public void bindService(View view){
        intentService = new Intent(this,TestMyService.class);
        bindService(intentService,connection, Context.BIND_AUTO_CREATE);
    }
    //解绑定服务
    public void unbindService(View view){
        unbindService(connection);
    }
    //开启并绑定服务
    public void openAndBindService(View view){

    }

    //关闭并解绑服务

    public void closeAndUnbindService(View view){

    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected: 连接成功");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: 断开连接");
        }
    };


    public void checkServiceClose(View view){
        boolean serviceRunning = Utils.isServiceRunning(this, getPackageName() + ".service.TestMyService");
        if (serviceRunning){
            Log.i(TAG, "checkServiceClose: 服务开启");
        }else {
            Log.i(TAG, "checkServiceClose: 服务关闭");
        }

    }

    public void checkServiceNum(View view){
        Set<String> allRunningService = Utils.getAllRunningService(this);

        for (String s : allRunningService) {
            Log.i(TAG, "checkServiceNum: "+s);
        }
    }

}

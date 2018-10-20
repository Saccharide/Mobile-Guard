package edu.wm.cs.mobileguard;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.net.Socket;



public class RunningServer extends IntentService {


    public RunningServer() {
        super("Running Server");
    }


//    @Override
//    public void onStart(Intent intent, int startId) {
//        // For time consuming an long tasks you can launch a new thread here...
////        Toast.makeText(this, " Service Started", Toast.LENGTH_LONG).show();
//        ProxyServer proxyServer = new ProxyServer();
//        proxyServer.execute();
//        Toast.makeText(this, " Service Started", Toast.LENGTH_LONG).show();
//    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        super.onStartCommand(intent,flags,startId);
        return START_STICKY;

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent == null){
            return;
        }
//        ResultReceiver receiver = intent.getParcelableExtra("Receiver");
        while(true) {
//            boolean result = true;
            ProxyServer proxyServer = new ProxyServer();
            proxyServer.execute();
            Toast.makeText(this, " Service Started !", Toast.LENGTH_LONG).show();
//            Bundle bundle = new Bundle();
//            bundle.putString("Status", result+"");
//            receiver.send(1234, bundle);
        }
    }
}
package edu.wm.cs.mobileguard;
import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        String[] values = new String[]{"Select app to secure", "User profile","Notification"};

        final ImageButton b_setting = (ImageButton)findViewById(R.id.button_setting);
        b_setting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //go to next page only if checked
                switch_to_setting();}

        });
        final ImageButton b_home = (ImageButton) findViewById(R.id.button_home);
        b_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //go to next page only if checked
                switch_to_home();}

        });
        final ImageButton b_help = (ImageButton) findViewById(R.id.button_help);
        b_help.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //go to next page only if checked
                switch_to_help();}

        });

        final ArrayList<String> slist = new ArrayList<String>();
        for(int i = 0; i<values.length; ++i){
            slist.add(values[i]);
        }

        final ArrayAdapter settingadapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, slist);
        final ListView setting_list = (ListView)findViewById(R.id.list);
        setting_list.setAdapter(settingadapter);
        System.out.println(settingadapter.getCount());
        final Intent intentApp = new Intent(this, AppSelectActivity.class);
        setting_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                System.out.println(item);
                if(item == "Select app to secure"){
                    System.out.println("!!!");
                    System.out.println(SelectedAppList.getAppList());
                        startActivity(intentApp);
                }
                if(item == "Notification"){
                        sendNotification();

                }
            }
        });

    }


    private void sendNotification() {
        NotificationCompat.Builder notification;
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.drawable.ic_warning_black_24dp);
        notification.setTicker("Ticker");
        notification.setWhen(System.currentTimeMillis());

        notification.setContentTitle("Insecure Internet Connection!!");
        notification.setContentText("Using HTTP Protocol :(");

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        // Builds notification and issues it
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(12345, notification.build());

    }

    public void switch_to_setting(){
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
    public void switch_to_home(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void switch_to_help(){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }


}

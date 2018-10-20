package edu.wm.cs.mobileguard;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    // Setting the reference variable for sending data / receiving data
    private ApplicationAdapterMain applistAdaptor = null;
    EditText user_text;
    Button send_button;
    SparseArray<Group> groups = new SparseArray<Group>();
    private PackageManager packageManager;
//    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start Proxy Server Service
//        StatusReciever reciever = new StatusReciever(new Status());
//        server.putExtra("Receiver",reciever);




        packageManager = getPackageManager();
        createData();

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
                switch_to_help_main();}

        });

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.expandlist);
        MyExpandableListAdapter adapter = new MyExpandableListAdapter(this, groups);
        listView.setAdapter(adapter);



    }

    public void createData(){
        ArrayList<ApplicationInfo> user_selected_apps = new ArrayList<ApplicationInfo>();
//        user_selected_apps = (ArrayList<ApplicationInfo>) getIntent().getSerializableExtra("SelectedAppList");
        user_selected_apps = SelectedAppList.getAppList();
        for(int j = 0; j< user_selected_apps.size();j++){
            Group group = new Group( user_selected_apps.get(j), packageManager);
            group.children.add("Secure");

            groups.append(j,group);
        }

    }


    public class Status{
        public void displayStatus(int resultCode, Bundle resultData){

            String message = resultData.getString("Status");
            Toast.makeText(MainActivity.this, resultCode + "" + message, Toast.LENGTH_LONG).show();
        }
    }

    private boolean isSystemPackage(ApplicationInfo appInfo){
        return(appInfo.flags & ApplicationInfo.FLAG_SYSTEM)!= 0;
    }

    public void switch_to_setting(){
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
    public void switch_to_home(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void switch_to_main() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void switch_to_help_main(){
        Intent intent = new Intent(this, HelpMainActivity.class);
        startActivity(intent);
    }

}

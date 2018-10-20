package edu.wm.cs.mobileguard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Launch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

//        //==========================debug button====================================
//        final Button switch_legal = (Button)findViewById(R.id.home_to_legal);
//        switch_legal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch_to_legal();
//            }
//        });
//        final Button switch_setting = (Button)findViewById(R.id.home_to_setting);
//        switch_setting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch_to_setting();
//            }
//        });
//        final Button switch_help = (Button)findViewById(R.id.home_to_help);
//        switch_help.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch_to_help();
//            }
//        });
//        final Button switch_main = (Button)findViewById(R.id.home_to_main);
//        switch_main.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch_to_main();
//            }
//        });
//        //========================================================================



        final Button button_next = (Button)findViewById(R.id.launchNext);
        button_next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch_to_legal();
            }
        });

    }

//    public void switch_to_setting(){
//        Intent intent = new Intent(this, Settings_Activity.class);
//        startActivity(intent);
//    }
//    public void switch_to_home(){
//        Intent intent = new Intent(this, Launch.class);
//        startActivity(intent);
//    }
//    public void switch_to_help(){
//        Intent intent = new Intent(this, HelpActivity.class);
//        startActivity(intent);
//    }
//
//    public void switch_to_main() {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }

    public void switch_to_legal(){
        Intent intent = new Intent(this, LegalActivity.class);
        startActivity(intent);
    }
}

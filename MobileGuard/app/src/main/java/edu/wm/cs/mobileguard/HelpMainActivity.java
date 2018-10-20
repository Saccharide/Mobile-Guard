package edu.wm.cs.mobileguard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HelpMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_main);



        final Button button_next = (Button)findViewById(R.id.HelpNext);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch_to_main(); }
        });

    }
    public void switch_to_main(){
        Intent intent = new Intent (  this, MainActivity.class);
        startActivity(intent);
    }

    public void switch_to_appselect() {
        Intent intent = new Intent(this, AppSelectActivity.class);
        startActivity(intent);
    }

}

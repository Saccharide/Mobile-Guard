package edu.wm.cs.mobileguard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class LegalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal);
        boolean ifChecked;
        final TextView text_service = (TextView)findViewById(R.id.term_of_use);
        text_service.setMovementMethod(new ScrollingMovementMethod());
        final CheckBox agree_service = (CheckBox)findViewById(R.id.checkBox_service);

        final Button button_next = (Button)findViewById(R.id.legalNext);
        button_next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //go to next page only if checked
                if(agree_service.isChecked()){
                    switch_to_help();}
            }
        });

    }


    public void switch_to_appselect() {
        Intent intent = new Intent(this, AppSelectActivity.class);
        startActivity(intent);
    }

    public void switch_to_help(){
        Intent intent = new Intent (  this, HelpActivity.class);
        startActivity(intent);
    }


}

package com.example.aayubonews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Bundle data;
    String linktext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //fullscreen
        setContentView(R.layout.activity_main);

        data =getIntent().getExtras();

        if(data !=null){
           // Toast.makeText(MainActivity.this,"Not null",Toast.LENGTH_SHORT).show();
            for(String key: data.keySet() ){
                if(key.equals("link")) {
                  //  Toast.makeText(MainActivity.this, "Val" + data.getString(key), Toast.LENGTH_SHORT).show();
                    linktext = data.getString(key);
                }
            }
        }
        else{
           // Toast.makeText(MainActivity.this,"Val null",Toast.LENGTH_SHORT).show();
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,HomeActivity.class);
                i.putExtra("link",linktext);
                startActivity(i);
                finish();
            }
        },1000); //set Delay
    }
}
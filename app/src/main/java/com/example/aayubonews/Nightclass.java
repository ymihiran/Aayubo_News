package com.example.aayubonews;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Nightclass extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switch_item);

        Switch nightSwitch = (Switch)findViewById(R.id.nswitch);

        Toast.makeText(Nightclass.this,"Started",Toast.LENGTH_SHORT).show();

        nightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                System.out.println("Changed XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                Toast.makeText(Nightclass.this,"Night switch pressed",Toast.LENGTH_SHORT).show();
            }
        });
    }

}

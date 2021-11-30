package com.example.aayubonews;

import android.content.Intent;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.aayubonews.databinding.SwitchItemBinding;
import com.example.aayubonews.ui.about.AboutFragment;
import com.example.aayubonews.ui.advertisment.AdsFragment;
import com.example.aayubonews.ui.contact.ContactFragment;
import com.example.aayubonews.ui.finance.FinanceFragment;
import com.example.aayubonews.ui.home.HomeFragment;
import com.example.aayubonews.ui.more.MoreFragment;
import com.example.aayubonews.ui.settings.SettingFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;

import com.example.aayubonews.databinding.ActivityHomeBinding;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity {
    public static boolean darkOn;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;
    private SwitchItemBinding binding2;
    private long pressTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


     binding = ActivityHomeBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarHome.toolbar);


        binding.appBarHome.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Refreshing...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //option menu select
        int id = item.getItemId();

        if (id == R.id.action_About){
            Toast.makeText(this,"About",Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_home,new AboutFragment()).commit();
        }

        else if (id == R.id.action_Contact){
            Toast.makeText(this,"Contact",Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_home,new ContactFragment()).commit();
        }

        else if (id == R.id.action_ads){
            Toast.makeText(this,"Ads",Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_home,new AdsFragment()).commit();
        }

        else if (id == R.id.action_setting){
            Toast.makeText(this,"Setting",Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_home,new SettingFragment()).commit();
        }
        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    public void onBackPressed(){


        if(pressTime+2000>System.currentTimeMillis()){
            super.onBackPressed();
            finish();
        }
        else{
            Toast.makeText(this,"Press again to exit",Toast.LENGTH_SHORT).show();
        }
        pressTime = System.currentTimeMillis();
    }


 */

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public static boolean getDark(){
        return darkOn;
    }

    public static void setDark(boolean mode){
        darkOn = mode;
    }

    public static void test(String a){
        System.out.println("************ Value -->>"+a);
    }

    public void openAbout(){
        //binding.
       // Toast.makeText(this,"Button pressed",Toast.LENGTH_SHORT).show();
    }



}
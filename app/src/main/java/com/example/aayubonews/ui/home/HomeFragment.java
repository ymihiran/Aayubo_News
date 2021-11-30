package com.example.aayubonews.ui.home;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;

import com.example.aayubonews.HomeActivity;
import com.example.aayubonews.R;
import com.example.aayubonews.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    protected boolean dark = HomeActivity.getDark();
    private HomeViewModel homeViewModel;

private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        System.out.println("==============Home Created==========");
/*
        //dark mode
        WebView HomeWeb = findViewById(R.id.webHome);
        HomeWeb.getSettings().setJavaScriptEnabled(true);

        if(WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)){
            WebSettingsCompat.setForceDark(HomeWeb.getSettings(), WebSettingsCompat.FORCE_DARK_ON);
        }
*/

        binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final WebView homeWebView = binding.webHome;
        final ProgressBar loadingPB = binding.progHome;

        homeWebView.loadUrl("https://aayubo.com/si");
        //darkmode;
        homeWebView.getSettings().setJavaScriptEnabled(true);

        if( HomeActivity.getDark() && WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)){
            WebSettingsCompat.setForceDark(homeWebView.getSettings(), WebSettingsCompat.FORCE_DARK_ON);
        }

        homeWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                loadingPB.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadingPB.setVisibility(View.GONE);
            }
        });

        homeWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                    switch (i){
                        case KeyEvent.KEYCODE_BACK:
                            if(homeWebView.canGoBack()){
                                homeWebView.goBack();
                            }
                    }

                }
                return false;
            }
        });


        return root;
    }


    public void onResume(@NonNull LayoutInflater inflater,
                         ViewGroup container, Bundle savedInstanceState) {
        super.onResume();
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final WebView homeWebView = binding.webHome;
/*
        WebSettingsCompat.setForceDark(homeWebView.getSettings(), WebSettingsCompat.FORCE_DARK_OFF);
        if( dark && WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)){
            WebSettingsCompat.setForceDark(homeWebView.getSettings(), WebSettingsCompat.FORCE_DARK_ON);
        }
        else{
            WebSettingsCompat.setForceDark(homeWebView.getSettings(), WebSettingsCompat.FORCE_DARK_OFF);
        }
*/
        System.out.println("Resumed *****************************************");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
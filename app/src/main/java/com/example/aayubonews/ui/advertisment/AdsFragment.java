package com.example.aayubonews.ui.advertisment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;

import com.example.aayubonews.HomeActivity;
import com.example.aayubonews.databinding.FragmentAboutBinding;
import com.example.aayubonews.databinding.FragmentAdsBinding;
import com.example.aayubonews.ui.about.AboutViewModel;

public class AdsFragment extends Fragment {
    private AdsViewModel featuredViewModel;
    private FragmentAdsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        featuredViewModel =
                new ViewModelProvider(this).get(AdsViewModel.class);

        binding = FragmentAdsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final WebView homeWebView = binding.webAds;
        final ProgressBar loadingPB = binding.progAds;

        if( HomeActivity.getDark() && WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)){
            WebSettingsCompat.setForceDark(homeWebView.getSettings(), WebSettingsCompat.FORCE_DARK_ON);
        }

        homeWebView.loadUrl("https://aayubo.com/si/advertise");
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

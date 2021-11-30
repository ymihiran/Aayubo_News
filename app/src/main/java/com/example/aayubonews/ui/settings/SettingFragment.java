package com.example.aayubonews.ui.settings;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;

import com.example.aayubonews.HomeActivity;
import com.example.aayubonews.R;
import com.example.aayubonews.databinding.FragmentGalleryBinding;
import com.example.aayubonews.databinding.FragmentHomeBinding;
import com.example.aayubonews.databinding.FragmentSettingBinding;
import com.example.aayubonews.ui.finance.FinanceViewModel;

import java.util.zip.Inflater;

public class SettingFragment extends Fragment {
    private SettingViewModel settingViewModel;
    private FragmentSettingBinding binding;
    private FragmentHomeBinding binding2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingViewModel =
                new ViewModelProvider(this).get(SettingViewModel.class);    //bind layout

        binding = FragmentSettingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Switch nightSwitch = binding.swtNight;
        RelativeLayout rl = binding.bg;

        //set initial values

        if(HomeActivity.getDark()){
            rl.setBackgroundColor(Color.parseColor("#000000"));
            nightSwitch.setTextColor(Color.parseColor("#FFFFFF"));
        }

        nightSwitch.setChecked(HomeActivity.getDark());

        nightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                HomeActivity.setDark(b); //set night mode status

                if(HomeActivity.getDark()){           //change setting window theme
                    rl.setBackgroundColor(Color.parseColor("#000000"));
                    nightSwitch.setTextColor(Color.parseColor("#FFFFFF"));
                }
                else{
                    rl.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    nightSwitch.setTextColor(Color.parseColor("#000000"));
                }

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

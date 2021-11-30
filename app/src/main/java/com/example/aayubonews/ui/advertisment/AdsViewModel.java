package com.example.aayubonews.ui.advertisment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AdsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AdsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Setting fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
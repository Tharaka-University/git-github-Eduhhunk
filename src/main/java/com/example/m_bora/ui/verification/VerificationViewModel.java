package com.example.m_bora.ui.verification;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VerificationViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public VerificationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is verification fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
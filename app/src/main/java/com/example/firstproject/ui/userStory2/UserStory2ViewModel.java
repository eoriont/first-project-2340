package com.example.firstproject.ui.userStory2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserStory2ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public UserStory2ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is User Story 2 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
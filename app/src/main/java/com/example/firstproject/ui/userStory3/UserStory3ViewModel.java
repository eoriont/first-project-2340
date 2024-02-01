package com.example.firstproject.ui.userStory3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserStory3ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public UserStory3ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is User Story 3 fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }
}
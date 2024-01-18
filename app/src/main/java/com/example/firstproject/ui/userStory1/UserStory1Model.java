package com.example.firstproject.ui.userStory1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserStory1Model extends ViewModel {

    private final MutableLiveData<String> mText;

    public UserStory1Model() {
        mText = new MutableLiveData<>();
        mText.setValue("This is User Story 1 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
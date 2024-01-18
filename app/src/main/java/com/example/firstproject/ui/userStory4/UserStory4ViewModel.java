package com.example.firstproject.ui.userStory4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserStory4ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public UserStory4ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is User Story 4 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.example.firstproject.ui.userStory1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.firstproject.databinding.FragmentUserStory1Binding;

public class UserStory1Fragment extends Fragment {

    private FragmentUserStory1Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserStory1Model userStory1Model =
                new ViewModelProvider(this).get(UserStory1Model.class);

        binding = FragmentUserStory1Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textUserStory1;
        userStory1Model.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.firstproject.ui.userStory3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.firstproject.databinding.FragmentUserStory3Binding;

public class UserStory3Fragment extends Fragment {

    private FragmentUserStory3Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserStory3ViewModel userStory3ViewModel =
                new ViewModelProvider(this).get(UserStory3ViewModel.class);

        binding = FragmentUserStory3Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textUserStory3;
        userStory3ViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.firstproject.ui.userStory2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.firstproject.databinding.FragmentUserStory2Binding;

public class UserStory2Fragment extends Fragment {

    private FragmentUserStory2Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserStory2ViewModel userStory2ViewModel =
                new ViewModelProvider(this).get(UserStory2ViewModel.class);

        binding = FragmentUserStory2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textUserStory2;
        userStory2ViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.firstproject.ui.userStory4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.firstproject.databinding.FragmentUserStory4Binding;

public class UserStory4Fragment extends Fragment {

    private FragmentUserStory4Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserStory4ViewModel userStory4ViewModel =
                new ViewModelProvider(this).get(UserStory4ViewModel.class);

        binding = FragmentUserStory4Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textUserStory4;
        userStory4ViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
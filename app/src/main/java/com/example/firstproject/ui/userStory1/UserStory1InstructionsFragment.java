package com.example.firstproject.ui.userStory1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.firstproject.R;
import com.example.firstproject.databinding.UserStory1InstructionsBinding;

public class UserStory1InstructionsFragment extends Fragment {
    private UserStory1InstructionsBinding binding;
    private TextView backNavigation;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = UserStory1InstructionsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backNavigation = binding.backNavigation;

        backNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment
                        .findNavController(UserStory1InstructionsFragment.this)
                        .navigate(R.id.action_navigation_user_story_1_instructions_to_navigation_user_story_1);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

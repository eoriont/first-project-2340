package com.example.firstproject.ui.userStory4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.firstproject.R;
import com.example.firstproject.databinding.CreateEditDeleteTaskBinding;

import org.w3c.dom.Text;

public class CreateEditDeleteTaskFragment extends Fragment {
    private CreateEditDeleteTaskBinding binding;
    private TextView backButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = CreateEditDeleteTaskBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        backButton = binding.backButton;

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(CreateEditDeleteTaskFragment.this)
                        .navigate(R.id.action_navigation_create_edit_delete_task_to_navigation_user_story_4);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.firstproject.ui.userStory2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.firstproject.databinding.AssignmentsInstructionsBinding;
import com.example.firstproject.R;

public class AssignmentsInstructionsFragment extends Fragment {
    private AssignmentsInstructionsBinding binding;
    private TextView backNavigation;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        binding = AssignmentsInstructionsBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();

//        return root;
        return inflater.inflate(R.layout.assignments_instructions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backNavigation = binding.backNavigation;

        backNavigation.setOnClickListener(v -> {
//            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_view);
//            navController.popBackStack();
            NavHostFragment
                    .findNavController(AssignmentsInstructionsFragment.this)
                    .navigate(R.id.action_navigation_assignments_instructions_to_navigation_user_story_2);
//                    .navigate();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

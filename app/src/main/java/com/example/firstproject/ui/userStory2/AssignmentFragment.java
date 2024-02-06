package com.example.firstproject.ui.userStory2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.firstproject.R;
import com.example.firstproject.databinding.FragmentUserStory2Binding;
import com.example.firstproject.ui.userStory4.UserStory4Fragment;
import com.example.firstproject.ui.userStory4.UserStory4FragmentDirections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AssignmentFragment extends Fragment {

    private FragmentUserStory2Binding binding;
    private ArrayAdapter<Assignment> itemsAdapter;
    private ListView lvItems;
    private boolean sortMode = false; // false = due date, true = course


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUserStory2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        lvItems = binding.lvItems;

        itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, Assignment.assignments);
        lvItems.setAdapter(itemsAdapter);

//        items.add(new Assignment("1/31/24", "Hw 1", "CS 2340"));
//        items.add(new Assignment("1/31/24", "Hw 1", "MATH 3406"));
//        items.add(new Assignment("2/08/24", "Hw 3", "CS 2340"));
//        items.add(new Assignment("2/04/24", "Hw 2", "CS 2340"));
//        items.add(new Assignment("2/04/24", "Hw 2", "MATH 3406"));

        lvItems.setOnItemLongClickListener(this::onItemDelete);
        lvItems.setOnItemClickListener(this::onItemClick);

        binding.btnNew.setOnClickListener((view) -> {
            Assignment.assignments.add(new Assignment());
            AssignmentEditDialogueFragment newFragment = new AssignmentEditDialogueFragment(Assignment.assignments, Assignment.assignments.size()-1, true, itemsAdapter, this::sort);
            newFragment.show(getParentFragmentManager(), "edit");

            itemsAdapter.notifyDataSetChanged();
        });

        binding.btnSort.setOnClickListener((view) -> {
            sortMode = !sortMode;
            if (sortMode) {
                binding.btnSort.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.purple_200));
            } else {
                binding.btnSort.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.teal_200));
            }
            sort();
            itemsAdapter.notifyDataSetChanged();
        });

        binding.btnHelp.setOnClickListener(v -> {
//            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.navigation_assignments_instructions, new AssignmentInstructionsFragment());
//            fragmentTransaction.addToBackStack(null); // if you want to add the transaction to the back stack
//            fragmentTransaction.commit();
//            Navigation.findNavController(getView()).navigate(R.id.navigation_assignments_instructions);

            NavHostFragment
                    .findNavController(AssignmentFragment.this)
                    .navigate(
                            AssignmentFragmentDirections.actionNavigationUserStory2ToNavigationAssignmentsInstructions()
                    );
        });
//                            R.id.action_navigation_user_story_2_to_navigation_assignments_instructions
        return root;
    }

    public void sort() {
        if (sortMode) {
            Assignment.assignments.sort(Comparator.comparing(x -> x.getAssociatedClass().getClassName()));
        } else {
            Assignment.assignments.sort(Comparator.comparing(Assignment::getDate));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public boolean onItemDelete(AdapterView<?> adapter, View item, int pos, long id) {
        Assignment.assignments.remove(pos);
        itemsAdapter.notifyDataSetChanged();
        return true;
    }

    public void onItemClick(AdapterView<?> adapter, View item, int pos, long id) {
        AssignmentEditDialogueFragment newFragment = new AssignmentEditDialogueFragment(Assignment.assignments, pos, false, itemsAdapter, this::sort);
        newFragment.show(getParentFragmentManager(), "edit");
        itemsAdapter.notifyDataSetChanged();
    }

}
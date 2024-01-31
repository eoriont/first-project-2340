package com.example.firstproject.ui.userStory4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.firstproject.R;
import com.example.firstproject.databinding.FragmentUserStory4Binding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class UserStory4Fragment extends Fragment {
    private FragmentUserStory4Binding binding;
    private ListView view;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    private FloatingActionButton fab;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUserStory4Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        list = new ArrayList<>();
        list.add("1");
        list.add("2");
        view = binding.list;
        adapter = new ArrayAdapter<String>(this.getContext(), R.layout.task, list);
        view.setAdapter(adapter);

        fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(UserStory4Fragment.this).navigate(
                        UserStory4FragmentDirections.actionNavigationUserStory4ToNavigationCreateEditDeleteTask()
                );
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
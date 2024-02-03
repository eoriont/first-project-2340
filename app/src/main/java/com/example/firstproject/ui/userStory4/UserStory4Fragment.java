package com.example.firstproject.ui.userStory4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.firstproject.R;
import com.example.firstproject.databinding.FragmentUserStory4Binding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserStory4Fragment extends Fragment {
    private FragmentUserStory4Binding binding;
    private ListView view;
    private ArrayAdapter<String> adapter;
    private TextView instructions;
    private EditText idInput, taskInput;
    private Button add, edit, delete;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUserStory4Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        view = binding.list;
        adapter = new ArrayAdapter(this.getContext(), R.layout.task, new ArrayList<String>());
        view.setAdapter(adapter);
        adapter.sort((a, b) -> b.compareTo(a));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        instructions = binding.instructions;
        idInput = binding.idInput;
        taskInput = binding.taskInput;
        add = binding.add;
        edit = binding.edit;
        delete = binding.delete;

        instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment
                        .findNavController(UserStory4Fragment.this)
                        .navigate(
                                UserStory4FragmentDirections
                                        .actionNavigationUserStory4ToNavigationTodoListInstructions()
                        );
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idInput.getText().toString();
                String task = taskInput.getText().toString();
                adapter.add(String.format("#%s: %s", id, task));
                adapter.sort((a, b) -> b.compareTo(a));

                idInput.setText("");
                taskInput.setText("");
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idInput.getText().toString();
                String task = taskInput.getText().toString();

                for (int i = 0; i < adapter.getCount(); i++) {
                    String curr = adapter.getItem(i);

                    if (curr.substring(1, curr.indexOf(':')).equals(id)) {
                        adapter.remove(curr);
                        adapter.insert(String.format("#%s: %s", id, task), i);
                        adapter.sort((a, b) -> b.compareTo(a));
                        break;
                    }
                }

                idInput.setText("");
                taskInput.setText("");
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idInput.getText().toString();

                for (int i = 0; i < adapter.getCount(); i++) {
                    String curr = adapter.getItem(i);

                    if (curr.substring(1, curr.indexOf(':')).equals(id)) {
                        adapter.remove(curr);
                        break;
                    }
                }

                idInput.setText("");
                taskInput.setText("");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.firstproject.ui.userStory1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.firstproject.databinding.FragmentUserStory1Binding;
import com.example.firstproject.ui.userStory3.Exam;

import java.util.ArrayList;

public class UserStory1Fragment extends Fragment {

    private FragmentUserStory1Binding binding;

    private ArrayList<Class> classList = new ArrayList<>();
    private ArrayAdapter<Class> adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserStory1Model userStory1Model =
                new ViewModelProvider(this).get(UserStory1Model.class);

        binding = FragmentUserStory1Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView classListView = binding.classList;
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, classList);
        classListView.setAdapter(adapter);

        EditText classInput = binding.classInput;
        EditText teacherInput = binding.teacherInput;
        EditText timeInput = binding.timeInput;
        Button enterButton = binding.enterButton;

        binding.classList.setOnItemLongClickListener(this::onItemDelete);

        enterButton.setOnClickListener(v -> {
            String className = classInput.getText().toString();
            String teacher = teacherInput.getText().toString();
            String time = timeInput.getText().toString();

            if (!className.isEmpty() && !teacher.isEmpty() && !time.isEmpty()) {
                Class newClass = new Class(className, teacher, time);
                classList.add(newClass);
                adapter.notifyDataSetChanged();

                classInput.setText("");
                teacherInput.setText("");
                timeInput.setText("");
            }
        });

        return root;
    }

    public boolean onItemDelete(AdapterView<?> ad, View item, int pos, long id) {
        classList.remove(pos);
        adapter.notifyDataSetChanged();
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
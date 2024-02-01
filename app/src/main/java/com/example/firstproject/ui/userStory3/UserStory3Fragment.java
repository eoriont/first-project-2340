package com.example.firstproject.ui.userStory3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.firstproject.databinding.FragmentUserStory3Binding;
import java.util.ArrayList;

public class UserStory3Fragment extends Fragment {

    private FragmentUserStory3Binding binding;
    private ArrayList<Exam> examList = new ArrayList<>();
    private ArrayAdapter<Exam> adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUserStory3Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView examListView = binding.examList;
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, examList);
        examListView.setAdapter(adapter);

        EditText dateInput = binding.dateInput;
        EditText timeInput = binding.timeInput;
        EditText locationInput = binding.locationInput;
        Button submitButton = binding.submitButton;

        submitButton.setOnClickListener(v -> {
            String date = dateInput.getText().toString();
            String time = timeInput.getText().toString();
            String location = locationInput.getText().toString();

            if (!date.isEmpty() && !time.isEmpty() && !location.isEmpty()) {
                Exam newExam = new Exam(date, time, location);
                examList.add(newExam);
                adapter.notifyDataSetChanged();


                dateInput.setText("");
                timeInput.setText("");
                locationInput.setText("");
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

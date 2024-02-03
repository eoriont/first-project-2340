package com.example.firstproject.ui.userStory2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class AssignmentEditDialogueFragment extends DialogFragment {

    int which;
    boolean isNew;
    EditText editTitle, editDate, editClass;
    ArrayAdapter<Assignment> adapter;
    ArrayList<Assignment> list;

    I sorter;

    interface I {
        void sort();
    }

    public AssignmentEditDialogueFragment(ArrayList<Assignment> list, int which, boolean isNew, ArrayAdapter<Assignment> adapter, I sorter) {
        super();
        this.list = list;
        this.which = which;
        this.isNew = isNew;
        this.adapter = adapter;
        this.sorter = sorter;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Assignment current = list.get(which);

        editTitle = new EditText(getContext());
        editTitle.setText(current.getAssignment());
        editTitle.setHint("Assignment Title");

        editDate = new EditText(getContext());
        editDate.setInputType(InputType.TYPE_CLASS_DATETIME);
        editDate.setText(current.getDate());
        editDate.setHint("Due Date");

        editClass = new EditText(getContext());
        editClass.setText(current.getAssociatedClass());
        editClass.setHint("Associated Class");

        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 50, 50, 50);

        layout.addView(editTitle);
        layout.addView(editDate);
        layout.addView(editClass);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder
                .setTitle(isNew ? "Create New Assignment" : "Edit Assignment")
                .setView(layout)
                .setPositiveButton("Save", (dialogInterface, x) -> {
                    Assignment a = new Assignment(editDate.getText().toString(), editTitle.getText().toString(), editClass.getText().toString());
                    list.set(which, a);
                    sorter.sort();
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("Cancel", (dialog, id) -> {
                    if (isNew) {
                        list.remove(which);
                        adapter.notifyDataSetChanged();
                    }
                    dialog.cancel();
                });

        return builder.create();
    }
}

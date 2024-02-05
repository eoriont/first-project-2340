package com.example.firstproject.ui.userStory2;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.DialogFragment;

import com.example.firstproject.MyReceiver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
                    String dateStr = editDate.getText().toString();
                    String titleStr = editTitle.getText().toString();
                    String classStr = editClass.getText().toString();
                    Assignment a = new Assignment(dateStr, titleStr, classStr);
                    list.set(which, a);
                    sorter.sort();

                    Date date = parseDate(dateStr);
                    Log.d("INFO", date.toString());
                    String message = "Your assignment for class " + classStr + " is due!";
                    MyReceiver.scheduleNotification(getContext(), titleStr, message, date);

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

    public Date parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");

        LocalDate date = LocalDate.parse(dateStr, formatter);

        if (date.getYear() < 2000) {
            date = date.withYear(date.getYear() + 100);
        }
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}

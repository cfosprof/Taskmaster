package com.foster917.taskmaster;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        TextView titleTextView = findViewById(R.id.title_text_view);
        TextView bodyTextView = findViewById(R.id.body_text_view);

        String taskTitle = getIntent().getStringExtra(getString(R.string.tasktitle));
        String taskBody = getIntent().getStringExtra(getString(R.string.taskbody));

        titleTextView.setText(taskTitle);
        bodyTextView.setText(taskBody);
    }
}

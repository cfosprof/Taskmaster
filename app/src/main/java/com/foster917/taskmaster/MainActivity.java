package com.foster917.taskmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView taskRecyclerView;
    private TaskAdapter taskAdapter;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTaskButton = findViewById(R.id.add_task_button);
        addTaskButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
            startActivity(intent);
        });

        Button allTasksButton = findViewById(R.id.all_tasks_button);
        allTasksButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AllTasksActivity.class);
            startActivity(intent);
        });

        Button settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        taskRecyclerView = findViewById(R.id.task_recycler_view);

        taskList = new ArrayList<>();
        taskList.add(new Task("Task 1 Title", "Task 1 Body", "new"));
        taskList.add(new Task("Task 2 Title", "Task 2 Body", "in progress"));
        taskList.add(new Task("Task 3 Title", "Task 3 Body", "completed"));

        taskAdapter = new TaskAdapter(this, taskList);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskRecyclerView.setAdapter(taskAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedPreferences.getString("username", "Foster917");

        TextView usernameTextView = findViewById(R.id.username_text_view);
        usernameTextView.setText(username + "'s tasks");
    }
}

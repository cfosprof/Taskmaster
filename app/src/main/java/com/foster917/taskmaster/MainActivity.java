package com.foster917.taskmaster;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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

        Button task1Button = findViewById(R.id.task1_button);
        task1Button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TaskDetailActivity.class);
            intent.putExtra(getString(R.string.tasktitle), "Task 1 Title");
            intent.putExtra(getString(R.string.taskbody), "Task 1 Body");
            startActivity(intent);
        });

        Button task2Button = findViewById(R.id.task2_button);
        task2Button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TaskDetailActivity.class);
            intent.putExtra(getString(R.string.tasktitle), "Task 2 Title");
            intent.putExtra(getString(R.string.taskbody), "Task 2 Body");
            startActivity(intent);
        });

        Button task3Button = findViewById(R.id.task3_button);
        task3Button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TaskDetailActivity.class);
            intent.putExtra(getString(R.string.tasktitle), "Task 3 Title");
            intent.putExtra(getString(R.string.taskbody), "Task 3 Body");
            startActivity(intent);
        });

        Button settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
        String username = sharedPreferences.getString("username", "Foster917");

        TextView usernameTextView = findViewById(R.id.username_text_view);
        usernameTextView.setText(username + "'s tasks");
    }
}

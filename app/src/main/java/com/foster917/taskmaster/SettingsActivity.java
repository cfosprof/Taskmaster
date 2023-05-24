package com.foster917.taskmaster;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        EditText usernameEditText = findViewById(R.id.username_edit_text);
        Button saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            sharedPreferences.edit().putString("username", username).apply();

            finish();
        });
    }
}

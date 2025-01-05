package com.example.wordcounterapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputText;
    private Spinner countTypeSpinner;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        inputText = findViewById(R.id.inputText);
        countTypeSpinner = findViewById(R.id.countTypeSpinner);
        Button countButton = findViewById(R.id.countButton);
        resultText = findViewById(R.id.resultText);

        // Setup spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countTypeSpinner.setAdapter(adapter);

        // Setup button click listener
        countButton.setOnClickListener(v -> performCount());
    }

    private void performCount() {
        String text = inputText.getText().toString();
        
        if (text.trim().isEmpty()) {
            Toast.makeText(this, R.string.empty_input_error, Toast.LENGTH_SHORT).show();
            return;
        }

        int result;
        if (countTypeSpinner.getSelectedItemPosition() == 0) {
            // Count words
            result = TextCounter.countWords(text);
            resultText.setText(getString(R.string.result_label) + result + " words");
        } else {
            // Count characters
            result = TextCounter.countCharacters(text);
            resultText.setText(getString(R.string.result_label) + result + " characters");
        }
    }
}
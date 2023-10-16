package lv.edijs.myapplication8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private EditText textField;
    private Button readPreferencesButton;
    private Button backButton;
    private String userInput;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        readPreferencesButton = findViewById(R.id.readPref);
        backButton = findViewById(R.id.back);

        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE);

        readPreferencesButton.setOnClickListener(v -> {
            userInput = sharedPreferences.getString("user_input", "");
            if (userInput.isEmpty()) {
                Toast.makeText(Activity2.this, "Nothing found", Toast.LENGTH_SHORT).show();
            } else {
                textField.setText(userInput);
            }
        });

        backButton.setOnClickListener(v -> {
            finish();
            overridePendingTransition(0, 0);
        });
    }

}
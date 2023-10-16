package lv.edijs.myapplication8;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Activity1 extends AppCompatActivity {

    private EditText inputField;
    private Button saveButton;
    private Button goToSecondActivityButton;
    private Spinner themeSpinner;


    private String userInput;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        inputField = findViewById(R.id.input_field);
        saveButton = findViewById(R.id.save_button);
        goToSecondActivityButton = findViewById(R.id.goTo2nd);
        themeSpinner = findViewById(R.id.theme_spinner);

        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE);

        userInput = sharedPreferences.getString("user_input", "");
        inputField.setText(userInput);

        saveButton.setOnClickListener(v -> {
            userInput = inputField.getText().toString();
            sharedPreferences.edit().putString("user_input", userInput).apply();
        });

        goToSecondActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        });

        themeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedTheme = parent.getItemAtPosition(position).toString();

                switch (selectedTheme) {
                    case "Dark theme":
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                    case "Light theme":
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                    default:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

package lv.oto.prakt_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText textField;
    private Button readPreferencesButton;
    private Button backButton;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textField = findViewById(R.id.displayText);
        readPreferencesButton = findViewById(R.id.readPreferencesButton);
        backButton = findViewById(R.id.backButton);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        readPreferencesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String savedValue = sharedPreferences.getString("savedValue", "");
                if (!savedValue.isEmpty()) {
                    textField.setText(savedValue);
                } else {
                    Toast.makeText(SecondActivity.this, "Nothing found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
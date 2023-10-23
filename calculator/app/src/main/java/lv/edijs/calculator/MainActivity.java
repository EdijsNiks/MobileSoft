package lv.edijs.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_add, btn_minus, btn_divide, btn_multiplication, btn_MC, btn_MS, btn_MR;
    EditText textN1, textN2;
    TextView textView;
    int num1, num2;
    private double memoryValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.add);
        btn_multiplication = findViewById(R.id.times);
        btn_divide = findViewById(R.id.divide);
        btn_minus = findViewById(R.id.subtraction);
        btn_MC = findViewById(R.id.mc);
        btn_MS = findViewById(R.id.ms);
        btn_MR = findViewById(R.id.mr);
        textN1 = findViewById(R.id.numberOne);
        textN2 = findViewById(R.id.numberTwo);
        textView = findViewById(R.id.result);

        btn_minus.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_multiplication.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_MS.setOnClickListener(this);
        btn_MC.setOnClickListener(this);
    }

    public int getNumber(EditText editText) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Enter the number", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Integer.parseInt(editText.getText().toString());
    }

    @Override
    public void onClick(View v) {
        num1 = getNumber(textN1);
        num2 = getNumber(textN2);

        if (v.getId() == R.id.add) {
            textView.setText("Answer is " + (num1 + num2));
        } else if (v.getId() == R.id.subtraction) {
            textView.setText("Answer is " + (num1 - num2));
        } else if (v.getId() == R.id.divide) {
            textView.setText("Answer is " + (num1 / num2));
        } else if (v.getId() == R.id.times) {
            textView.setText("Answer is " + (num1 * num2));
        } else if (v.getId()==R.id.ms) {
            memoryValue = Double.parseDouble(textView.getText().toString());
        } else if (v.getId()==R.id.mc) {
            memoryValue = 0;
        } else if (v.getId()==R.id.mr) {
            textView.setText(String.valueOf(memoryValue));
        }

    }

}




















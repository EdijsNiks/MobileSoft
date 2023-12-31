package lv.oto.nextory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    Button  btn_generalNews, btn_publishNews, btn_seeInAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn_publishNews = findViewById(R.id.btn_publishNews);
        btn_generalNews = findViewById(R.id.btn_generalNews);
        btn_seeInAR = findViewById(R.id.btn_seeInAR);

        btn_publishNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, PublishNews.class));
            }
        });
        btn_generalNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, MainActivity.class));
            }
        });
        btn_seeInAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, AugmentedReality.class));
            }
        });

    }
}
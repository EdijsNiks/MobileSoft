package lv.oto.nextory;

//import com.google.ar.sceneform.ArFragment;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AugmentedReality extends AppCompatActivity {

    //private ArFragment arFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);
    }
}
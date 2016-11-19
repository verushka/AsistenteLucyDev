package modulo3.nicaela.com.asistentelucydev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.Normalizer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.buttonForm);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goForm(v);
            }
        });
    }

    public void goForm(View view)
    {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }
}

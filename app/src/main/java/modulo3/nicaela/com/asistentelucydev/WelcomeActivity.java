package modulo3.nicaela.com.asistentelucydev;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    private LinearLayout layoutButton;
    private int valNum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        layoutButton = (LinearLayout) findViewById(R.id.button_list);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //animar(true);
               if(valNum==0) {
                   valNum=1;
                   layoutButton.setVisibility(View.VISIBLE);
               }else{
                   valNum=0;
                   layoutButton.setVisibility(View.GONE);
               }
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
               //         .setAction("Action", null).show();
            }
        });


        FloatingActionButton register = (FloatingActionButton) findViewById(R.id.formRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "holaaaa" , Toast.LENGTH_LONG).show();

            }
        });



    }

}

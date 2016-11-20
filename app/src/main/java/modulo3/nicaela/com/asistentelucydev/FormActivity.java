package modulo3.nicaela.com.asistentelucydev;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class FormActivity extends AppCompatActivity {

    //Speaking variables
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private EditText titleText;
    private EditText firstNameText;
    private EditText lastNameText;
    private EditText sexText;
    private EditText stateText;
    private Button btnLucy;
    private TextToSpeech textToSpeech1;
    private TextView helpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final Context context = this;
        titleText = (EditText) findViewById(R.id.editTitle);
        firstNameText = (EditText) findViewById(R.id.editFirstName);
        lastNameText = (EditText) findViewById(R.id.editLastName);
        sexText = (EditText) findViewById(R.id.editSex);
        stateText = (EditText) findViewById(R.id.editState);
        helpText = (TextView) findViewById(R.id.id_img_lucy);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    promptSpeechInput();
                } catch (Exception ex) {

                    ex.printStackTrace();
                    Toast.makeText(context, ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        textToSpeech1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech1.setLanguage(new Locale( "spa", "ESP"));
                }
            }
        });

        btnLucy = (Button)findViewById(R.id.id_img_lucy);
        btnLucy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*String toSpeak = name.getText().toString();*/
                String toSpeak = "Genial! Juan es un bonito nombre, es tuyo?";
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                textToSpeech1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                helpText.setText(toSpeak);
            }
        });

        titleText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    String toSpeak = "Cual es tu titulo? o prefieres que te llamen Senor o Senora";
                    Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    helpText.setText(toSpeak);
                }
            }
        });

        firstNameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    String toSpeak = "Cual es tu primer nombre?";
                    Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        lastNameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    String toSpeak = "Cual es tu Apellido?";
                    Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        sexText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    String toSpeak = "Cual es tu sexo?";
                    Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        stateText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    String toSpeak = "Cual es tu estado civil?";
                    Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    if (titleText.isFocused()) {
                        titleText.setText(result.get(0));
                    }

                    if (firstNameText.isFocused()) {
                        firstNameText.setText(result.get(0));
                    }

                    if (lastNameText.isFocused()) {
                        lastNameText.setText(result.get(0));
                    }

                    if (sexText.isFocused()) {
                        sexText.setText(result.get(0));
                    }

                    if (stateText.isFocused()) {
                        stateText.setText(result.get(0));
                    }
                }
                break;
            }
        }
    }

}

package com.example.translate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mTextInput;
    private EditText mTranslatedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextInput = findViewById(R.id.editTextToTranslate);
        mTranslatedText = findViewById(R.id.editTextTranslated);


    }

    public void translateText(View view) {
        String translateThis = mTextInput.getText().toString();
        new Translate(mTextInput, mTranslatedText).execute(translateThis);
    }
}
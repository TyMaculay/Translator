package com.example.translate;

import android.os.AsyncTask;
import android.widget.EditText;

import java.lang.ref.WeakReference;

public class Translate extends AsyncTask<String, Void, String> {
    Translate(EditText inputText, EditText translatedText) {
        WeakReference<EditText> mInputText = new WeakReference<>(inputText);
        WeakReference<EditText> mTranslatedText = new WeakReference<>(translatedText);
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getTranslation(strings[0]);
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }
}


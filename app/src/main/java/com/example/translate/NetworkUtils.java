package com.example.translate;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkUtils {
    private static final String LOG_TAG =
            NetworkUtils.class.getSimpleName();
    static OkHttpClient client = new OkHttpClient();
    static String getTranslation(String translateThis){
        String JSONString = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("from", "en")
                    .add("to", "ru")
                    .add("text", translateThis)
                    .build();

            Request request = new Request.Builder()
                    .url("https://translo.p.rapidapi.com/api/v3/translate")
                    .post(body)
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .addHeader("X-RapidAPI-Key", "409c3c777fmshda49fbb11a9d4e0p1944dfjsncd49172d0444")
                    .addHeader("X-RapidAPI-Host", "translo.p.rapidapi.com")
                    .build();

            Response response = client.newCall(request).execute();
            String s = response.body().string();
            JSONObject jsonObject = new JSONObject(s);
            return jsonObject.getString("translated_text");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}


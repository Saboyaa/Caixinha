package com.example.exerciciolabprog2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.fragment.NavHostFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        client = new OkHttpClient();

        makeLoginRequest();
    }

    private void makeLoginRequest() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", "test1@test.com");
            jsonObject.put("password", "test123");

            RequestBody body = RequestBody.create(jsonObject.toString(), MediaType.parse("application/json"));
            Request request = new Request.Builder()
                    .url("http://10.0.2.2:8080/auth/login")
                    .post(body)
                    .build();

            // Asynchronous call
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    // Log the error if the request fails
                    Log.e("ERROR", "Network request failed", e);
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        // Handle the response
                        String responseBody = response.body().string();
                        Log.d("DEBUG", "Response: " + responseBody);
                    } else {
                        Log.e("ERROR", "Request failed with status code: " + response.code());
                    }
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
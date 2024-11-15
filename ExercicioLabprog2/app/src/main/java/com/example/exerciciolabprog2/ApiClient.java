package com.example.exerciciolabprog2;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class ApiClient {
    private static final String BASE_URL = "http://10.0.2.2:8080/";
    private OkHttpClient client;
    private TokenManager tokenManager;

    public ApiClient(Context context) {
        tokenManager = new TokenManager(context);
        client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder();

                    String token = tokenManager.getToken();
                    if (token != null) {
                        requestBuilder.header("Authorization", "Bearer " + token);
                    }

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                })
                .build();
    }

    public void getAccounts(Callback callback) {
        Request request = new Request.Builder()
                .url(BASE_URL + "accounts/userId/" + tokenManager.getUserId())
                .build();

        client.newCall(request).enqueue(callback);
    }

    public void postAccount(Account newAccount, Callback callback) {
        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("accountNumber", newAccount.getAccountNumber());
            jsonObject.put("userId", tokenManager.getUserId());
            jsonObject.put("bankName", newAccount.getBankName());
            jsonObject.put("accountBalance", newAccount.getAccountBalance());

            RequestBody body = RequestBody.create(jsonObject.toString(), MediaType.parse("application/json"));
            Request request = new Request.Builder()
                    .url(BASE_URL + "accounts")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(callback);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

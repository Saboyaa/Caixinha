package com.example.exerciciolabprog2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SaldoFragment extends Fragment {
    private Context context;
    private TokenManager tokenManager;
    private ApiClient apiClient;
    private ArrayList<Account> accounts = new ArrayList<>();
    private AccountAdapter accountAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saldo, container, false);

        tokenManager = new TokenManager(context);
        apiClient = new ApiClient(context);

        TextView tvWelcome = view.findViewById(R.id.tvWelcome);
        String text = tvWelcome.getText().toString();
        tvWelcome.setText(text + tokenManager.getUsername());

        RecyclerView rvContas = view.findViewById(R.id.rvContas);
        rvContas.setLayoutManager(new LinearLayoutManager(getContext()));

        accountAdapter = new AccountAdapter(accounts);
        rvContas.setAdapter(accountAdapter);

        loadAccounts();

        return view;
    }

    private void loadAccounts() {
        apiClient.getAccounts(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                getActivity().runOnUiThread(() -> {
                    Toast.makeText(getContext(), "Falha na requisição de dados", Toast.LENGTH_SHORT).show();
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String jsonResponse = response.body().string();

                    try {
                        JSONArray jsonArray = new JSONArray(jsonResponse);

                        getActivity().runOnUiThread(() -> {
                            accounts.clear();
                            accountAdapter.notifyDataSetChanged();
                        });

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject accountJson = jsonArray.getJSONObject(i);
                            Account account = new Account(
                                    accountJson.getString("accountNumber"),
                                    accountJson.getString("bankName"),
                                    BigDecimal.valueOf(accountJson.getDouble("accountBalance"))
                            );

                            getActivity().runOnUiThread(() -> {
                                accounts.add(account);
                                accountAdapter.notifyItemInserted(accounts.size() - 1);
                            });
                        }
                    } catch (JSONException e) {
                        getActivity().runOnUiThread(() -> {
                            Toast.makeText(getContext(), "Erro na análise do JSON", Toast.LENGTH_SHORT).show();
                        });
                    }
                } else {
                    getActivity().runOnUiThread(() -> {
                        Toast.makeText(getContext(), "Erro na resposta: " + response.code(), Toast.LENGTH_SHORT).show();
                    });
                }
            }
        });
    }
}
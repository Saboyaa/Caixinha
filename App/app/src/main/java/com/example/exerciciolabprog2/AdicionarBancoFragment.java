package com.example.exerciciolabprog2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.math.BigDecimal;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class AdicionarBancoFragment extends Fragment implements View.OnClickListener{

    private Context context;
    private Spinner spinnerBancos;
    private TextInputEditText accountNumberInput;
    private TextInputEditText accountBalanceInput;
    private Button addAccount;
    private ApiClient apiClient;

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adicionar_banco, container, false);

        accountNumberInput = (TextInputEditText) view.findViewById(R.id.textInputAccountNumber);
        accountBalanceInput = (TextInputEditText) view.findViewById(R.id.textInputAccountBalance);
        spinnerBancos = (Spinner) view.findViewById(R.id.spinner_bancos);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.bancos_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBancos.setAdapter(adapter);

        addAccount = (Button) view.findViewById(R.id.button);
        addAccount.setOnClickListener( this );

        apiClient = new ApiClient(context);

        return view;
    }

    @Override
    public void onClick(View view) {

        String accountNumber = accountNumberInput.getText().toString();
        BigDecimal accountBalance = BigDecimal.valueOf(Double.parseDouble(accountBalanceInput.getText().toString()));
        String bankName = spinnerBancos.getSelectedItem().toString();

        Account account = new Account(accountNumber, bankName, accountBalance);

        apiClient.postAccount(account, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                getActivity().runOnUiThread(() -> {
                    Toast.makeText(getContext(), "Falha na conexão", Toast.LENGTH_SHORT).show();
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful() && getActivity() != null) {
                    getActivity().runOnUiThread(() -> {
                        accountBalanceInput.setText("");
                        accountNumberInput.setText("");
                        spinnerBancos.setSelection(0);
                        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                        navController.navigate(R.id.saldoFragment);
                    });
                } else {
                    getActivity().runOnUiThread(() -> {
                        Toast.makeText(getContext(), "Falha na requisição de dados", Toast.LENGTH_SHORT).show();
                    });
                }
            }
        });
    }
}

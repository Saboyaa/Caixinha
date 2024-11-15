package com.example.exerciciolabprog2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SaldoFragment extends Fragment {

    public SaldoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate o layout para o fragmento
        View view = inflater.inflate(R.layout.fragment_saldo, container, false);

        // Configure o RecyclerView
        RecyclerView rvContas = view.findViewById(R.id.rvContas); // Use "view" para acessar o findViewById
        rvContas.setLayoutManager(new LinearLayoutManager(getContext())); // Use "getContext()" no Fragment

        // Exemplo de lista de contas
        List<Conta> listaDeContas = new ArrayList<>();
        listaDeContas.add(new Conta("11111", "Caixa Econômica", 1500.0));
        listaDeContas.add(new Conta("22222", "Banco do Brasil", 2000.0));

        // Configurar o Adapter
        ContaAdapter adapter = new ContaAdapter(listaDeContas);
        rvContas.setAdapter(adapter);

        return view; // Retorne a view criada
    }

}

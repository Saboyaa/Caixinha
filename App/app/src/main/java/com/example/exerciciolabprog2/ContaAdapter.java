package com.example.exerciciolabprog2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContaAdapter extends RecyclerView.Adapter<ContaAdapter.ContaViewHolder> {

    private List<Conta> contas;

    public ContaAdapter(List<Conta> contas) {
        this.contas = contas;
    }

    @NonNull
    @Override
    public ContaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conta, parent, false);
        return new ContaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContaViewHolder holder, int position) {
        Conta conta = contas.get(position);
        holder.tvNumeroConta.setText(conta.getNumeroConta());
        holder.tvBanco.setText(conta.getBanco());
        holder.tvSaldo.setText(String.format("R$%.2f", conta.getSaldo()));
    }

    @Override
    public int getItemCount() {
        return contas.size();
    }

    public static class ContaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNumeroConta, tvBanco, tvSaldo;

        public ContaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNumeroConta = itemView.findViewById(R.id.tvNumeroConta);
            tvBanco = itemView.findViewById(R.id.tvBanco);
            tvSaldo = itemView.findViewById(R.id.tvSaldo);
        }
    }
}

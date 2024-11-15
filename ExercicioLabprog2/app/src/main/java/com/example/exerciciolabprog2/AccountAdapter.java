package com.example.exerciciolabprog2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ContaViewHolder> {

    private ArrayList<Account> accounts;

    public AccountAdapter(ArrayList accounts) {
        this.accounts = accounts;
    }

    @NonNull
    @Override
    public ContaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conta, parent, false);
        return new ContaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContaViewHolder holder, int position) {
        Account account = (Account) accounts.get(position);
        holder.tvAccountNumber.setText(account.getAccountNumber());
        holder.tvBankName.setText(account.getBankName());
        holder.tvAccountBalance.setText(String.format("R$%.2f", account.getAccountBalance()));
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public static class ContaViewHolder extends RecyclerView.ViewHolder {
        TextView tvAccountNumber, tvBankName, tvAccountBalance;

        public ContaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAccountNumber = itemView.findViewById(R.id.tvNumeroConta);
            tvBankName = itemView.findViewById(R.id.tvBanco);
            tvAccountBalance = itemView.findViewById(R.id.tvSaldo);
        }
    }
}

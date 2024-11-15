package com.example.exerciciolabprog2;

public class Conta {
    private String numeroConta;
    private String banco;
    private double saldo;

    public Conta(String numeroConta, String banco, double saldo) {
        this.numeroConta = numeroConta;
        this.banco = banco;
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getBanco() {
        return banco;
    }

    public double getSaldo() {
        return saldo;
    }
}


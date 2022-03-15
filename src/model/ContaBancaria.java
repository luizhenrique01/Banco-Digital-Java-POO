package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public abstract class ContaBancaria {

    protected String agencia;

    protected String conta;

    protected int digito;

    protected double saldo;

    protected final double VALOR_MINIMO_DEPOSITO = 10.0; // valor global minimo de deposito

    protected final Date DataAbertura;

    // somente essa classe e os filhos poderam utilizar com o protect
    protected ArrayList<Movimentacao> movimentacoes;

    //construtores

    public ContaBancaria(String agencia, String conta, int digito, double saldoInicial) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.saldo = saldoInicial;
        this.DataAbertura = new Date(); //data e hora atual da maquina

        // arraylist movimentacao
        this.movimentacoes = new ArrayList<Movimentacao>(); //instanciando arraylist
        Movimentacao movimentacao = new Movimentacao("Abertura de conta", saldoInicial);
        this.movimentacoes.add(movimentacao); //salvando movimentacao dentro do array de movimentacoes

    }

    // getter and setters

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public double getSaldo() { //saldo sem set
        return saldo;
    }

    public Date getDataAbertura() { //data sem set, ira ser setado no momento de construção da conta
        return DataAbertura;
    }

    // metodos

    public void depositar(Double valor){ // deposito na conta com regra de negocio
        if (valor < VALOR_MINIMO_DEPOSITO) { //verificacao de valor minimo de deposito
            throw new InputMismatchException("O valor minimo de deposito é: R$" + VALOR_MINIMO_DEPOSITO);
        }
            this.saldo += valor;

        //movimentacao no extrato
        Movimentacao movimentacao = new Movimentacao("Deposito", valor);
        this.movimentacoes.add(movimentacao);

    }

    public Double sacar(Double valor){
        if (valor > this.saldo){ //verifica se o valor e maior que o saldo da conta
            throw new InputMismatchException("O saldo e insuficiente");
        }

        this.saldo -= valor;

        Movimentacao movimentacao = new Movimentacao("Saque", valor);
        this.movimentacoes.add(movimentacao);

        return valor;
    }

    public void transferir(Double valor, ContaBancaria contaDestino){
        //efetua um saque na conta atual
        this.sacar(valor); //se a verificacao foi feita com sucesso

        contaDestino.depositar(valor);

    }

    // metodo abstract e um metodo para heranca, que obriga as classes implementarem esse metodo
    public abstract void imprimirExtrato();
}

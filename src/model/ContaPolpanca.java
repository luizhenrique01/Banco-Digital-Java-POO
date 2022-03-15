package model;

import utils.DataUtil;

import java.util.Date;

public class ContaPolpanca extends ContaBancaria{
    public ContaPolpanca(String agencia, String conta, int digito, double saldoInicial) {
        super(agencia, conta, digito, saldoInicial);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("**********************");
        System.out.println("** Extrato Poupança **");
        System.out.println("**********************\n");
        System.out.println("Gerado em: " + DataUtil.converterDateParaDataEHora(new Date()) + "\n");

        for (Movimentacao movimentacao:
                this.movimentacoes) {
            System.out.println(movimentacao + "\n");
        }
        System.out.println("**********************");
    }
}

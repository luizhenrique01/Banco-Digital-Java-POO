package com.lhuizito.notebook;


import model.ContaCorrente;
import model.ContaPolpanca;
import utils.DataUtil;

public class Main {

    public static void main(String[] args) {
        System.out.println("Criando banco digital\n");

        ContaCorrente conta = new ContaCorrente("0001", "3213", 5, 100.0);

        System.out.println("Saldo atual de: " + conta.getSaldo() + "\n");

        conta.depositar(250.0);

        System.out.println("Saldo atual de: " + conta.getSaldo() + "\n");

        double saque = conta.sacar(150.0);

        System.out.println("Saldo atual de: " + conta.getSaldo() + "\n");

        ContaPolpanca conta2 = new ContaPolpanca("321321","3",2, 200.0);

        conta2.transferir(100.0, conta);
        System.out.println("Saldo conta destino: " + conta2.getSaldo() + "\n");
        System.out.println("Saldo atual de: " + conta.getSaldo() + "\n");
        System.out.println(conta2.getDataAbertura()); //data sem tratameto


        String dataEHoraAgora = DataUtil.converterDateParaDataEHora(conta2.getDataAbertura());
        String dataAgora = DataUtil.converterDateParaData(conta2.getDataAbertura());
        String horaAgora = DataUtil.converterDateHora(conta2.getDataAbertura());
        System.out.println(dataEHoraAgora);
        System.out.println(dataAgora);
        System.out.println(horaAgora);

        // extrato bancario
        // ter um objeto de movimentação
        // lista de movimentacao

        // conta 1 = conta corrente
        // conta 2 = conta polpanca
        conta.imprimirExtrato();
        conta2.imprimirExtrato();


    }




}
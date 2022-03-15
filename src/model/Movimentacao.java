package model;

import utils.DataUtil;

import java.util.Date;

public class Movimentacao {

    private String descricao;

    private final Date data;

    private final Double valor;

    public Movimentacao(String descricao, Double valor) {
        this.descricao = descricao;
        this.data = new Date();
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString(){
        //return descricao /n data-hora valor
        String dataFormatada = DataUtil.converterDateParaDataEHora(this.getData());
        return this.getDescricao() + "\n" + dataFormatada + "- R$" + this.valor;
    }

}

package br.com.avantitecnologiati.condmanager.model;

import java.util.Date;

public class Despesa {
    private String idDespesa;
    private String descricao;
    private double valor;
    private Date dataDeVencimento;
    private String tipoDespesa;
    private Divida statusDaDespesa;

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Despesa(String idDespesa, String descricao, double valor, Date dataDeVencimento, Divida statusDaDespesa) {
        this.idDespesa = idDespesa;
        this.descricao = descricao;
        this.valor = valor;
        this.dataDeVencimento = dataDeVencimento;
        this.statusDaDespesa = statusDaDespesa;
    }

    public String getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(String idDespesa) {
        this.idDespesa = idDespesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(Date dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public Divida getStatusDaDespesa() {
        return statusDaDespesa;
    }

    public void setStatusDaDespesa(Divida statusDaDespesa) {
        this.statusDaDespesa = statusDaDespesa;
    }
}

package br.com.avantitecnologiati.condmanager.model;

public class Despesa {
    private String idDespesa;
    private String descricao;
    private double valor;
    private int tipoDespesa;

    public Despesa(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(String idDespesa) {
        this.idDespesa = idDespesa;
    }


    public int getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(int tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
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

    public boolean getRateada(){
        return this.tipoDespesa == TipoDespesa.FIXA.getValue();
    }

}

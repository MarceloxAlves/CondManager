package br.com.avantitecnologiati.condmanager.model;

import java.util.Date;

public class ItemDespesa {
    private Despesa despesa;
    private double valor;
    private Apartamento apartamento;

    public ItemDespesa(Despesa despesa, Apartamento apartamento) {
        this.despesa = despesa;
        this.apartamento = apartamento;
        setValorReal(apartamento.getQuantQuartos());
    }

    private void setValorReal(int quantidadeQuartos) {
        if(this.despesa.getTipoDespesa() == TipoDespesa.FIXA.getValue())
            this.valor = this.despesa.getValor() / quantidadeQuartos * this.apartamento.getQuantQuartos();
        else
             this.valor =  this.despesa.getValor();
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public double getValor() {
        return valor;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }
}

package br.com.avantitecnologiati.condmanager.model;

import java.util.List;

public class Apartamento {
    private int numero;
    private int quantQuartos;
    private int tipoOcupacao;
    private Proprietario proprietario;


    public  Apartamento(){

    }

    public Apartamento(int numero, int quantQuartos, Ocupacao tipoOcupacao, Proprietario proprietario) {
        this.numero = numero;
        this.quantQuartos = quantQuartos;
        this.tipoOcupacao = tipoOcupacao.getTipoOcupacao();
        this.proprietario = proprietario;
    }

    public int getNumero() {
        return numero;
    }

    public int getQuantQuartos() {
        return quantQuartos;
    }

    public void setQuantQuartos(int quantQuartos) {
        this.quantQuartos = quantQuartos;
    }

    public int getTipoOcupacao() {
        return tipoOcupacao;
    }

    public void setTipoOcupacao(int tipoOcupacao) {
        this.tipoOcupacao = tipoOcupacao;
    }

    public double getValorCondominio(){
        double valor = 0;

        return valor;
    }


}

package br.com.avantitecnologiati.condmanager.model;

import java.util.List;

public class Apartamento {
    private int numero;
    private int quantQuartos;
    private Ocupacao tipoOcupacao;
    private Proprietario proprietario;

    public Apartamento(int numero, int quantQuartos, Ocupacao tipoOcupacao, Proprietario proprietario) {
        this.numero = numero;
        this.quantQuartos = quantQuartos;
        this.tipoOcupacao = tipoOcupacao;
        this.proprietario = proprietario;
    }

    public int getNumero() {
        return numero;
    }

    public int getQuantQuartos() {
        return quantQuartos;
    }

    public Ocupacao getTipoOcupacao() {
        return tipoOcupacao;
    }

    public void setTipoOcupacao(Ocupacao tipoOcupacao) {
        this.tipoOcupacao = tipoOcupacao;
    }

    public double getValorCondominio(){
        double valor = 0;

        return valor;
    }


}

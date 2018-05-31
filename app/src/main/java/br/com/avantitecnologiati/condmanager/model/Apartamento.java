package br.com.avantitecnologiati.condmanager.model;

import java.util.List;

public class Apartamento {
    private int numero;
    private int quantQuartos;
    private Ocupacao tipoOcupacao;
    private Proprietario proprietario;
    private List<FaturaCondominio> faturaCondominios;

    public Apartamento(int numero, int quantQuartos, Ocupacao tipoOcupacao, Proprietario proprietario) {
        this.numero = numero;
        this.quantQuartos = quantQuartos;
        this.tipoOcupacao = tipoOcupacao;
        this.proprietario = proprietario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantQuartos() {
        return quantQuartos;
    }

    public void setQuantQuartos(int quantQuartos) {
        this.quantQuartos = quantQuartos;
    }

    public Ocupacao getTipoOcupacao() {
        return tipoOcupacao;
    }

    public void setTipoOcupacao(Ocupacao tipoOcupacao) {
        this.tipoOcupacao = tipoOcupacao;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public void adicionarFaturaCondominio(FaturaCondominio faturaCondominio){
        if (FaturaCondominio.validarReferencia(this,faturaCondominio.getReferencia()))
             this.faturaCondominios.add(faturaCondominio);
    }


    public List<FaturaCondominio> getFaturas() {
            return  this.faturaCondominios;
    }
}

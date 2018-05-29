package br.com.avantitecnologiati.condmanager.model;

import java.util.List;

public class Condominio {
    private int idCond;
    private String nomeCond;
    private List<Apartamento> apartamentos;
    private int qtddAp = 0;

    public Condominio(int idCond, String nomeCond, List<Apartamento> apartamentos, int qtddAp) {
        this.idCond = idCond;
        this.nomeCond = nomeCond;
        this.apartamentos = apartamentos;
        this.qtddAp = qtddAp;
    }

    public int getIdCond() {
        return idCond;
    }

    public void setIdCond(int idCond) {
        this.idCond = idCond;
    }

    public String getNomeCond() {
        return nomeCond;
    }

    public void setNomeCond(String nomeCond) {
        this.nomeCond = nomeCond;
    }

    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(List<Apartamento> apartamentos) {
        this.apartamentos = apartamentos;
    }

    public int getQtddAp() {
        return qtddAp;
    }

    public void setQtddAp(int qtddAp) {
        this.qtddAp = qtddAp;
    }
}
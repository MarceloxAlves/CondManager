package br.com.avantitecnologiati.condmanager.model;
import java.util.ArrayList;
import java.util.List;

public class Condominio {
    private int idCond;
    private String nomeCond;
    private List<Apartamento> apartamentos;

    public Condominio(String nomeCond) {
        this.nomeCond = nomeCond;
        this.apartamentos = new ArrayList<>();
    }

    public int getIdCond() {
        return idCond;
    }

    public String getNomeCond() {
        return nomeCond;
    }

    public void setIdCond(int idCond) {
        this.idCond = idCond;
    }

    public void setNomeCond(String nomeCond) {
        this.nomeCond = nomeCond;
    }


    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public void adicionarApartamento(Apartamento apartamento) {
        this.apartamentos.add(apartamento);
    }


    public int quantidadeQuartos(){
        int totalQuartos = 0;
        for (Apartamento apartamento:  getApartamentos()) {
            totalQuartos += apartamento.getQuantQuartos();
        }
        return totalQuartos;
    }



    public void adicionarDespesaApartamento(){

    }


}
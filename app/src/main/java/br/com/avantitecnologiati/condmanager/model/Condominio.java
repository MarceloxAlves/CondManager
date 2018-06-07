package br.com.avantitecnologiati.condmanager.model;
import java.util.ArrayList;
import java.util.List;

public class Condominio {
    private int idCond;
    private String nomeCond;
    private List<Apartamento> apartamentosCond;

    public Condominio(String nomeCond) {
        this.nomeCond = nomeCond;
        this.apartamentosCond = new ArrayList<>();
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
        return apartamentosCond;
    }

    public void adicionarApartamentoCondominio(Apartamento apartamento) {
        this.apartamentosCond.add(apartamento);
    }

    public int quantidadeQuartosCondominio(){
        int totalQuartos = 0;
        for (Apartamento apartamento:  getApartamentos()) {
            totalQuartos += apartamento.getQuantQuartos();
        }
        return totalQuartos;
    }

}
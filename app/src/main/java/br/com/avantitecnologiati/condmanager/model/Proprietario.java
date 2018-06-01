package br.com.avantitecnologiati.condmanager.model;

import java.util.List;

public class Proprietario extends Pessoa {
    private List<Apartamento> apartamentos;


    public Proprietario() {
        super(null, null);
    }

    public Proprietario(String nome, String cpf) {
        super(nome, cpf);
    }

    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }
}
package br.com.avantitecnologiati.condmanager.model;

import java.util.List;

public class Proprietario extends Pessoa implements Usuario {
    private List<Apartamento> apartamentos;

    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }
}
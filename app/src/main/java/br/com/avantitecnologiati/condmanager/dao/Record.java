package br.com.avantitecnologiati.condmanager.dao;

import java.util.List;

public abstract class Record {

    private Database database;

    public Database getDatabase() {
        return database;
    }

    public Record(Database database) {
        this.database = database;
    }

   // public abstract void adicionar();

    public abstract List<?> listar();
}

package br.com.avantitecnologiati.condmanager.model;

public abstract class Pessoa{
    private String uid;
    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getUid() {
        return uid;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}

package br.com.avantitecnologiati.condmanager.model;

public class Sindico extends Pessoa implements Usuario {

    private String email, senha;

    public Sindico(String nome, String cpf, String email, String senha) {
        super(nome, cpf);
        this.email = email;
        this.senha = senha;
    }


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getSenha() {
        return senha;
    }
}

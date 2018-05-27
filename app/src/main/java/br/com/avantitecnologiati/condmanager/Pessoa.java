package br.com.avantitecnologiati.condmanager;

import java.util.UUID;

import br.com.avantitecnologiati.condmanager.dao.Registravel;

public class Pessoa implements Registravel {
     private String uid;
     private String nome;
     private String email;

     public Pessoa(String nome, String email) {
         this.uid = UUID.randomUUID().toString();
         this.nome = nome;
         this.email = email;
     }

    public String getUid() {
        return uid;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getTag() {
        return "Pessoa";
    }
}

package br.com.avantitecnologiati.condmanager.dao;

import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.avantitecnologiati.condmanager.model.Sindico;

public class SindicoRecord extends Record {

    private final String TAG = "Sindico";
    private boolean logado;
    private Sindico sindico;

    public SindicoRecord(Database database) {
        super(database);
    }

    public void adicionar(Sindico sindico){
        getDatabase().getDatabaseReference().child(TAG).child(sindico.getCpf()).setValue(sindico);
    }


    public List<Sindico> listar(){
        final List<Sindico> registros = new ArrayList<>();
        getDatabase().getDatabaseReference().child(TAG).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot ) {
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()) {
                    Sindico Sindico = objSnapshot.getValue(Sindico.class);
                    registros.add(Sindico);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return registros;
    }


    public boolean logado(String email, String senha){
        getDatabase().getDatabaseReference()
                .child(TAG)
                .addValueEventListener(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()) {
                                    Sindico objeto = objSnapshot.getValue(Sindico.class);

                                    if(objeto.getEmail().equalsIgnoreCase(email)){
                                        if ((objeto.getSenha().trim().compareTo(senha)) == 0){
                                            logado = true;
                                        }

                                    }
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        }
                );
        return logado;
    }

    public Sindico getObject(String chave, @Nullable String field){
        sindico = null;
        getDatabase().getDatabaseReference()
                .child(TAG)
                .addValueEventListener(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()) {
                                    Sindico objeto = objSnapshot.getValue(Sindico.class);
                                     switch(field){
                                         case "cpf":
                                             if(sindico.getEmail().equalsIgnoreCase(chave)){
                                                 sindico = objeto;
                                                 break;
                                             }
                                        default:
                                            if(sindico.getEmail().equalsIgnoreCase(chave)){
                                                sindico = objeto;
                                                break;
                                            }
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        }
                );

        return sindico;
    }

}

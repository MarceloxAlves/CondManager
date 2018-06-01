package br.com.avantitecnologiati.condmanager.dao;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.avantitecnologiati.condmanager.model.Sindico;

public class SindicoRecord {

    private Database database;

    public SindicoRecord(Database database) {
        this.database = database;
    }

    public void adicionar(Sindico sindico){
        database.getDatabaseReference().child("Sindico").child(sindico.getCpf()).setValue(sindico);
    }

    public List<Sindico> listar(){
        final List<Sindico> registros = new ArrayList<>();
        database.getDatabaseReference().child("Sindico").addValueEventListener(new ValueEventListener() {
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

}

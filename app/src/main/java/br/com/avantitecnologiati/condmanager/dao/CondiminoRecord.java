package br.com.avantitecnologiati.condmanager.dao;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.avantitecnologiati.condmanager.model.Condominio;
import br.com.avantitecnologiati.condmanager.model.Sindico;

public class CondiminoRecord extends Record {


    public CondiminoRecord(Database database) {
        super(database);
    }


    public List<Condominio> listar(){
        final List<Condominio> registros = new ArrayList<>();
        getDatabase().getDatabaseReference().child("Condominio").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot ) {
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()) {
                    Condominio condominio = objSnapshot.getValue(Condominio.class);
                    registros.add(condominio);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return registros;
    }


}

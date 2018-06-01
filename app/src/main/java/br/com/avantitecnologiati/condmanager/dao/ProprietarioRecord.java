package br.com.avantitecnologiati.condmanager.dao;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.avantitecnologiati.condmanager.model.Proprietario;

public class ProprietarioRecord  extends  Record{

    private Database database;

    public ProprietarioRecord(Database database) {
        super(database);
    }


    public void adicionar(){

    }

    public List<Proprietario> listar(){
        final List<Proprietario> registros = new ArrayList<>();
        database.getDatabaseReference().child("Proprietario").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot ) {
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()) {
                    Proprietario proprietario = objSnapshot.getValue(Proprietario.class);
                    registros.add(proprietario);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return registros;
    }


}

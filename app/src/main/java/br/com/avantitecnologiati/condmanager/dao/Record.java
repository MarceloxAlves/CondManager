package br.com.avantitecnologiati.condmanager.dao;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.avantitecnologiati.condmanager.Pessoa;

public class Record {

    private Database database;
    private Registravel registravel;

    public Record(Database database, Registravel registravel) {
        this.database = database;
        this.registravel = registravel;
    }

    public void adicionar(){

    }

    public List<Registravel> listar(){
        final List<Registravel> registros = new ArrayList<>();
        database.getDatabaseReference().child(registravel.getTag()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot ) {
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()) {
                    Registravel registravel = objSnapshot.getValue(Registravel.class);
                    registros.add(registravel);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return registros;
    }

}

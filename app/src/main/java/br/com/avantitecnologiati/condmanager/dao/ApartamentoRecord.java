package br.com.avantitecnologiati.condmanager.dao;

import android.support.annotation.Nullable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.avantitecnologiati.condmanager.model.Apartamento;
import br.com.avantitecnologiati.condmanager.model.Apartamento;

public class ApartamentoRecord extends Record {

    private final String TAG = "Apartamento";
    private boolean logado;
    private Apartamento apartamento;

    public ApartamentoRecord(Database database) {
        super(database);
    }

    public void adicionar(Apartamento apartamento){
        getDatabase().getDatabaseReference().child(TAG).child(String.valueOf(apartamento.getNumero())).setValue(apartamento);
    }

    public List<Apartamento> listar(){
        final List<Apartamento> registros = new ArrayList<>();
        getDatabase().getDatabaseReference().child(TAG).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot ) {
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()) {
                    Apartamento apartamento = objSnapshot.getValue(Apartamento.class);
                    registros.add(apartamento);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return registros;
    }



    public Apartamento getObject(String numero){
        apartamento = null;
        getDatabase().getDatabaseReference()
                .child(TAG)
                .addValueEventListener(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()) {
                                    Apartamento objeto = objSnapshot.getValue(Apartamento.class);
                                    if (objeto.getNumero() ==  Integer.valueOf(numero)){
                                        apartamento = objeto;
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        }
                );

        return apartamento;
    }

}

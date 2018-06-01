package br.com.avantitecnologiati.condmanager.dao;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.avantitecnologiati.condmanager.model.Proprietario;

public class ProprietarioRecord  extends  Record{
    private final String TAG = "Proprietario";

    public ProprietarioRecord(Database database) {
        super(database);
    }


    public void adicionar(Proprietario proprietario){
        getDatabase().getDatabaseReference().child(TAG).child(String.valueOf(proprietario.getCpf())).setValue(proprietario);
    }

    public List<Proprietario> listar(){
        final List<Proprietario> registros = new ArrayList<>();
        getDatabase().getDatabaseReference().child(TAG).addValueEventListener(new ValueEventListener() {
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

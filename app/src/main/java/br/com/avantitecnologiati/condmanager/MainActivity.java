package br.com.avantitecnologiati.condmanager;

import android.app.Activity;
import android.os.Bundle;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.avantitecnologiati.condmanager.model.Pessoa;
import br.com.avantitecnologiati.condmanager.model.Proprietario;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        Pessoa pessoa = new Proprietario("Marcelo Alves", "1000");

        databaseReference.child("Pessoa").child(pessoa.getUid()).setValue(pessoa);

    }
}

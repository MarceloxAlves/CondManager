package br.com.avantitecnologiati.condmanager.dao;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    public Database(Context context) {
        FirebaseApp.initializeApp(context);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }
}

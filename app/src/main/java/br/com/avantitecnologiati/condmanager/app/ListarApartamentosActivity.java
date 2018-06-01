package br.com.avantitecnologiati.condmanager.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import br.com.avantitecnologiati.condmanager.R;


import br.com.avantitecnologiati.condmanager.R;
import br.com.avantitecnologiati.condmanager.adapter.ApartamentoAdapter;
import br.com.avantitecnologiati.condmanager.dao.ApartamentoRecord;
import br.com.avantitecnologiati.condmanager.dao.Database;
import br.com.avantitecnologiati.condmanager.model.Apartamento;

public class ListarApartamentosActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ApartamentoAdapter apartamentoAdapter;
    ApartamentoRecord apartamentoRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_apartamentos);
        recyclerView = findViewById(R.id.rv_apartamentos);
        apartamentoRecord = new ApartamentoRecord(new Database(this));
        apartamentoAdapter = new ApartamentoAdapter(this,apartamentoRecord.listar());

    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setAdapter(apartamentoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    public void novoApartamento(View view) {
            startActivity(new Intent(this, AdicionarApartamentoActivity.class));
    }
}

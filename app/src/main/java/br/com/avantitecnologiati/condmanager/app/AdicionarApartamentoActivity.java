package br.com.avantitecnologiati.condmanager.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.avantitecnologiati.condmanager.R;
import br.com.avantitecnologiati.condmanager.dao.ApartamentoRecord;
import br.com.avantitecnologiati.condmanager.dao.Database;
import br.com.avantitecnologiati.condmanager.dao.ProprietarioRecord;
import br.com.avantitecnologiati.condmanager.helper.ValidateTextView;
import br.com.avantitecnologiati.condmanager.model.Apartamento;
import br.com.avantitecnologiati.condmanager.model.Ocupacao;

public class AdicionarApartamentoActivity extends AppCompatActivity {

    ApartamentoRecord apartamentoRecord;
    ProprietarioRecord proprietarioRecord;
    EditText txtNumero, txtQtQuartos;
    Spinner spinnerProprietarios;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_apartamento);

        txtNumero = findViewById(R.id.numero_apartamento);
        txtQtQuartos = findViewById(R.id.quantidade_quartos);
        spinnerProprietarios = findViewById(R.id.proprietarios);
        radioGroup = findViewById(R.id.rd_opcoes);
        apartamentoRecord = new ApartamentoRecord(new Database(this));
    }

    public void salvarApartamento(View view) {
        Apartamento apartamento = new Apartamento();
        apartamento.setNumero(Integer.valueOf(ValidateTextView.validate(txtNumero)));
        apartamento.setQuantQuartos(Integer.valueOf(ValidateTextView.validate(txtQtQuartos)));
        apartamento.setTipoOcupacao(Ocupacao.PROPIETARIO.getTipoOcupacao());
        apartamentoRecord.adicionar(apartamento);
        Toast.makeText(this, "Apartamento adicionado com Sucesso!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,ListarApartamentosActivity.class));
        finish();

    }
}

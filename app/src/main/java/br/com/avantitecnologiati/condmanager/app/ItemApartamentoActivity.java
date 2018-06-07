package br.com.avantitecnologiati.condmanager.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.avantitecnologiati.condmanager.R;
import br.com.avantitecnologiati.condmanager.model.Apartamento;

public class ItemApartamentoActivity extends AppCompatActivity {

    private Apartamento apartamento;
    private TextView proprietarioText, numeroApartamenoText, numeroDeQuartosText, ocupacaoText, situacaoText, dividaText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_apartamento);
        setupViews();
    }

    private void setupViews() {
        proprietarioText = findViewById(R.id.apartamento_proprietario_text);
        numeroApartamenoText = findViewById(R.id.numero_apartamento_text);
        numeroDeQuartosText = findViewById(R.id.numero_de_quartos_text);
        ocupacaoText = findViewById(R.id.ocupacao_apartamento_text);
        situacaoText = findViewById(R.id.situacao_apartamento_text);
        dividaText = findViewById(R.id.divida_apartamento_text);
    }
}

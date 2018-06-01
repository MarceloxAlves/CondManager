package br.com.avantitecnologiati.condmanager.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.com.avantitecnologiati.condmanager.R;
import br.com.avantitecnologiati.condmanager.dao.Preferences;

public class PrincipalActivity extends AppCompatActivity {

    Preferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        preferences = new Preferences(this);
        ((TextView)findViewById(R.id.emailLogado)).setText(preferences.getEmailUsuarioLogado());


    }

    public void apartamentos(View view) {
        startActivity(new Intent(this, ListarApartamentosActivity.class));
    }
}

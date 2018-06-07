package br.com.avantitecnologiati.condmanager.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.avantitecnologiati.condmanager.R;
import br.com.avantitecnologiati.condmanager.dao.Database;
import br.com.avantitecnologiati.condmanager.dao.SindicoRecord;
import br.com.avantitecnologiati.condmanager.helper.Password;
import br.com.avantitecnologiati.condmanager.helper.ValidateTextView;
import br.com.avantitecnologiati.condmanager.model.Sindico;

public class CadastroActivity extends AppCompatActivity {


    EditText txtNome, txtCPF, txtTelefone, txtEmail, txtSenha, txtConfirm;
    SindicoRecord sindicoRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        setupViews();

    }

    public void cadastrar(View view) {
        try {
            if(!ValidateTextView.compare(txtSenha, txtConfirm)) throw new IllegalArgumentException("Confirmação de senha inválida");
            Sindico sindico = new Sindico(
                ValidateTextView.validate(txtNome),
                ValidateTextView.validate(txtCPF),
                ValidateTextView.validate(txtEmail),
                Password.codificar(ValidateTextView.validate(txtSenha))
            );

            sindico.setTelefone(txtTelefone.getText().toString());
            sindicoRecord.adicionar(sindico);
            Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

        }catch (Exception exeption){
            Toast.makeText(this, "Info: "+exeption.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


    private void setupViews() {
        txtNome      = findViewById(R.id.edit_name);
        txtCPF       = findViewById(R.id.edit_cpf);
        txtTelefone  = findViewById(R.id.edit_telefone);
        txtEmail     = findViewById(R.id.edit_email);
        txtSenha     = findViewById(R.id.edit_password);
        txtConfirm   = findViewById(R.id.edit_confirm);
        sindicoRecord = new SindicoRecord(new Database(this));
    }
}

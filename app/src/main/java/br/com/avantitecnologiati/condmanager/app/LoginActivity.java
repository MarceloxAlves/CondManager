package br.com.avantitecnologiati.condmanager.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.avantitecnologiati.condmanager.R;
import br.com.avantitecnologiati.condmanager.dao.Database;
import br.com.avantitecnologiati.condmanager.dao.Preferences;
import br.com.avantitecnologiati.condmanager.dao.SindicoRecord;
import br.com.avantitecnologiati.condmanager.helper.Password;
import br.com.avantitecnologiati.condmanager.helper.ValidateTextView;

public class LoginActivity extends AppCompatActivity  {

    EditText password;
    EditText email;

    Button btnLogin;
    Button btnCadastrar;
    SindicoRecord sindicoRecord;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password = findViewById(R.id.edit_password);
        email = findViewById(R.id.edit_username);

        btnLogin = findViewById(R.id.login_btn);
        btnCadastrar = findViewById(R.id.cadastrar_btn);
        sindicoRecord = new SindicoRecord(new Database(this));

        checar();

        class Login extends AsyncTask<String, Void, Boolean>{
            @Override
            protected void onPreExecute() {
                progressDialog = ProgressDialog.show(LoginActivity.this, "Por favor Aguarde ...",
                        "Autenticando ...");
            }

            @Override
            protected Boolean doInBackground(String... strings) {
                return  sindicoRecord.logado(strings[0], strings[1]);

            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                progressDialog.dismiss();
                if (aBoolean){
                    Preferences preferences = new Preferences(getApplicationContext());
                    preferences.salvarUsuario(email.getText().toString());
                    startActivity(new Intent(getApplicationContext(), PrincipalActivity.class) );
                }else{
                    Toast.makeText(LoginActivity.this, "Falha ao logar", Toast.LENGTH_SHORT).show();
                }
                super.onPostExecute(aBoolean);
            }
        }

        btnLogin.setOnClickListener(v -> {
                    try {
                        Login login = new Login();
                        login.execute(ValidateTextView.validate(email), Password.codificar(ValidateTextView.validate(password)));

                    } catch (Exception exception) {
                        Toast.makeText(this, "Info "+ exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );


        btnCadastrar.setOnClickListener(
                v->{
                    startActivity(new Intent(this,CadastroActivity.class));
                }
        );
    }

    private void checar() {
        Preferences preferences= new Preferences(this);
        if (preferences.logado()){
            startActivity(new Intent(this, PrincipalActivity.class));
        }
    }
}

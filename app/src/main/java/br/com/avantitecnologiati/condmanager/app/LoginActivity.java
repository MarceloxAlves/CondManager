package br.com.avantitecnologiati.condmanager.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.com.avantitecnologiati.condmanager.R;
import br.com.avantitecnologiati.condmanager.helper.Password;

public class LoginActivity extends AppCompatActivity {

    EditText password;
    EditText email;

    Button btnLogin;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password = findViewById(R.id.edit_password);
        email = findViewById(R.id.edit_username);

        btnLogin = findViewById(R.id.login_btn);
        btnCadastrar = findViewById(R.id.cadastrar_btn);

        btnLogin.setOnClickListener(v -> {
                    try {
                        Toast.makeText(this, Password.codificar(password.getText().toString()), Toast.LENGTH_SHORT).show();
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
        );


        btnCadastrar.setOnClickListener(
                v->{
                    startActivity(new Intent(this,CadastroActivity.class));
                }
        );
    }
}

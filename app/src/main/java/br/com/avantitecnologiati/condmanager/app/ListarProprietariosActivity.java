package br.com.avantitecnologiati.condmanager.app;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.avantitecnologiati.condmanager.R;
import br.com.avantitecnologiati.condmanager.adapter.ProprietarioAdapter;
import br.com.avantitecnologiati.condmanager.dao.Database;
import br.com.avantitecnologiati.condmanager.dao.ProprietarioRecord;
import br.com.avantitecnologiati.condmanager.helper.ValidateTextView;
import br.com.avantitecnologiati.condmanager.model.Proprietario;

public class ListarProprietariosActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProprietarioAdapter proprietarioAdapter;
    ProprietarioRecord proprietarioRecord;

    EditText editNome, editCpf, editTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_proprietarios);
        recyclerView = findViewById(R.id.proprietarios_rv);
        proprietarioRecord = new ProprietarioRecord(new Database(this));
        atualizarAdpter();

    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setAdapter(proprietarioAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        proprietarioAdapter.notifyDataSetChanged();
    }


    public void adicionarProprietario(View view) {

        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View inflate = getLayoutInflater().inflate(R.layout.activity_cadastro_proprietario, null);

            editNome = inflate.findViewById(R.id.edit_name);
            editCpf = inflate.findViewById(R.id.edit_cpf);
            editTelefone = inflate.findViewById(R.id.edit_telefone);

            builder.setTitle("Adicionar Proprietário");
            builder.setIcon(getResources().getDrawable(R.drawable.icon_add));
            builder.setView(inflate)
                    .setPositiveButton("Salvar", (dialog, id) -> {
                        Proprietario proprietario = new Proprietario(
                                ValidateTextView.validate(editNome),
                                ValidateTextView.validate(editCpf)
                        );
                        proprietario.setTelefone(editTelefone.getText().toString());
                        proprietarioRecord.adicionar(proprietario);
                        Toast.makeText(this, "Proprietário Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
                        atualizarAdpter();
                    })
                    .setNegativeButton("Cancelar", (dialog, id) -> {


                    });
            builder.create();
            builder.show();
        }catch (Exception exception){
            Toast.makeText(this, "Info: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void atualizarAdpter() {
        proprietarioAdapter = new ProprietarioAdapter(this,proprietarioRecord.listar());
    }
}

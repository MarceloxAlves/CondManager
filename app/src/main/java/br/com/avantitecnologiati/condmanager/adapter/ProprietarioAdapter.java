package br.com.avantitecnologiati.condmanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.avantitecnologiati.condmanager.R;
import br.com.avantitecnologiati.condmanager.model.Apartamento;
import br.com.avantitecnologiati.condmanager.model.Ocupacao;
import br.com.avantitecnologiati.condmanager.model.Proprietario;

public class ProprietarioAdapter extends RecyclerView.Adapter<ProprietarioAdapter.ApartamentoViewHolder> {

    private Context context;
    private List<Proprietario> proprietarioList;

    public ProprietarioAdapter(Context context, List<Proprietario> proprietarioList){
        this.context = context;
        this.proprietarioList = proprietarioList;
    }

    @Override
    public ApartamentoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.activity_item_proprietario_view_holder, parent, false);

        return new ProprietarioAdapter.ApartamentoViewHolder(linha) ;
    }

    @Override
    public void onBindViewHolder(ApartamentoViewHolder holder, int position) {
        Proprietario proprietario = this.proprietarioList.get(position);
        holder.txtNome.setText("Nome: " + proprietario.getNome());
        holder.txtCpf.setText("CPF : "  + proprietario.getCpf());
        holder.txtTelefone.setText("Telefone : " + proprietario.getTelefone());
    }

    @Override
    public int getItemCount() {
        return this.proprietarioList.size();
    }

    public class ApartamentoViewHolder extends RecyclerView.ViewHolder{
        TextView txtNome, txtCpf, txtTelefone;
        public ApartamentoViewHolder(View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.nome_proprietario);
            txtCpf = itemView.findViewById(R.id.cpf_proprietario);
            txtTelefone = itemView.findViewById(R.id.telefone_proprieario);
        }

    }
}

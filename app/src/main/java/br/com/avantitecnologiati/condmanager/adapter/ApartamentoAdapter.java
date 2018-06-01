package br.com.avantitecnologiati.condmanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;

import br.com.avantitecnologiati.condmanager.R;
import br.com.avantitecnologiati.condmanager.model.Apartamento;

public class ApartamentoAdapter extends RecyclerView.Adapter<ApartamentoAdapter.ApartamentoViewHolder> {

    private Context context;
    private List<Apartamento> apartamentoList;

    public ApartamentoAdapter(Context context, List<Apartamento> apartamentoList){
        this.context = context;
        this.apartamentoList = apartamentoList;
    }

    @Override
    public ApartamentoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.activity_item_apartamento_view_holder, parent, false);

        return new ApartamentoAdapter.ApartamentoViewHolder(linha) ;
    }

    @Override
    public void onBindViewHolder(ApartamentoViewHolder holder, int position) {
        Apartamento apartamento = this.apartamentoList.get(position);
        holder.numeroApartamento.setText("Numero : " + apartamento.getNumero());
        holder.situacaoApartamento.setText("Situação : " + apartamento.getTipoOcupacao().toString());
        holder.proprietarioApartamento.setText("Proprietario : " + apartamento.getProprietario().getNome());
    }

    @Override
    public int getItemCount() {
        return this.apartamentoList.size();
    }

    public class ApartamentoViewHolder extends RecyclerView.ViewHolder{
        private EditText numeroApartamento, situacaoApartamento, proprietarioApartamento;
        public ApartamentoViewHolder(View itemView) {
            super(itemView);
            numeroApartamento = itemView.findViewById(R.id.Numero_apartamento);
            situacaoApartamento = itemView.findViewById(R.id.situacao_apartamento);
            proprietarioApartamento = itemView.findViewById(R.id.propietario_apartametno);
        }
    }
}

package br.com.avantitecnologiati.condmanager.model;

import java.util.Date;
import java.util.List;

public class FaturaCondominio {

    private Apartamento apartamento;
    private Date dataPagamento;
    private List<ItemDespesa> itemDespesas;
    private String referencia;

    public FaturaCondominio(Apartamento apartamento, String referencia) {
        this.apartamento = apartamento;
        this.referencia = referencia;
    }

    public  boolean adicionarItemDespesa(ItemDespesa itemDespesa) {
        return this.itemDespesas.add(itemDespesa);
    }

    public String getReferencia() {
        return referencia;
    }


    public static boolean validarReferencia(Apartamento apartamento, String referencia){
        for (FaturaCondominio faturaCondominio: apartamento.getFaturas()) {
            if (faturaCondominio.getReferencia().equalsIgnoreCase(referencia));
        }
        return true;
    }

}

package br.com.avantitecnologiati.condmanager.model;

public class Apartamento {
    private int numero;
    private int quantQuartos;
    private Ocupacao tipoOcupacao;
    private Proprietario proprietario;

    public Apartamento(int numero, int quantQuartos, Ocupacao tipoOcupacao, Proprietario proprietario) {
        this.numero = numero;
        this.quantQuartos = quantQuartos;
        this.tipoOcupacao = tipoOcupacao;
        this.proprietario = proprietario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantQuartos() {
        return quantQuartos;
    }

    public void setQuantQuartos(int quantQuartos) {
        this.quantQuartos = quantQuartos;
    }

    public Ocupacao getTipoOcupacao() {
        return tipoOcupacao;
    }

    public void setTipoOcupacao(Ocupacao tipoOcupacao) {
        this.tipoOcupacao = tipoOcupacao;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public double totalizarDespesas(Despesa despesa, Apartamento ap, Condominio condominio){
        double valor;

        if(despesa.getTipoDespesa().equals("fixa")){
            valor = despesa.getValor() / condominio.getQuantQuartosCond();
        }
        else
            valor = despesa.getValor();

        return valor;

    }



}

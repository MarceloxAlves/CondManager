package br.com.avantitecnologiati.condmanager.model;

public enum TipoDespesa {
     FIXA(1), VARIAVEL(2);
    private int tipoDespesa;
    TipoDespesa(int i) {
        tipoDespesa = i;
    }

    public int getValue() {
        return tipoDespesa;
    }
}

package br.com.avantitecnologiati.condmanager.model;

public enum TipoDespesa {
    //
     FIXA(1), VARIAVEL(2);
    private int tipoDespesa;
    TipoDespesa(int i) {
        tipoDespesa = i;
    }

    /***
     *
     * @return 1 fixa(rateavel), 2 variavel (ao acaso)
     */
    public int getValue() {
        return tipoDespesa;
    }
}

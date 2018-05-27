package br.com.avantitecnologiati.condmanager.model;

public enum Divida {
    EMDEBITO(0), VENCIDA(1), QUITADA(2);

    private int tipoDeDivida;

    Divida(int i) {
        tipoDeDivida = i;
    }

    public int getTipoDeDivida() {
        return tipoDeDivida;
    }
}

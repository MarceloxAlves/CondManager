package br.com.avantitecnologiati.condmanager.model;

public enum Ocupacao {
    PROPIETARIO(0), INQUILINO(1), VAZIO(2);

    private int tipoOcupacao;

    Ocupacao(int i) {
        tipoOcupacao = i;
    }

    public int getTipoOcupacao() {
        return tipoOcupacao;
    }
}

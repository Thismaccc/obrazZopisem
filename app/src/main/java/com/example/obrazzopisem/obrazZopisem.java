package com.example.obrazzopisem;

public class obrazZopisem extends Obraz{
    public obrazZopisem(String idObrazka, String opis) {
        super(idObrazka);
        this.opis = opis;
    }

    private String opis;

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}

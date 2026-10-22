package com.example.obrazzopisem;

abstract public class Obraz {
    protected String idObrazka;

    public Obraz(String idObrazka) {
        this.idObrazka = idObrazka;
    }

    public String getIdObrazka() {
        return idObrazka;
    }

    public void setIdObrazka(String idObrazka) {
        this.idObrazka = idObrazka;
    }
}

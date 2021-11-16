package com.example.sistemaexperto;

public class Datos {
    Integer id;
    String pais;
    String capital;

    public Datos(String pais, String capital) {
        this.pais = pais;
        this.capital = capital;
    }

    public Datos(Integer id, String pais, String capital) {
        this.id = id;
        this.pais = pais;
        this.capital = capital;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}


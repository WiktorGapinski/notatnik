package com.example.notatnik;

public class Notatka {
    private String tytul;
    private String tresc;
    private boolean wazna;

    public Notatka(String tytul, String tresc, boolean wazna) {
        this.tytul = tytul;
        this.tresc = tresc;
        this.wazna = wazna;
    }

    public String getTytul() {
        return tytul;
    }

    public String getTresc() {
        return tresc;
    }

    public boolean isWazna() {
        return wazna;
    }

    @Override
    public String toString() {
        return tytul + "\n" + tresc;
    }
}
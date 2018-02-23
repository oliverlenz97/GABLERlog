package de.klsssolution.gablerlog.model;

public class Adresse {
    private String strasse;
    private String ort;
    private String land;
    private int hausnummer;
    private int postleitzahl;

    private String adresseSql = "create table adresse ()";

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }


    public int getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String showAdresse() {
        return ("" + getStrasse() + " " + getPostleitzahl() + " " + getOrt() + " " + getLand());
    }
}

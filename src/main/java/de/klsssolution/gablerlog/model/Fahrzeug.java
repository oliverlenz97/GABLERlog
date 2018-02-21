package de.klsssolution.gablerlog.model;

public class Fahrzeug {

    private double laenge;

    private double hoehe;
    private double breite;
    private double maximalGewicht;
    private double leergewicht;
    private String marke;
    private String kennzeichen;
    private int fahrzeugId;
    private String fahrgestellnummer;


    public double getLaenge() {
        return laenge;
    }

    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public double getBreite() {
        return breite;
    }

    public void setBreite(double breite) {
        this.breite = breite;
    }

    public double getMaximalGewicht() {
        return maximalGewicht;
    }

    public void setMaximalGewicht(double maximalGewicht) {
        this.maximalGewicht = maximalGewicht;
    }

    public double getLeergewicht() {
        return leergewicht;
    }

    public void setLeergewicht(double leergewicht) {
        this.leergewicht = leergewicht;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public int getFahrzeugId() {
        return fahrzeugId;
    }

    public void setFahrzeugId(int fahrzeugId) {
        this.fahrzeugId = fahrzeugId;
    }

    public String getFahrgestellnummer() {
        return fahrgestellnummer;
    }

    public void setFahrgestellnummer(String fahrgestellnummer) {
        this.fahrgestellnummer = fahrgestellnummer;
    }
}

package de.klsssolution.gablerlog.model;

import java.util.ArrayList;
import java.util.List;

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
    private static int count;

    public Fahrzeug() {
        count = count + 1;
        fahrzeugId = count;
    }

    private static List<Fahrzeug> fuhrpark = fuhrparkErstellen();

    public static List<Fahrzeug> getFuhrpark() {
        return fuhrpark;
    }

    public static void setFuhrpark(List<Fahrzeug> fuhrpark) {
        Fahrzeug.fuhrpark = fuhrpark;
    }

    private static List<Fahrzeug> fuhrparkErstellen() {
        List<Fahrzeug> fuhrpark = new ArrayList<Fahrzeug>();
        Fahrzeug fahrzeug1 = new Fahrzeug();
        fahrzeug1.setBreite(2.30);
        fahrzeug1.setFahrgestellnummer("sha930d");
        fahrzeug1.setHoehe(3.2);
        fahrzeug1.setKennzeichen("MOS-SA-106");
        fahrzeug1.setLaenge(8.5);
        fahrzeug1.setLeergewicht(9000);
        fahrzeug1.setMarke("Mercedes");
        fahrzeug1.setMaximalGewicht(19000);


        Fahrzeug fahrzeug2 = new Fahrzeug();
        fahrzeug2.setBreite(2.40);
        fahrzeug2.setFahrgestellnummer("2450eok");
        fahrzeug2.setHoehe(3.3);
        fahrzeug2.setKennzeichen("MOS-O-754");
        fahrzeug2.setLaenge(7.2);
        fahrzeug2.setLeergewicht(8500);
        fahrzeug2.setMarke("Mercedes");
        fahrzeug2.setMaximalGewicht(16500);

        Fahrzeug fahrzeug3 = new Fahrzeug();
        fahrzeug3.setBreite(2.40);
        fahrzeug3.setFahrgestellnummer("dja932");
        fahrzeug3.setHoehe(3.3);
        fahrzeug3.setKennzeichen("MOS-O-720");
        fahrzeug3.setLaenge(7.2);
        fahrzeug3.setLeergewicht(8500);
        fahrzeug3.setMarke("Mercedes");
        fahrzeug3.setMaximalGewicht(16500);

        Fahrzeug fahrzeug4 = new Fahrzeug();
        fahrzeug4.setBreite(2.0);
        fahrzeug4.setFahrgestellnummer("sa3sla");
        fahrzeug4.setHoehe(3.0);
        fahrzeug4.setKennzeichen("MOS-G-732");
        fahrzeug4.setLaenge(7.5);
        fahrzeug4.setLeergewicht(8500);
        fahrzeug4.setMarke("Mercedes");
        fahrzeug4.setMaximalGewicht(18500);

        Fahrzeug fahrzeug5 = new Fahrzeug();
        fahrzeug5.setBreite(2.40);
        fahrzeug5.setFahrgestellnummer("sa3sla");
        fahrzeug5.setHoehe(3.3);
        fahrzeug5.setKennzeichen("MOS-L-922");
        fahrzeug5.setLaenge(7.2);
        fahrzeug5.setLeergewicht(8500);
        fahrzeug5.setMarke("Mercedes");
        fahrzeug5.setMaximalGewicht(17500);

        fuhrpark.add(fahrzeug1);
        fuhrpark.add(fahrzeug2);
        fuhrpark.add(fahrzeug3);
        fuhrpark.add(fahrzeug4);
        fuhrpark.add(fahrzeug5);


        return fuhrpark;
    }


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

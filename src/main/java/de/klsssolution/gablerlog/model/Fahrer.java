package de.klsssolution.gablerlog.model;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class Fahrer {
    private String fuehrerscheinKlasse;
    private String vorname;
    private String nachname;
    private Integer fahrerId;

    public static List<Fahrer> alleFahrer = fahrerlisteErstellen();

    private static List<Fahrer> fahrerlisteErstellen() {
        List<Fahrer> fahrer = new ArrayList<Fahrer>();

        Fahrer fahrer1 = new Fahrer();
        fahrer1.setVorname("John");
        fahrer1.setNachname("Doe");
        fahrer1.setFahrerId(123456);
        fahrer1.setFuehrerscheinKlasse("B-Klasse");

        fahrer.add(fahrer1);

        Fahrer fahrer2 = new Fahrer();
        fahrer2.setVorname("Adam");
        fahrer2.setNachname("Scott");
        fahrer2.setFahrerId(98765);
        fahrer2.setFuehrerscheinKlasse("E-Klasse");

        fahrer.add(fahrer2);

        Fahrer fahrer3 = new Fahrer();
        fahrer3.setVorname("Jane");
        fahrer3.setNachname("Doe");
        fahrer3.setFahrerId(65432);
        fahrer3.setFuehrerscheinKlasse("LKW");

        fahrer.add(fahrer3);
        return fahrer;
    }

    public String getFuehrerscheinKlasse() {
        return fuehrerscheinKlasse;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public Integer getFahrerId() {
        return fahrerId;
    }

    public void setFuehrerscheinKlasse(String fuehrerscheinKlasse) {
        this.fuehrerscheinKlasse = fuehrerscheinKlasse;
    }

    public void setVorname(String forename) {
        this.vorname = forename;
    }

    public void setNachname(String lastname) {
        this.nachname = lastname;
    }

    public void setFahrerId(Integer driverId) {
        this.fahrerId = driverId;
    }
}

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
        fahrer1.setVorname("Martin");
        fahrer1.setNachname("Müller");
        fahrer1.setFahrerId(12456);
        fahrer1.setFuehrerscheinKlasse("C");

        fahrer.add(fahrer1);

        Fahrer fahrer2 = new Fahrer();
        fahrer2.setVorname("Hans");
        fahrer2.setNachname("Schmidt");
        fahrer2.setFahrerId(98765);
        fahrer2.setFuehrerscheinKlasse("C");

        fahrer.add(fahrer2);

        Fahrer fahrer3 = new Fahrer();
        fahrer3.setVorname("Peter");
        fahrer3.setNachname("Meier");
        fahrer3.setFahrerId(65432);
        fahrer3.setFuehrerscheinKlasse("C1");

        fahrer.add(fahrer3);

        Fahrer fahrer4 = new Fahrer();
        fahrer4.setVorname("Rudolf");
        fahrer4.setNachname("Lehrmann");
        fahrer4.setFahrerId(35232);
        fahrer4.setFuehrerscheinKlasse("C1");

        fahrer.add(fahrer4);

        Fahrer fahrer5 = new Fahrer();
        fahrer5.setVorname("Hannes");
        fahrer5.setNachname("Lenz");
        fahrer5.setFahrerId(82912);
        fahrer5.setFuehrerscheinKlasse("C");

        fahrer.add(fahrer5);
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

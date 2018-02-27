package de.klsssolution.gablerlog.model;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class Kunde {
    private String firmenbezeichnung;
    private String ansprechpartner;
    private int kundenId;
    private static int count = 0;

    public Kunde() {
        count = count + 1;
        kundenId = count;
    }

    private static List<Kunde> alleKunden = kundenlisteErstellen();

    public static List<Kunde> getAlleKunden() {
        return alleKunden;
    }

    public static void setAlleKunden(List<Kunde> alleKunden) {
        Kunde.alleKunden = alleKunden;
    }

    private static List<Kunde> kundenlisteErstellen() {

        List<Kunde> kunden = new ArrayList<Kunde>();

        Kunde kunde1 = new Kunde();
        kunde1.setFirmenbezeichnung("Ecotest GmbH");
        kunde1.setAnsprechpartner("Tim Müller");

        kunden.add(kunde1);

        Kunde kunde2 = new Kunde();
        kunde2.setFirmenbezeichnung("Meier und Sohn");
        kunde2.setAnsprechpartner("Anna Schneider");

        kunden.add(kunde2);

        Kunde kunde3 = new Kunde();
        kunde3.setFirmenbezeichnung("Zara SE");
        kunde3.setAnsprechpartner("Thomas Doe");

        kunden.add(kunde3);
        return kunden;
    }


    private String kundeSql = "create table kunde (k_id integer primary key, k_firmenbezeichnung text, k_ansprechpartner text)";


    public String getFirmenbezeichnung() {
        return firmenbezeichnung;
    }

    public void setFirmenbezeichnung(String firmenbezeichnung) {
        this.firmenbezeichnung = firmenbezeichnung;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }

    public Integer getKundenId() {
        return kundenId;
    }

    public void setKundenId(Integer kundenId) {
        this.kundenId = kundenId;
    }
}
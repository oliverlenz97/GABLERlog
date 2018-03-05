package de.klsssolution.gablerlog.model;

import org.primefaces.model.SelectableDataModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Auftrag {
    private Kunde kunde;
    private Ladung ladung;
    private int auftragsnummer;
    private String status = "Erfasst";
    private Route route;
    private Date faelligBis;
    private static int count = 0;

    public Auftrag() {
        count = count + 1;
        auftragsnummer = count;
    }

    public Date getFaelligBis() {
        return faelligBis;
    }

    public void setFaelligBis(Date faelligBis) {
        this.faelligBis = faelligBis;
    }

    private static List<Auftrag> alleAuftraege = auftragslisteErstellen();

    public static List<Auftrag> getAlleAuftraege() {
        return alleAuftraege;
    }

    public static void setAlleAuftraege(List<Auftrag> alleAuftraege) {
        Auftrag.alleAuftraege = alleAuftraege;
    }

    public static List<Auftrag> auftragslisteErstellen() {
        List<Auftrag> alleAuftraege = new ArrayList<Auftrag>();

        Auftrag auftrag1 = new Auftrag();
        Route route = new Route();
        Kunde kunde1 = Kunde.getAlleKunden().get(2);
        auftrag1.setKunde(kunde1);
        Ladung ladung1 = new Ladung();
        ladung1.setBeschreibung("Gläser");
        ladung1.setBreite(1.04);
        ladung1.setGewicht(12);
        ladung1.setHoehe(1.5);
        ladung1.setId(1);
        ladung1.setKategorie("Haushalt");
        ladung1.setLaenge(0.8);
        auftrag1.setLadung(ladung1);
        auftrag1.setStatus("Erfasst");
        auftrag1.setFaelligBis(new Date(118, 4, 2));

        Adresse startadresse = new Adresse();
        Adresse zieladresse = new Adresse();
        startadresse.setStrasse("Hauptstraße");
        startadresse.setHausnummer(33);
        startadresse.setPostleitzahl(97282);
        startadresse.setOrt("Retzstadt");

        zieladresse.setStrasse("Semmelstraße");
        zieladresse.setHausnummer(12);
        zieladresse.setPostleitzahl(97070);
        zieladresse.setOrt("Würzburg");

        route.setStartadresse(startadresse);
        route.setZieladresse(zieladresse);
        auftrag1.setRoute(route);
        alleAuftraege.add(auftrag1);


        Auftrag auftrag2 = new Auftrag();
        Route route2 = new Route();
        Kunde kunde = Kunde.getAlleKunden().get(0);
        auftrag2.setKunde(kunde);
        Ladung ladung2 = new Ladung();
        ladung2.setBeschreibung("Stühle");
        ladung2.setBreite(2.04);
        ladung2.setGewicht(20);
        ladung2.setHoehe(1.5);
        ladung2.setKategorie("Haushalt");
        ladung2.setLaenge(12);
        auftrag2.setLadung(ladung2);
        auftrag2.setStatus("Erfasst");
        auftrag2.setFaelligBis(new Date(118, 5, 23));

        Adresse startadresse2 = new Adresse();
        Adresse zieladresse2 = new Adresse();
        startadresse2.setOrt("Hamburg");
        zieladresse2.setOrt("Köln");
        zieladresse2.setHausnummer(2);
        startadresse2.setHausnummer(45);
        startadresse2.setPostleitzahl(20095);
        zieladresse2.setPostleitzahl(50667);
        startadresse2.setStrasse("Hauptstraße");
        zieladresse2.setStrasse("Marktplatz");

        route2.setStartadresse(startadresse2);
        route2.setZieladresse(zieladresse2);
        auftrag2.setRoute(route2);
        alleAuftraege.add(auftrag2);


        Auftrag auftrag3 = new Auftrag();
        Route route3 = new Route();
        Kunde kunde3 = Kunde.getAlleKunden().get(3);
        auftrag3.setKunde(kunde3);
        Ladung ladung3 = new Ladung();
        ladung3.setBeschreibung("Esstisch");
        ladung3.setBreite(1.5);
        ladung3.setGewicht(100);
        ladung3.setHoehe(0.5);
        ladung3.setKategorie("Haushalt");
        ladung3.setLaenge(1);
        auftrag3.setLadung(ladung3);
        auftrag3.setStatus("Erfasst");
        auftrag3.setFaelligBis(new Date(118, 5, 23));

        Adresse startadresse3 = new Adresse();
        Adresse zieladresse3 = new Adresse();
        startadresse3.setOrt("Reinheim");
        zieladresse3.setOrt("Stuttgart");
        zieladresse3.setHausnummer(60);
        startadresse3.setHausnummer(62);
        startadresse3.setPostleitzahl(64354);
        zieladresse3.setPostleitzahl(70376);
        startadresse3.setStrasse("Darmstädter Straße");
        zieladresse3.setStrasse("Murgtalstraße");

        route3.setStartadresse(startadresse3);
        route3.setZieladresse(zieladresse3);
        auftrag3.setRoute(route3);
        alleAuftraege.add(auftrag3);

        return alleAuftraege;
    }

    public static void auftragHinzufuegen(Auftrag auftrag) {
        alleAuftraege.add(auftrag);
    }

    public void auftragLoeschen(Auftrag auftrag) {
        for (Auftrag eintrag : alleAuftraege) {
            if (eintrag.getAuftragsnummer() == auftrag.getAuftragsnummer()) {
                alleAuftraege.remove(eintrag);
            }
        }
    }

    public String datenbankAuftrag = "create table auftrag (a_id integer PRIMARY KEY, a_status string, )";

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Ladung getLadung() {
        return ladung;
    }

    public void setLadung(Ladung ladung) {
        this.ladung = ladung;
    }

    public int getAuftragsnummer() {
        return auftragsnummer;
    }

    public void setAuftragsnummer(int auftragsnummer) {
        this.auftragsnummer = auftragsnummer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public static int getCount() {
        return count;
    }

    public String datumAusgeben(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat format = new SimpleDateFormat("E, d.M.y");
            return format.format(date);
        }
    }
}



package de.klsssolution.gablerlog.model;

import org.primefaces.model.SelectableDataModel;

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
        Kunde kunde1 = new Kunde();
        kunde1.setKundenId(1);
        kunde1.setAnsprechpartner("Max Meier");
        kunde1.setFirmenbezeichnung("TestFirma GmbH");
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

        Adresse startadresse = new Adresse();
        Adresse zieladresse = new Adresse();
        startadresse.setOrt("Retzstadt");
        zieladresse.setOrt("Würzburg");
        startadresse.setPostleitzahl(97282);
        zieladresse.setPostleitzahl(97070);
        startadresse.setHausnummer(33);
        zieladresse.setHausnummer(12);
        startadresse.setStrasse("Hauptstraße");
        zieladresse.setStrasse("Marktplatz");
        startadresse.setLand("Deutschland");
        zieladresse.setLand("Deutschland");

        route.setStartadresse(startadresse);
        route.setZieladresse(zieladresse);
        auftrag1.setRoute(route);
        alleAuftraege.add(auftrag1);


        Auftrag auftrag2 = new Auftrag();
        Route route2 = new Route();
        Kunde kunde2 = new Kunde();
        kunde2.setFirmenbezeichnung("Meier und Sohn");
        kunde2.setAnsprechpartner("Anna Schneider");
        kunde2.setKundenId(98765);
        auftrag2.setKunde(kunde2);
        Ladung ladung2 = new Ladung();
        ladung2.setBeschreibung("Stühle");
        ladung2.setBreite(2.04);
        ladung2.setGewicht(20);
        ladung2.setHoehe(1.5);
        ladung2.setId(2);
        ladung2.setKategorie("Haushalt");
        ladung2.setLaenge(12);
        auftrag2.setLadung(ladung2);
        auftrag2.setStatus("Erfasst");

        Adresse startadresse2 = new Adresse();
        Adresse zieladresse2 = new Adresse();
        startadresse2.setOrt("Hamburg");
        zieladresse2.setOrt("Köln");
        zieladresse2.setHausnummer(2);
        startadresse2.setPostleitzahl(45);
        startadresse2.setPostleitzahl(20095);
        zieladresse2.setPostleitzahl(50667);
        startadresse2.setStrasse("Hauptstraße");
        zieladresse2.setStrasse("Marktplatz");
        startadresse2.setLand("Deutschland");
        zieladresse2.setLand("Deutschland");

        route2.setStartadresse(startadresse2);
        route2.setZieladresse(zieladresse2);
        auftrag2.setRoute(route2);
        alleAuftraege.add(auftrag2);

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

}


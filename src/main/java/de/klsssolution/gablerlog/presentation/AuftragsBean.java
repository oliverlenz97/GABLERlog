package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class AuftragsBean {

    private Kunde kunde;
    private Ladung ladung;

    public String startStrasse;
    public String startOrt;
    public String startLand;
    public int startHausnummer;
    public String startZusatz;
    public int startPostleitzahl;

    public String zielStrasse;
    public String zielOrt;
    public String zielLand;
    public int zielHausnummer;
    public String zielZusatz;
    public int zielPostleitzahl;

    private int auftragsnummer = 0;
    private String status = "Erfasst";

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

    public void setAuftraege(List<Auftrag> auftraege) {
        this.auftraege = auftraege;
    }

    private List<Auftrag> auftraege;

    public List<Auftrag> getAuftraege() {
        return auftraege;
    }

    public String getStartStrasse() {
        return startStrasse;
    }

    public void setStartStrasse(String startStrasse) {
        this.startStrasse = startStrasse;
    }

    public String getStartOrt() {
        return startOrt;
    }

    public void setStartOrt(String startOrt) {
        this.startOrt = startOrt;
    }

    public String getStartLand() {
        return startLand;
    }

    public void setStartLand(String startLand) {
        this.startLand = startLand;
    }

    public int getStartHausnummer() {
        return startHausnummer;
    }

    public void setStartHausnummer(int startHausnummer) {
        this.startHausnummer = startHausnummer;
    }

    public String getStartZusatz() {
        return startZusatz;
    }

    public void setStartZusatz(String startZusatz) {
        this.startZusatz = startZusatz;
    }

    public int getStartPostleitzahl() {
        return startPostleitzahl;
    }

    public void setStartPostleitzahl(int startPostleitzahl) {
        this.startPostleitzahl = startPostleitzahl;
    }

    public String getZielStrasse() {
        return zielStrasse;
    }

    public void setZielStrasse(String zielStrasse) {
        this.zielStrasse = zielStrasse;
    }

    public String getZielOrt() {
        return zielOrt;
    }

    public void setZielOrt(String zielOrt) {
        this.zielOrt = zielOrt;
    }

    public String getZielLand() {
        return zielLand;
    }

    public void setZielLand(String zielLand) {
        this.zielLand = zielLand;
    }

    public int getZielHausnummer() {
        return zielHausnummer;
    }

    public void setZielHausnummer(int zielHausnummer) {
        this.zielHausnummer = zielHausnummer;
    }

    public String getZielZusatz() {
        return zielZusatz;
    }

    public void setZielZusatz(String zielZusatz) {
        this.zielZusatz = zielZusatz;
    }

    public int getZielPostleitzahl() {
        return zielPostleitzahl;
    }

    public void setZielPostleitzahl(int zielPostleitzahl) {
        this.zielPostleitzahl = zielPostleitzahl;
    }

    @PostConstruct
    public void setup() {
        List<Auftrag> auftraege = new ArrayList<Auftrag>();

        Auftrag auftrag1 = new Auftrag();
        Route route = new Route();
        auftrag1.setAuftragsnummer(0001);
        Kunde kunde1 = new Kunde();
        kunde1.setKundenId(1);
        kunde1.setAnsprechpartner("Max Meier");
        kunde1.setFirmenbezeichnung("TestFirma GmbH");
        auftrag1.setKunde(kunde1);
        Ladung ladung1 = new Ladung();
        ladung1.setBemerkung("Zerbrechlicher Inhalt");
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
        startadresse.setPostleitzahl(33);
        zieladresse.setPostleitzahl(12);
        startadresse.setStrasse("Hauptstraße");
        zieladresse.setStrasse("Marktplatz");
        startadresse.setLand("Deutschland");
        zieladresse.setLand("Deutschland");

        route.setStartadresse(startadresse);
        route.setZieladresse(zieladresse);
        auftrag1.setRoute(route);
        auftraege.add(auftrag1);

        this.auftraege = auftraege;
    }

    public void auftragHinzufuegen() {

        Auftrag neuerAuftrag = new Auftrag();
        //neuerAuftrag.setKunde(kunde);

        Route route = new Route();
        Adresse startadresse = new Adresse();
        Adresse zieladresse = new Adresse();


        startadresse.setHausnummer(startHausnummer);
        startadresse.setLand(startLand);
        startadresse.setOrt(startOrt);
        startadresse.setPostleitzahl(startPostleitzahl);
        startadresse.setStrasse(startStrasse);

        zieladresse.setHausnummer(zielHausnummer);
        zieladresse.setLand(zielLand);
        zieladresse.setOrt(zielOrt);
        zieladresse.setPostleitzahl(zielPostleitzahl);
        zieladresse.setStrasse(zielStrasse);

        route.setStartadresse(startadresse);
        route.setZieladresse(zieladresse);

        neuerAuftrag.setRoute(route);

        this.auftraege.add(neuerAuftrag);
        auftragsnummer = 0;
    }

}

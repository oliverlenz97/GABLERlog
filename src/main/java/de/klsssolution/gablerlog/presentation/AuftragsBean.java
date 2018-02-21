package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
public class AuftragsBean {

    private Kunde kunde;
    private Ladung ladung;

    private String startStrasse;
    private String startOrt;
    private String startLand;
    private int startHausnummer;
    private String startZusatz;
    private int startPostleitzahl;

    private String zielStrasse;
    private String zielOrt;
    private String zielLand;
    private int zielHausnummer;
    private String zielZusatz;
    private int zielPostleitzahl;

    private double gewicht;
    private String beschreibung;
    private String kategorie;
    private double breite;
    private double hoehe;
    private double laenge;


    @PostConstruct
    public void setup() {
        auftragslisteErstellen();
        kundenlisteErstellen();
    }

    public void auftragslisteErstellen() {
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

    public void kundenlisteErstellen() {
        List<Kunde> kunden = new ArrayList<Kunde>();

        Kunde kunde1 = new Kunde();
        kunde1.setFirmenbezeichnung("Ecotest GmbH");
        kunde1.setAnsprechpartner("Tim Müller");
        kunde1.setKundenId(123456);

        kunden.add(kunde1);

        Kunde kunde2 = new Kunde();
        kunde2.setFirmenbezeichnung("Meier und Sohn");
        kunde2.setAnsprechpartner("Anna Schneider");
        kunde2.setKundenId(98765);

        kunden.add(kunde2);

        Kunde kunde3 = new Kunde();
        kunde3.setFirmenbezeichnung("Zara SE");
        kunde3.setAnsprechpartner("Thomas Doe");
        kunde3.setKundenId(65432);

        kunden.add(kunde3);
        this.kunden = kunden;

        Map<String, String> kundenMap = new HashMap<String, String>();
        List<String> firmenbezeichnungen = new ArrayList<String>();
        for (Kunde kunde : kunden) {
            kundenMap.put(kunde.getFirmenbezeichnung(), kunde.getFirmenbezeichnung());
            firmenbezeichnungen.add(kunde.getFirmenbezeichnung());
        }
        this.kundenMap = kundenMap;
        this.firmenbezeichnungen = firmenbezeichnungen;

    }


    public void auftragHinzufuegen() {

        Auftrag neuerAuftrag = new Auftrag();
        neuerAuftrag.setKunde(kunde);

        Route route = new Route();
        Adresse startadresse = new Adresse();
        Adresse zieladresse = new Adresse();

        Ladung ladung = new Ladung();

        ladung.setLaenge(laenge);
        ladung.setKategorie(kategorie);
        ladung.setHoehe(hoehe);
        ladung.setGewicht(gewicht);
        ladung.setBreite(breite);
        ladung.setBeschreibung(beschreibung);

        neuerAuftrag.setLadung(ladung);

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


    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public double getBreite() {
        return breite;
    }

    public void setBreite(double breite) {
        this.breite = breite;
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public double getLaenge() {
        return laenge;
    }

    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }

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


    private List<Kunde> kunden;
    private List<String> firmenbezeichnungen;

    public List<String> getFirmenbezeichnungen() {
        return firmenbezeichnungen;
    }

    public void setFirmenbezeichnungen(List<String> firmenbezeichnungen) {
        this.firmenbezeichnungen = firmenbezeichnungen;
    }

    private Kunde gewaehlterKunde;
    private Map<String, String> kundenMap;


    public Kunde getGewaehlterKunde() {
        return gewaehlterKunde;
    }

    public void setGewaehlterKunde(Kunde gewaehlterKunde) {
        this.gewaehlterKunde = gewaehlterKunde;
    }

    public List<Kunde> getKunden() {
        return kunden;
    }

    public Map<String, String> getKundenMap() {
        return kundenMap;
    }


}

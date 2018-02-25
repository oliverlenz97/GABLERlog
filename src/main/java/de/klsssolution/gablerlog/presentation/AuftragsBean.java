package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.*;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class AuftragsBean {

    private int kundennummer;

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
        auftraege = Auftrag.getAlleAuftraege();
    }

    public void auftragHinzufuegen() {
        Auftrag neuerAuftrag = new Auftrag();

        for (int i = 0; i < Kunde.getAlleKunden().size(); i++) {
            System.out.println("Aus View: " + kundennummer);

            if (Kunde.getAlleKunden().get(i).getKundenId() == this.kundennummer) {
                neuerAuftrag.setKunde(Kunde.getAlleKunden().get(i));
                System.out.println("aus Liste: " + Kunde.getAlleKunden().get(i).getKundenId());
            }
        }


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

        //this.auftraege.add(neuerAuftrag);
        Auftrag.auftragHinzufuegen(neuerAuftrag);
        FacesContext.getCurrentInstance().

                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gespeichert", ""));
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

    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
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

    public List<Kunde> getKunden() {
        return kunden;
    }
}

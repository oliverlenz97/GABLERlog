package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.*;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class AuftragsBean {

    private Double kundennummer;

    private Ladung ladung;

    private String startStrasse;
    private String startOrt;
    private String startLand;
    private Double startHausnummer = new Double(0);
    private String startZusatz;
    private Double startPostleitzahl = new Double(0);

    private String zielStrasse;
    private String zielOrt;
    private String zielLand;
    private Double zielHausnummer = new Double(0);
    private String zielZusatz;
    private Double zielPostleitzahl = new Double(0);

    private Double gewicht = new Double(0);
    private String beschreibung;
    private String kategorie;
    private Double breite = new Double(0);
    private Double hoehe = new Double(0);
    private Double laenge = new Double(0);
    private Date faelligBis;
    private Date heute = new Date();

    private Auftrag gewaehlterAuftrag;


    private List<Auftrag> auftraege;

    @PostConstruct
    public void setup() {
        auftraege = Auftrag.getAlleAuftraege();
    }

    /*
    Neuen Auftrag erstellen. Kunde wird aus Kundenliste gesucht, Route wird aus Adressen erstellt.
    Die Ladung wird mit den entsprechenden Werten gespeichert.
     */
    public void auftragHinzufuegen() {
        Auftrag neuerAuftrag = new Auftrag();
        Boolean kundeGefunden = false;

        for (int i = 0; i < Kunde.getAlleKunden().size(); i++) {
            if (Kunde.getAlleKunden().get(i).getKundenId() == kundennummer.intValue()) {
                kundeGefunden = true;
                neuerAuftrag.setKunde(Kunde.getAlleKunden().get(i));
            }
        }
        if (!kundeGefunden) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Speichern nicht möglich", "Kunde nicht gefunden"));
            return;
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

        startadresse.setStrasse(startStrasse);
        startadresse.setHausnummer(startHausnummer.intValue());
        startadresse.setPostleitzahl(startPostleitzahl.intValue());
        startadresse.setOrt(startOrt);
        startadresse.setLand(startLand);

        zieladresse.setStrasse(zielStrasse);
        zieladresse.setHausnummer(zielHausnummer.intValue());
        zieladresse.setPostleitzahl(zielPostleitzahl.intValue());
        zieladresse.setOrt(zielOrt);
        zieladresse.setLand(zielLand);

        route.setStartadresse(startadresse);
        route.setZieladresse(zieladresse);

        neuerAuftrag.setRoute(route);
        neuerAuftrag.setFaelligBis(faelligBis);

        Auftrag.auftragHinzufuegen(neuerAuftrag);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gespeichert", ""));
        resetData();
    }

    public void auftragBearbeiten(Auftrag auftrag) {

    }

    private void resetData() {
        kundennummer = 0.0;
        ladung = null;

        startStrasse = null;
        startOrt = "";
        startLand = "";
        startHausnummer = 0.0;
        startZusatz = "";
        startPostleitzahl = 0.0;

        zielStrasse = "";
        zielOrt = "";
        zielLand = "";
        zielHausnummer = 0.0;
        zielZusatz = "";
        zielPostleitzahl = 0.0;

        gewicht = 0.0;
        beschreibung = "";
        kategorie = "";
        breite = 0.0;
        hoehe = 0.0;
        laenge = 0.0;
        faelligBis = null;
    }

    public void auftragLoeschen() {
        auftraege.remove(gewaehlterAuftrag);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Auftrag gelöscht", ""));
    }

    /*
    Dialog aus der View aufrufen, um abzufragen, ob der Disponent den Auftrag wirklich löschen will.
    Abspeichern des gewählten Auftrags aus der Tabelle.
     */
    public void actionButtonLoeschen(Auftrag auftrag) {
        RequestContext.getCurrentInstance().execute("PF('digi').show();");
        gewaehlterAuftrag = auftrag;
    }

    public Double getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(Double kundennummer) {
        this.kundennummer = kundennummer;
    }

    public Ladung getLadung() {
        return ladung;
    }

    public void setLadung(Ladung ladung) {
        this.ladung = ladung;
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

    public Double getStartHausnummer() {
        return startHausnummer;
    }

    public void setStartHausnummer(Double startHausnummer) {
        this.startHausnummer = startHausnummer;
    }

    public String getStartZusatz() {
        return startZusatz;
    }

    public void setStartZusatz(String startZusatz) {
        this.startZusatz = startZusatz;
    }

    public Double getStartPostleitzahl() {
        return startPostleitzahl;
    }

    public void setStartPostleitzahl(Double startPostleitzahl) {
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

    public Double getZielHausnummer() {
        return zielHausnummer;
    }

    public void setZielHausnummer(Double zielHausnummer) {
        this.zielHausnummer = zielHausnummer;
    }

    public String getZielZusatz() {
        return zielZusatz;
    }

    public void setZielZusatz(String zielZusatz) {
        this.zielZusatz = zielZusatz;
    }

    public Double getZielPostleitzahl() {
        return zielPostleitzahl;
    }

    public void setZielPostleitzahl(Double zielPostleitzahl) {
        this.zielPostleitzahl = zielPostleitzahl;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
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

    public Double getBreite() {
        return breite;
    }

    public void setBreite(Double breite) {
        this.breite = breite;
    }

    public Double getHoehe() {
        return hoehe;
    }

    public void setHoehe(Double hoehe) {
        this.hoehe = hoehe;
    }

    public Double getLaenge() {
        return laenge;
    }

    public void setLaenge(Double laenge) {
        this.laenge = laenge;
    }

    public List<Auftrag> getAuftraege() {
        return auftraege;
    }

    public void setAuftraege(List<Auftrag> auftraege) {
        this.auftraege = auftraege;
    }

    public Date getFaelligBis() {
        return faelligBis;
    }

    public void setFaelligBis(Date faelligBis) {
        this.faelligBis = faelligBis;
    }

    public Date getHeute() {
        return heute;
    }

    public Auftrag getGewaehlterAuftrag() {
        return gewaehlterAuftrag;
    }

    public void setGewaehlterAuftrag(Auftrag gewaehlterAuftrag) {
        this.gewaehlterAuftrag = gewaehlterAuftrag;
    }

}

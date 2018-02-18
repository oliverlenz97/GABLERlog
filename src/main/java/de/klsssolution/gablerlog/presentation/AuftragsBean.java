package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.*;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class AuftragsBean {

    private Kunde kunde;
    private Ladung ladung;
    private String startadresse = "";
    private String zieladresse = "";
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

    public String getStartadresse() {
        return startadresse;
    }

    public void setStartadresse(String startadresse) {
        this.startadresse = startadresse;
    }

    public String getZieladresse() {
        return zieladresse;
    }

    public void setZieladresse(String zieladresse) {
        this.zieladresse = zieladresse;
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

    @PostConstruct
    public void setup() {
        List<Auftrag> auftraege = new ArrayList<Auftrag>();

        Auftrag auftrag1 = new Auftrag();
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
        auftrag1.setRoute(new Route());
        auftrag1.setStartadresse("Retzstadt");
        auftrag1.setStatus("Erfasst");
        auftrag1.setZieladresse("Karlstadt");

        auftraege.add(auftrag1);

        this.auftraege = auftraege;
    }

    public void auftragHinzufuegen() {

        System.out.println("Button ausgeführt");

        if (isEmpty(startadresse) || isEmpty(zieladresse) || kunde == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehlende Angabe", ""));
        } else {
            Auftrag neuerAuftrag = new Auftrag();
            neuerAuftrag.setZieladresse(zieladresse);
            neuerAuftrag.setKunde(kunde);
            neuerAuftrag.setStartadresse(startadresse);
            this.auftraege.add(neuerAuftrag);
        }
    }

    private boolean isEmpty(String input) {
        return (input == null || input.equals(""));
    }
}

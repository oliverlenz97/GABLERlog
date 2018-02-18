package de.klsssolution.gablerlog.model;

public class Auftrag {
    private Kunde kunde;
    private Ladung ladung;
    private String startadresse;
    private String zieladresse;
    private int auftragsnummer;
    private String status = "Erfasst";
    private Route route;


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

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}


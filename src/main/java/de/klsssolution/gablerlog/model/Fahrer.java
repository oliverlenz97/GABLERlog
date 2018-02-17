package de.klsssolution.gablerlog.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Fahrer {
    public String fuehrerscheinKlasse;
    public String vorname;
    public String nachname;
    public Integer driverId;


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
        return driverId;
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
        this.driverId = driverId;
    }
}

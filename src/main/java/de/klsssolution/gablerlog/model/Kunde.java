package de.klsssolution.gablerlog.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Kunde {
    private String vorname = "John";
    private String nachname = "Doe";
    private Integer kundenId;

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Integer getKundenId() {
        return kundenId;
    }

    public void setKundenId(Integer customerId) {
        this.kundenId = kundenId;
    }


}
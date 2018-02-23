package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.Kunde;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@ViewScoped
public class KundenBean {
    private List<Kunde> kunden;
    private List<String> firmenbezeichnungen;

    public void onChange() {
        System.out.println("Kunde: " + gewaehlterKunde);
    }


    private Kunde gewaehlterKunde;

    public Kunde getGewaehlterKunde() {
        return gewaehlterKunde;
    }

    public void setGewaehlterKunde(Kunde gewaehlterKunde) {
        this.gewaehlterKunde = gewaehlterKunde;
    }

    public List<Kunde> getKunden() {
        return kunden;
    }

    @PostConstruct
    public void setup() {
        kunden = Kunde.getAlleKunden();
    }

}

//DB Daten abrufen

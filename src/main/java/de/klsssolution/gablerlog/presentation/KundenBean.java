package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.Kunde;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class KundenBean {
    private List<Kunde> kunden;

    public List<Kunde> getKunden() {
        return kunden;
    }

    @PostConstruct
    public void setup() {
        List<Kunde> kunden = new ArrayList<Kunde>();

        Kunde kunde1 = new Kunde();
        kunde1.setVorname("John");
        kunde1.setNachname("Doe");
        kunde1.setKundenId(123456);

        kunden.add(kunde1);

        Kunde kunde2 = new Kunde();
        kunde2.setVorname("Adam");
        kunde2.setNachname("Scott");
        kunde2.setKundenId(98765);

        kunden.add(kunde2);

        Kunde kunde3 = new Kunde();
        kunde3.setVorname("Jane");
        kunde3.setNachname("Doe");
        kunde3.setKundenId(65432);

        kunden.add(kunde3);
        this.kunden = kunden;
    }
}

//DB Daten abrufen

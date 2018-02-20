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

    @PostConstruct
    public void setup() {
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


}

//DB Daten abrufen

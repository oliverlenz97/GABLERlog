package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.Fahrer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class FahrerBean {
    private List<Fahrer> fahrer;

    public List<Fahrer> getFahrer() {
        return fahrer;
    }

    @PostConstruct
    public void setup() {
        List<Fahrer> fahrer = new ArrayList<Fahrer>();

        Fahrer fahrer1 = new Fahrer();
        fahrer1.setVorname("John");
        fahrer1.setNachname("Doe");
        fahrer1.setFahrerId(123456);
        fahrer1.setFuehrerscheinKlasse("B-Klasse");

        fahrer.add(fahrer1);

        Fahrer fahrer2 = new Fahrer();
        fahrer2.setVorname("Adam");
        fahrer2.setNachname("Scott");
        fahrer2.setFahrerId(98765);
        fahrer2.setFuehrerscheinKlasse("E-Klasse");


        fahrer.add(fahrer2);

        Fahrer fahrer3 = new Fahrer();
        fahrer3.setVorname("Jane");
        fahrer3.setNachname("Doe");
        fahrer3.setFahrerId(65432);
        fahrer3.setFuehrerscheinKlasse("LKW");


        fahrer.add(fahrer3);
        this.fahrer = fahrer;
    }
}
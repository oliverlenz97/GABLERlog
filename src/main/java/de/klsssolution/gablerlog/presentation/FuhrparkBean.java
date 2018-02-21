package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.Fahrzeug;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class FuhrparkBean {
    List<Fahrzeug> fuhrpark = new ArrayList<Fahrzeug>();

    public List<Fahrzeug> getFuhrpark() {
        return fuhrpark;
    }

    @PostConstruct
    public void setup() {
        List<Fahrzeug> fuhrpark = new ArrayList<Fahrzeug>();
        Fahrzeug fahrzeug1 = new Fahrzeug();
        fahrzeug1.setBreite(2.30);
        fahrzeug1.setFahrgestellnummer("sha930d");
        fahrzeug1.setFahrzeugId(1);
        fahrzeug1.setHoehe(3.2);
        fahrzeug1.setKennzeichen("MSP-AS-109");
        fahrzeug1.setLaenge(8.5);
        fahrzeug1.setLeergewicht(9.000);
        fahrzeug1.setMarke("Mercedes");
        fahrzeug1.setMaximalGewicht(17.500);


        Fahrzeug fahrzeug2 = new Fahrzeug();
        fahrzeug2.setBreite(2.40);
        fahrzeug2.setFahrgestellnummer("2450eok");
        fahrzeug2.setFahrzeugId(2);
        fahrzeug2.setHoehe(3.3);
        fahrzeug2.setKennzeichen("ERB-O-705");
        fahrzeug2.setLaenge(7.2);
        fahrzeug2.setLeergewicht(8.500);
        fahrzeug2.setMarke("Mercedes");
        fahrzeug2.setMaximalGewicht(16.500);

        fuhrpark.add(fahrzeug1);
        fuhrpark.add(fahrzeug2);
        this.fuhrpark = fuhrpark;
    }
}

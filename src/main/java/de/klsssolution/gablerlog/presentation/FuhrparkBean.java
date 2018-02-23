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
        fuhrpark = Fahrzeug.getFuhrpark();

    }
}

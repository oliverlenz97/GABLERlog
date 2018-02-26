package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.Flottenzentrale;
import de.klsssolution.gablerlog.model.Route;
import de.klsssolution.gablerlog.model.Tour;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import java.awt.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class TourenberechnungBean {

    private String startadresse;
    private String[] waypointArray = {"Retzstadt"};
    private List<String> adressen = new ArrayList<>();

    public List<String> getAdressen() {
        return adressen;
    }

    @PostConstruct
    public void init() {
        Flottenzentrale f = new Flottenzentrale();
        startadresse = f.getMapsAdresseZentrale();
    }

    public String getStartadresse() {
        return startadresse;
    }

    public void setStartadresse(String startadresse) {
        this.startadresse = startadresse;
    }

    public String[] getWaypointArray() {
        return waypointArray;
    }

    public void actionButtonAnzeigen(Tour tour) throws Exception {
        List<Route> routen = tour.getAlleRouten();
        List<String> adressen = new ArrayList<>();
        for (Route route : routen) {
            adressen.add(route.getStartadresse().getOrt());
            adressen.add(route.getZieladresse().getOrt());
            //TODO: ganze Adresse ausgeben
        }
        this.adressen = adressen;
        //return "/maps.xhtml";
    }
}

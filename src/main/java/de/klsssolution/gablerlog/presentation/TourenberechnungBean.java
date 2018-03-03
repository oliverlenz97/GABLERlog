package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.Flottenzentrale;
import de.klsssolution.gablerlog.model.Route;
import de.klsssolution.gablerlog.model.Tour;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class TourenberechnungBean {

    private String startadresse;
    private List<String> adressen = new ArrayList<>();
    private String ausgewaehlteTourId;
    private List<Tour> touren = Tour.getAlleTouren();
    private List<String> tourIds = new ArrayList<>();

    @PostConstruct
    public void init() {
        Flottenzentrale f = new Flottenzentrale();
        startadresse = f.getZENTRALEN_ADRESSE().toString();
        tourIds = getTourenIds();
    }

    /*
    IDs der Touren als String abspeichern, da sie für das Dropdown-Menü als String vorliegen müssen
     */
    private List<String> getTourenIds() {
        List<String> ids = new ArrayList<String>();
        for (Tour tour : touren) {
            String adresse = tour.getTourId() + "";
            ids.add(adresse);
        }
        return ids;
    }

    /*
    Für die im Dropdown-Menü gewählte Tourid die entsprechende Tour finden und die Adressen der Routen speichern.
     */
    public void actionTourWaehlen() {
        Tour ausgewaehlteTour = new Tour();
        Boolean tourGefunden = false;

        for (Tour tour : Tour.alleTouren) {
            if (tour.getTourId() == Integer.parseInt(ausgewaehlteTourId)) {
                ausgewaehlteTour = tour;
                tourGefunden = true;
            }
        }
        if (!tourGefunden) {
            return;
        } else {
            List<Route> routen = ausgewaehlteTour.getAlleRouten();
            List<String> adressen = new ArrayList<>();
            for (Route route : routen) {
                adressen.add(route.getStartadresse().toString());
                adressen.add(route.getZieladresse().toString());
            }
            this.adressen = adressen;
        }
    }

    /*
    Methode, um Null-Pointer Exceptions durch get(x) zu vermeiden
     */
    public String getAdresse(int nummer) {
        if (adressen.size() > nummer) {
            return adressen.get(nummer);
        } else return "";
    }

    public String getStartadresse() {
        return startadresse;
    }

    public void setStartadresse(String startadresse) {
        this.startadresse = startadresse;
    }

    public List<String> getAdressen() {
        return adressen;
    }

    public List<Tour> getTouren() {
        return touren;
    }

    public void setTouren(List<Tour> touren) {
        this.touren = touren;
    }

    public String getAusgewaehlteTourId() {
        return ausgewaehlteTourId;
    }

    public void setAusgewaehlteTourId(String ausgewaehlteTourId) {
        this.ausgewaehlteTourId = ausgewaehlteTourId;
    }

    public List<String> getTourIds() {
        return tourIds;
    }
}

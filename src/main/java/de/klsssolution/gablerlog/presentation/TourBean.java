package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.Tour;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import de.klsssolution.gablerlog.model.ZeitFormat;

@ManagedBean
@ViewScoped
public class TourBean {
    private List<Tour> tours;
    private Tour selectedTour;
    public List<Tour> getTours() {
        return tours;
    }

    @PostConstruct
    public void setup() {
        List<Tour> tours = new ArrayList<Tour>();

        Tour tour1 = new Tour();
        tour1.setTourId();
        tour1.setBezeichnung("WÜ Stadt Mittwoch Vormittag");
        tour1.setFaelligkeitsZeit(ZeitFormat.zeitstempelErzeugen("2018-03-06 10:30"));
        tours.add(tour1);

        Tour tour2 = new Tour();
        tour2.setTourId();
        tour2.setBezeichnung("WÜ Stadt Freitag Nachmittag");
        tour2.setFaelligkeitsZeit(ZeitFormat.zeitstempelErzeugen("2018-03-18 14:30"));
        tours.add(tour2);

        this.tours = tours;

    }

}
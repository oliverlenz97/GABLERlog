package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.Tour;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import java.util.List;

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
        tours = Tour.getAlleTouren();
    }

}
package de.klsssolution.gablerlog.model;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private double distanz;
    private int id;
    private Adresse startadresse;
    private Adresse zieladresse;
    private static int count = 0;

    public Route() {
        count = count + 1;
        id = count;
    }


    public double getDistanz() {
        return distanz;
    }

    public void setDistanz(double distanz) {
        this.distanz = distanz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Adresse getStartadresse() {
        return startadresse;
    }

    public void setStartadresse(Adresse startadresse) {
        this.startadresse = startadresse;
    }

    public Adresse getZieladresse() {
        return zieladresse;
    }

    public void setZieladresse(Adresse zieladresse) {
        this.zieladresse = zieladresse;
    }
}
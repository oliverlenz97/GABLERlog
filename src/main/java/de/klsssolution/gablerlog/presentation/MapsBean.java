package de.klsssolution.gablerlog.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MapsBean {

    private String startAdresse;
    private String zielAdresse;

    public String getStartAdresse() {
        return startAdresse;
    }

    public void setStartAdresse(String startAdresse) {
        this.startAdresse = startAdresse;
    }

    public String getZielAdresse() {
        return zielAdresse;
    }

    public void setZielAdresse(String zielAdresse) {
        this.zielAdresse = zielAdresse;
    }
}

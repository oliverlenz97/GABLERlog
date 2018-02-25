package de.klsssolution.gablerlog.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MapsBean {

    private String startAdresse;
    private String zielAdresse;

    /*@PostConstruct
    public void setup() throws Exception {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyCISoSZlMcK_DOofSeZF0-CxSyoOEwOypM")
                .build();
        DirectionsResult directions = DirectionsApi.getDirections(context, "Forsthausstrasse 41, 64739 Hoechst", "Hauptstrasse 33 A, 97282 Retzstadt").await();
    }*/

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

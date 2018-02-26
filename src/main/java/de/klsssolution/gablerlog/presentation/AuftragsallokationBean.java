package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.*;

@ManagedBean
@SessionScoped
public class AuftragsallokationBean {
    private int fahrzeugnummer;

    public int getFahrzeugnummer() {
        return fahrzeugnummer;
    }

    private Boolean fahrzeugAusgewaehlt = false;

    public void setFahrzeugnummer(int fahrzeugnummer) {
        fahrzeugAusgewaehlt = true;
        this.fahrzeugnummer = fahrzeugnummer;
    }

    public Boolean getFahrzeugAusgewaehlt() {
        return fahrzeugAusgewaehlt;
    }

    private List<Auftrag> nichtZugeordneteAuftraege = findeAlleNichtZugeordnetenAuftraege();
    private List<Auftrag> gewaehlteAuftraege = new ArrayList<>();

    public List<Auftrag> getGewaehlteAuftraege() {
        return gewaehlteAuftraege;
    }

    public List<Auftrag> getNichtZugeordneteAuftraege() {
        return nichtZugeordneteAuftraege;
    }

    private List<Auftrag> findeAlleNichtZugeordnetenAuftraege() {
        List<Auftrag> nichtZugeordneteAuftraege = new ArrayList<>();
        List<Tour> alleTouren = Tour.getAlleTouren();
        Set<Integer> idSet = new HashSet<Integer>();

        for (Tour tour : alleTouren) {
            if (tour.getAlleRouten() != null) {
                List<Route> verknuepfteRouten = tour.getAlleRouten();
                if (verknuepfteRouten.isEmpty()) {

                } else {
                    for (Route route : verknuepfteRouten) {
                        idSet.add(route.getId());
                        //Set mit allen Routenids, die einer Tour zugeordnet wurden
                        //--> diese dürfen  nicht angezeigt werden
                    }
                }
            }
        }

        List<Auftrag> alleAuftraege = Auftrag.getAlleAuftraege();
        for (Auftrag auftrag : alleAuftraege) {
            if (idSet.contains(auftrag.getRoute().getId())) {

            } else {
                nichtZugeordneteAuftraege.add(auftrag);
            }
        }
        return nichtZugeordneteAuftraege;
    }

    public void speichern() {
        //TODO: max. 5 Auftraege zuordnen, ansonsten Fehlermeldung
        if (gewaehlteAuftraege.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Speichern nicht möglich", "Keine Aufträge ausgewählt"));
            return;
        } else {
            Tour tour = new Tour();
            for (int i = 0; i < Fahrzeug.getFuhrpark().size(); i++) {
                if (Fahrzeug.getFuhrpark().get(i).getFahrzeugId() == fahrzeugnummer) {
                    tour.setFahrzeug(Fahrzeug.getFuhrpark().get(i));
                    System.out.println(fahrzeugnummer);
                }
            }
            List<Route> routen = new ArrayList<>();
            for (Auftrag auftrag : gewaehlteAuftraege) {
                routen.add(auftrag.getRoute());
            }
            tour.setAlleRouten(routen);
            tour.setErstellZeit(new Date());
            tour.setBezeichnung("Test");
            Tour.getAlleTouren().add(tour);
            if (tour.kapazitätPruefen(tour) == false) {
                System.out.println("Kapazität nicht ausreichend");
                Tour.alleTouren.remove(tour);
                tour = null;
                return;
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gespeichert", ""));
            }
        }
    }

    public void auftragAuswaehlen(Auftrag auftrag) {
        gewaehlteAuftraege.add(auftrag);
    }

    public void auftragEntfernen(Auftrag auftrag) {
        gewaehlteAuftraege.remove(auftrag);
    }
}

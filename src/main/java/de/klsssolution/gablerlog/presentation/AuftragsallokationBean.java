package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.*;

@ManagedBean
@ViewScoped
public class AuftragsallokationBean {
    private int fahrzeugnummer;

    private Date heute = new Date();

    private String beschreibung;

    private Date tourDatum;

    public int getFahrzeugnummer() {
        return fahrzeugnummer;
    }

    private Boolean fahrzeugAusgewaehlt = false;

    public void setFahrzeugnummer(int fahrzeugnummer) {
        fahrzeugAusgewaehlt = true;
        //fahrzeugAusgewählt auf true setzen, damit Tabellen in der Auftragsallokation angezeigt werden
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

    /*
    Alle Aufträge finden, die noch nicht in einer Tour eingeplant sind
     */
    private List<Auftrag> findeAlleNichtZugeordnetenAuftraege() {
        List<Auftrag> nichtZugeordneteAuftraege = new ArrayList<>();
        List<Tour> alleTouren = Tour.getAlleTouren();
        Set<Integer> idSet = new TreeSet<Integer>();

        for (Tour tour : alleTouren) {
            if (tour.getAlleRouten() != null) {
                List<Route> verknuepfteRouten = tour.getAlleRouten();
                if (verknuepfteRouten.isEmpty()) {

                } else {
                    for (Route route : verknuepfteRouten) {
                        idSet.add(route.getId());
                        //Set mit allen Routenids, die einer Tour zugeordnet wurden
                    }
                }
            }
        }

        List<Auftrag> alleAuftraege = Auftrag.getAlleAuftraege();
        for (Auftrag auftrag : alleAuftraege) {
            if (idSet.contains(auftrag.getRoute().getId())) {
                //ist die id enthalten, ist der Auftrag bereits einer Tour zugeordnet
            } else {
                nichtZugeordneteAuftraege.add(auftrag);
            }
        }
        return nichtZugeordneteAuftraege;
    }

    /*
    Tour erstellen mit Liste an Routen, die von den ausgewählten Aufträgen kommen
     */
    public void speichern() {
        if (gewaehlteAuftraege.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Speichern nicht möglich", "Keine Aufträge ausgewählt"));
            return;
        } else if (gewaehlteAuftraege.size() > 5) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Speichern nicht möglich", "Bitte maximal 5 Aufträge zuordnen"));
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
                auftrag.setStatus("Zugewiesen");
                routen.add(auftrag.getRoute());
            }
            System.out.println(tourDatum + beschreibung);
            tour.setStartDatum(tourDatum);
            tour.setAlleRouten(routen);
            tour.setBezeichnung(beschreibung);
            tour.setStatus("");
            Tour.getAlleTouren().add(tour);
            if (tour.kapazitätPruefen(tour) == false) {
                System.out.println("Kapazität nicht ausreichend");
                Tour.alleTouren.remove(tour);
                tour = null;
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

    public Date getTourDatum() {
        return tourDatum;
    }

    public void setTourDatum(Date tourDatum) {
        this.tourDatum = tourDatum;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        System.out.println("Setter: " + beschreibung);
        this.beschreibung = beschreibung;
    }

    public Date getHeute() {
        return heute;
    }
}

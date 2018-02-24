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
        Tour tour = new Tour();
        for (int i = 0; i < Fahrzeug.getFuhrpark().size(); i++) {
            if (Fahrzeug.getFuhrpark().get(i).getFahrzeugId() == fahrzeugnummer) {
                tour.setFahrzeug(Fahrzeug.getFuhrpark().get(i));
                System.out.println(fahrzeugnummer);
            } else System.out.println("Fahrzeug nicht vorhanden");
        }
        List<Route> routen = new ArrayList<>();
        for (Auftrag auftrag : gewaehlteAuftraege) {
            routen.add(auftrag.getRoute());
        }
        tour.setAlleRouten(routen);
        tour.setErstellZeit(new Date());
        tour.setBezeichnung("Test");
        Tour.getAlleTouren().add(tour);
        if (kapazitätPruefen(tour) == false) {
            tour = null;
            return;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gespeichert", ""));

    }

    public Boolean kapazitätPruefen(Tour tour) {
        if (gewichtPruefen(tour) == false || laengePruefen(tour) == false || breitePruefen(tour) == false || hoehePruefen(tour) == false) {
            return false;
        }
        return true;
    }

    public Boolean gewichtPruefen(Tour tour) {
        List<Route> routen = tour.getAlleRouten();
        double gesamtgewicht = 0;
        for (Route route : routen) {
            //Auftrag holen
            List<Auftrag> auftraege = Auftrag.getAlleAuftraege();
            for (Auftrag auftrag : auftraege) {
                if (auftrag.getRoute().equals(route)) {
                    gesamtgewicht = gesamtgewicht + auftrag.getLadung().getGewicht();
                }
            }
        }
        double verfuegbaresGewicht = tour.getFahrzeug().getMaximalGewicht() - tour.getFahrzeug().getLeergewicht();
        if (verfuegbaresGewicht < gesamtgewicht) {
            System.out.println("Ladung zu groß!" + " Gesamtgewicht: " + gesamtgewicht);
            System.out.println("Verfügbares Gewicht: " + verfuegbaresGewicht);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Gewicht zu groß!"));
            return false;
        } else {
            System.out.println("Gesamtgewicht: " + gesamtgewicht);
            System.out.println("Verfügbares Gewicht: " + verfuegbaresGewicht);

            return true;
        }
    }

    public Boolean laengePruefen(Tour tour) {
        List<Route> routen = tour.getAlleRouten();
        double gesamtlaenge = tour.getFahrzeug().getLaenge();
        for (Route route : routen) {
            //Auftrag holen
            List<Auftrag> auftraege = Auftrag.getAlleAuftraege();
            for (Auftrag auftrag : auftraege) {
                if (auftrag.getRoute().equals(route)) {
                    if (auftrag.getLadung().getLaenge() > gesamtlaenge) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Boolean breitePruefen(Tour tour) {
        List<Route> routen = tour.getAlleRouten();
        double gesamtbreite = tour.getFahrzeug().getBreite();
        for (Route route : routen) {
            //Auftrag holen
            List<Auftrag> auftraege = Auftrag.getAlleAuftraege();
            for (Auftrag auftrag : auftraege) {
                if (auftrag.getRoute().equals(route)) {
                    if (auftrag.getLadung().getBreite() > gesamtbreite) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Boolean hoehePruefen(Tour tour) {
        List<Route> routen = tour.getAlleRouten();
        double gesamthoehe = tour.getFahrzeug().getHoehe();
        for (Route route : routen) {
            //Auftrag holen
            List<Auftrag> auftraege = Auftrag.getAlleAuftraege();
            for (Auftrag auftrag : auftraege) {
                if (auftrag.getRoute().equals(route)) {
                    if (auftrag.getLadung().getHoehe() > gesamthoehe) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void auftragAuswaehlen(Auftrag auftrag) {
        gewaehlteAuftraege.add(auftrag);
    }

    public void auftragEntfernen(Auftrag auftrag) {
        gewaehlteAuftraege.remove(auftrag);

    }

    public void auftragAuswaehlen() {

    }

    public void auftragEntfernen() {

    }
}

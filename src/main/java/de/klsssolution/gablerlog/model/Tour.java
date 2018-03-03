package de.klsssolution.gablerlog.model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Tour {
    private int tourId;
    private String bezeichnung;
    private Date erstellZeit;
    private Date startDatum;
    private Date endzeitTatsaechlich;
    private String status;
    // Auto-Inkrement für TourId, beim Erstellen eines Tour-Objekts wird Wert um 1 erhöht und als tourId zugewiesen
    private static int count = 0;
    private List<Route> alleRouten;
    private Fahrzeug fahrzeug;

    public Tour() {
        erstellZeit = new Date();
        count = count + 1;
        status = "Inaktiv";
        tourId = count;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    public static List<Tour> alleTouren = tourenlisteErstellen();

    public static List<Tour> getAlleTouren() {
        return alleTouren;
    }

    public List<Route> getAlleRouten() {
        return alleRouten;
    }

    public void setAlleRouten(List<Route> alleRouten) {
        this.alleRouten = alleRouten;
    }

    public static void setAlleTouren(List<Tour> alleTouren) {
        Tour.alleTouren = alleTouren;
    }

    private static List<Tour> tourenlisteErstellen() {
        List<Tour> touren = new ArrayList<Tour>();

        Tour tour1 = new Tour();
        tour1.setBezeichnung("WÜ Stadt Mittwoch Vormittag");
        Route route = new Route();
        route.setDistanz(23);
        Adresse adresseStart = new Adresse();
        adresseStart.setOrt("München");
        route.setStartadresse(adresseStart);
        Adresse adresseZiel = new Adresse();
        adresseZiel.setOrt("Hamburg");
        route.setZieladresse(adresseZiel);
        List<Route> neueRoute = new ArrayList<Route>();
        neueRoute.add(route);
        tour1.setAlleRouten(neueRoute);
        tour1.setStartDatum(new Date(2018, 4, 3));
        tour1.setFahrzeug(Fahrzeug.getFuhrpark().get(0));
        touren.add(tour1);

        Tour tour2 = new Tour();
        tour2.setBezeichnung("WÜ Stadt Freitag Nachmittag");
        tour2.setStartDatum(new Date(2018, 5, 9));

        Route route2 = new Route();
        route2.setDistanz(23);
        Adresse adresseStart2 = new Adresse();
        adresseStart2.setOrt("Berlin");
        route2.setStartadresse(adresseStart2);
        Adresse adresseZiel2 = new Adresse();
        adresseZiel2.setOrt("Bremen");
        route2.setZieladresse(adresseZiel2);
        tour2.setFahrzeug(Fahrzeug.getFuhrpark().get(1));

        List<Route> neueRoute2 = new ArrayList<Route>();
        neueRoute2.add(route2);
        tour2.setAlleRouten(neueRoute2);
        tour2.setStartDatum(new Date(2018, 4, 6));
        touren.add(tour2);

        return touren;
    }


    public int getTourId() {
        return tourId;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public Date getErstellZeit() {
        return erstellZeit;
    }

    public Date getEndzeitTatsaechlich() {
        return endzeitTatsaechlich;
    }

    public Date getStartDatum() {
        return startDatum;
    }

    public String getStatus() {
        return status;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setErstellZeit(Date erstellZeit) {
        this.erstellZeit = erstellZeit;
    }

    public void setStartDatum(Date startDatum) {
        this.startDatum = startDatum;
    }

    public void setEndzeitTatsaechlich(Date endzeitTatsaechlich) {
        this.endzeitTatsaechlich = endzeitTatsaechlich;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//TODO parameter löschen
    public Boolean kapazitätPruefen(Tour tour) {
        if (tour.gewichtPruefen() == false || this.laengePruefen() == false || this.breitePruefen() == false || this.hoehePruefen() == false) {
            return false;
        }
        return true;
    }

    public Boolean gewichtPruefen() {
        List<Route> routen = this.getAlleRouten();
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
        double verfuegbaresGewicht = this.getFahrzeug().getMaximalGewicht() - this.getFahrzeug().getLeergewicht();
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

    public Boolean laengePruefen() {
        List<Route> routen = this.getAlleRouten();
        double gesamtlaenge = this.getFahrzeug().getLaenge();
        for (Route route : routen) {
            //Auftrag holen
            List<Auftrag> auftraege = Auftrag.getAlleAuftraege();
            for (Auftrag auftrag : auftraege) {
                if (auftrag.getRoute().equals(route)) {
                    if (auftrag.getLadung().getLaenge() > gesamtlaenge) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Ladung zu lang"));
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Boolean breitePruefen() {
        List<Route> routen = this.getAlleRouten();
        double gesamtbreite = this.getFahrzeug().getBreite();
        for (Route route : routen) {
            //Auftrag holen
            List<Auftrag> auftraege = Auftrag.getAlleAuftraege();
            for (Auftrag auftrag : auftraege) {
                if (auftrag.getRoute().equals(route)) {
                    if (auftrag.getLadung().getBreite() > gesamtbreite) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Ladung zu breit!"));
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Boolean hoehePruefen() {
        List<Route> routen = this.getAlleRouten();
        double gesamthoehe = this.getFahrzeug().getHoehe();
        for (Route route : routen) {
            //Auftrag holen
            List<Auftrag> auftraege = Auftrag.getAlleAuftraege();
            for (Auftrag auftrag : auftraege) {
                if (auftrag.getRoute().equals(route)) {
                    if (auftrag.getLadung().getHoehe() > gesamthoehe) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Ladung zu hoch!"));
                        return false;
                    }
                }
            }
        }
        return true;
    }


}





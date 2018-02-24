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
    private LocalDateTime faelligkeitsZeit;
    private LocalDateTime endzeitTatsaechlich;
    private String status;
    // Auto-Inkrement für TourId, beim Erstellen eines Tour-Objekts wird Wert um 1 erhöht und als tourId zugewiesen
    private static final AtomicInteger count = new AtomicInteger(0);
    private List<Route> alleRouten;
    private Fahrzeug fahrzeug;

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
        tour1.setTourId();
        tour1.setBezeichnung("WÜ Stadt Mittwoch Vormittag");
        Route route = new Route();
        route.setDistanz(23);
        route.setId(4);
        List<Route> neueRoute = new ArrayList<Route>();
        neueRoute.add(route);
        tour1.setAlleRouten(neueRoute);
        tour1.setFaelligkeitsZeit(ZeitFormat.zeitstempelErzeugen("2018-03-06 10:30"));
        touren.add(tour1);

        Tour tour2 = new Tour();
        tour2.setTourId();
        tour2.setBezeichnung("WÜ Stadt Freitag Nachmittag");
        tour2.setFaelligkeitsZeit(ZeitFormat.zeitstempelErzeugen("2018-03-18 14:30"));
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

    public LocalDateTime getEndzeitTatsaechlich() {
        return endzeitTatsaechlich;
    }

    public LocalDateTime getFaelligkeitsZeit() {
        return faelligkeitsZeit;
    }

    public String getStatus() {
        return status;
    }

    public void setTourId() {
        this.tourId = count.incrementAndGet();
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setErstellZeit(Date erstellZeit) {
        this.erstellZeit = erstellZeit;
    }

    public void setFaelligkeitsZeit(LocalDateTime faelligkeitsZeit) {
        this.faelligkeitsZeit = faelligkeitsZeit;
    }

    public void setEndzeitTatsaechlich(LocalDateTime endzeitTatsaechlich) {
        this.endzeitTatsaechlich = endzeitTatsaechlich;
    }

    public void setStatus(String status) {
        this.status = status;
    }


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
                        return false;
                    }
                }
            }
        }
        return true;
    }


}





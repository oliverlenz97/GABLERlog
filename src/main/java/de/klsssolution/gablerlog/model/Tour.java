package de.klsssolution.gablerlog.model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.text.SimpleDateFormat;
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
        Adresse adresseStart = new Adresse();
        adresseStart.setStrasse("Stahlgruberring");
        adresseStart.setHausnummer(22);
        adresseStart.setPostleitzahl(81829);
        adresseStart.setOrt("München");
        route.setStartadresse(adresseStart);

        Adresse adresseZiel = new Adresse();
        adresseZiel.setStrasse("Erzbergerstraße");
        adresseZiel.setHausnummer(1);
        adresseZiel.setPostleitzahl(22765);
        adresseZiel.setOrt("Hamburg");
        route.setZieladresse(adresseZiel);

        Route route1 = new Route();
        Adresse adresseStart1 = new Adresse();
        adresseStart1.setStrasse("Frankfurter Straße");
        adresseStart1.setHausnummer(1);
        adresseStart1.setPostleitzahl(64720);
        adresseStart1.setOrt("Michelstadt");
        route1.setStartadresse(adresseStart1);

        Adresse adresseZiel1 = new Adresse();
        adresseZiel1.setStrasse("Memelstraße");
        adresseZiel1.setHausnummer(2);
        adresseZiel1.setPostleitzahl(90453);
        adresseZiel1.setOrt("Nürnberg");
        route1.setZieladresse(adresseZiel1);


        Route route5 = new Route();
        Adresse adresseStart5 = new Adresse();
        adresseStart5.setStrasse("Heubergweg");
        adresseStart5.setHausnummer(5);
        adresseStart5.setPostleitzahl(64732);
        adresseStart5.setOrt("Bad König");
        route5.setStartadresse(adresseStart5);

        Adresse adresseZiel5 = new Adresse();
        adresseZiel5.setStrasse("Bahnhofstraße");
        adresseZiel5.setHausnummer(13);
        adresseZiel5.setPostleitzahl(64732);
        adresseZiel5.setOrt("Bad König");
        route5.setZieladresse(adresseZiel5);


        List<Route> neueRoute = new ArrayList<Route>();
        neueRoute.add(route);
        neueRoute.add(route1);
        neueRoute.add(route5);
        tour1.setAlleRouten(neueRoute);
        tour1.setStartDatum(new Date(118, 4, 3));
        tour1.setFahrzeug(Fahrzeug.getFuhrpark().get(0));
        touren.add(tour1);

        Tour tour2 = new Tour();
        tour2.setBezeichnung("WÜ Stadt Freitag Nachmittag");
        tour2.setStartDatum(new Date(118, 5, 9));

        Route route2 = new Route();
        route2.setDistanz(23);
        Adresse adresseStart2 = new Adresse();
        adresseStart2.setStrasse("Markt");
        adresseStart2.setHausnummer(1);
        adresseStart2.setPostleitzahl(4668);
        adresseStart2.setOrt("Grimma");
        route2.setStartadresse(adresseStart2);
        Adresse adresseZiel2 = new Adresse();
        adresseZiel2.setStrasse("Tannenweg");
        adresseZiel2.setHausnummer(8);
        adresseZiel2.setPostleitzahl(14547);
        adresseZiel2.setOrt("Beelitz");
        route2.setZieladresse(adresseZiel2);

        Route route3 = new Route();
        route3.setDistanz(23);
        Adresse adresseStart3 = new Adresse();
        adresseStart3.setStrasse("Margaretenstraße");
        adresseStart3.setHausnummer(37);
        adresseStart3.setPostleitzahl(12203);
        adresseStart3.setOrt("Berlin");
        route3.setStartadresse(adresseStart3);
        Adresse adresseZiel3 = new Adresse();
        adresseZiel3.setStrasse("Schragestraße");
        adresseZiel3.setHausnummer(4);
        adresseZiel3.setPostleitzahl(28239);
        adresseZiel3.setOrt("Bremen");
        route3.setZieladresse(adresseZiel3);

        tour2.setFahrzeug(Fahrzeug.getFuhrpark().get(1));

        List<Route> neueRoute2 = new ArrayList<Route>();
        neueRoute2.add(route2);
        neueRoute2.add(route3);

        tour2.setAlleRouten(neueRoute2);
        tour2.setStartDatum(new Date(118, 4, 6));
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

    public Boolean kapazitätPruefen() {
        if (this.gewichtPruefen() == false || this.laengePruefen() == false || this.breitePruefen() == false || this.hoehePruefen() == false) {
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

    public String datumAusgeben(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat format = new SimpleDateFormat("E, d.M.y");
            return format.format(date);
        }
    }
}





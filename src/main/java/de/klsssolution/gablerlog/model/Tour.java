package de.klsssolution.gablerlog.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Tour {
    private int tourId;
    private String bezeichnung;
    private LocalDateTime erstellZeit;
    private LocalDateTime faelligkeitsZeit;
    private LocalDateTime endzeitTatsaechlich;
    private String status;
    // Auto-Inkrement für TourId, beim Erstellen eines Tour-Objekts wird Wert um 1 erhöht und als tourId zugewiesen
    private static final AtomicInteger count = new AtomicInteger(0);
    private Route[] routen;

    public static List<Tour> alleTouren = tourenlisteErstellen();

    public static List<Tour> getAlleTouren() {
        return alleTouren;
    }

    public static void setAlleTouren(List<Tour> alleTouren) {
        Tour.alleTouren = alleTouren;
    }

    private static List<Tour> tourenlisteErstellen() {
        List<Tour> touren = new ArrayList<Tour>();

        Tour tour1 = new Tour();
        tour1.setTourId();
        tour1.setBezeichnung("WÜ Stadt Mittwoch Vormittag");
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

    public LocalDateTime getErstellZeit() {
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

    public void setErstellZeit(LocalDateTime erstellZeit) {
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

}





package de.klsssolution.gablerlog.model;

import java.time.LocalDateTime;
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





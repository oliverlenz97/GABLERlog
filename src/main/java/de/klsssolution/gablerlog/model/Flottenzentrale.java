package de.klsssolution.gablerlog.model;

public class Flottenzentrale {

    public static final Adresse ZENTRALEN_ADRESSE = createAdresse();

    private static Adresse createAdresse() {
        Adresse adresse = new Adresse();
        adresse.setStrasse("Lohrtalweg");
        adresse.setHausnummer(10);
        adresse.setOrt("Mosbach");
        adresse.setPostleitzahl(74821);
        return adresse;
    }

    public Adresse getZENTRALEN_ADRESSE() {
        return ZENTRALEN_ADRESSE;
    }
}

package de.klsssolution.gablerlog.model;

public class Flottenzentrale {

    public static final Adresse ZENTRALEN_ADRESSE = createAdresse();

    private String mapsAdresseZentrale = ZENTRALEN_ADRESSE.getOrt();
    // public String mapsAdresseZentrale = ZENTRALEN_ADRESSE.getStrasse() + " " + ZENTRALEN_ADRESSE.getHausnummer() + ", " + ZENTRALEN_ADRESSE.getPostleitzahl() + " " + ZENTRALEN_ADRESSE.getOrt() + ", " + ZENTRALEN_ADRESSE.getLand();


    private static Adresse createAdresse() {
        Adresse adresse = new Adresse();
        adresse.setStrasse("Lohrtalweg");
        adresse.setHausnummer(10);
        adresse.setOrt("Mosbach");
        adresse.setPostleitzahl(74821);
        adresse.setLand("Deutschland");
        return adresse;
    }

    public String getMapsAdresseZentrale() {
        return mapsAdresseZentrale;
    }


}

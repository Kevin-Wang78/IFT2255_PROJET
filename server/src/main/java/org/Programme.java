package org.udem.ift2255;

public class Programme {
    private String prefixe;
    private String id;
    private String nom;
    private int creditsExiges;
    private Bloc[] blocsObligatoire;
    private Orientation[] orientations;
    private Faculte faculte;
    
    public Programme(String prefixe, String id, String nom, int creditsExiges, Bloc[] blocsObligatoire,
             Orientation[] orientations, Faculte faculte) {
        this.prefixe = prefixe;
        this.id = id;
        this.nom = nom;
        this.creditsExiges = creditsExiges;
        this.blocsObligatoire = blocsObligatoire;
        this.orientations = orientations;
        this.faculte = faculte;

    }

}
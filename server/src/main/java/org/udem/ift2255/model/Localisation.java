package org.udem.ift2255.model;
import java.time.LocalDate;

public class Localisation {
    private String id;
    private String ville;
    private LocalDate campus;
    private String batiment;

    public Localisation(String id, String ville, LocalDate campus, String batiment) {
        this.id = id;
        this.ville = ville;
        this.campus = campus;
        this.batiment = batiment;

    }
}
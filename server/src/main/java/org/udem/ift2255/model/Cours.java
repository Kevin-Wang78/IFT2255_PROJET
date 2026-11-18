package org.udem.ift2255.model;

public class Cours {
    private String code;
    private String nom;
    private String description;
    private Cours[] prealables;
    private int credits;
    private float difficulteMoyenne;
    private float heuresMoyennes;
    private String[] commentaires;


    public Cours(String code, String nom, String description,
             Cours[] prealables, int credits,
             float difficulteMoyenne, float heuresMoyennes,
             String[] commentaires) {
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.prealables = prealables;
        this.credits = credits;
        this.difficulteMoyenne = difficulteMoyenne;
        this.heuresMoyennes = heuresMoyennes;
        this.commentaires = commentaires;
    }
}
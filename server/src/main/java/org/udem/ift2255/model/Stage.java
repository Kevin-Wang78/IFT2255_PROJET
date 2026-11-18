package org.udem.ift2255.model;
import java.time.LocalDate;

public class Stage {
    private String id;
    private String titre;
    private String description;
    private String entreprise;
    private LocalDate DateDebut;
    private LocalDate DateFin;
    private String lieu;
    private int remuneration;

    public Stage(String id, String titre, String description, String entreprise, 
                 LocalDate DateDebut, LocalDate DateFin, String lieu, int remuneration) {
                    this.id = id;
                    this.titre = titre;
                    this.description = description;
                    this.entreprise = entreprise;
                    this.DateDebut = DateDebut;
                    this.DateFin = DateFin;
                    this.lieu = lieu;
                    this.remuneration = remuneration;
                }

}
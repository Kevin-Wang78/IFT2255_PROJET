package org.udem.ift2255.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Seance {
    private String id;
    private TypeSeance typeSeance;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private int jourSemaine;
    private String mode; //pas trop sur de ce que celui-ci represente
    private String salle;
    private String batiment;
    private String campus;

    public Seance(String id, TypeSeance typeSeance, LocalDate dateDebut, LocalDate dateFin, LocalTime heureDebut, LocalTime heureFin
                    , int jourSemaine, String mode, String salle, String batiment, String campus) {
                        this.id = id;
                        this.typeSeance = typeSeance;
                        this.dateDebut = dateDebut;
                        this.dateFin = dateFin;
                        this.heureDebut = heureDebut;
                        this.heureFin = heureFin;
                        this.jourSemaine = jourSemaine;
                        this.mode = mode;
                        this.salle = salle;
                        this.batiment = batiment;
                        this.campus = campus;
                    }
}

package org.udem.ift2255;

public class Commentaire {
    private String id;
    private Cours cours;
    private float difficulte;

    public Commentaire(String id, Cours cours, float difficulte) {
        this.id = id;
        this.cours = cours;
        this.difficulte = difficulte;

        
    }

}
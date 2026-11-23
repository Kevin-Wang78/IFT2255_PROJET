package org.udem.ift2255.model;

import java.time.LocalDate;
import java.util.List;

public class GroupeCours {
    private String id;
    private String course_id; //je n'ai pas tous les infos de cours pour creer un cours alors je l'ai simplifie au sigle du cours
    //private String groupe; //je trouve pas le groupe
    private String session;
    private List<String> professeurs; //il peut y avoir plusieurs profs pour un cours
    //private String[] profAssistants; //je le trouve pas dans le response body json
    private List<Seance> seances;
    private LocalDate disponibleDepuis;

    public GroupeCours (String id, String course_id, String session, List<String> professeurs, List<Seance> seances, LocalDate disponibleDepuis){
        this.id = id;
        this.course_id = course_id;
        this.session = session;
        this.professeurs = professeurs;
        this.seances = seances;
        this.disponibleDepuis = disponibleDepuis;
    }


}
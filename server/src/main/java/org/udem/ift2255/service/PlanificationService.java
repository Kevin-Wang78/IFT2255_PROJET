package org.udem.ift2255.service;

import org.udem.ift2255.DTO.ProgramBaseDTO;
import org.udem.ift2255.config.ConfigLoader;
import org.udem.ift2255.model.GroupeCours;
import org.udem.ift2255.model.Seance;
import org.udem.ift2255.model.TypeSeance;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

public class PlanificationService {
    private final static String apiUrl = ConfigLoader.API_URL;

    public final List<ProgramBaseDTO> getProgramList() {

        String url = apiUrl + "/faculties";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());
            List<JsonNode> resultList = mapper.convertValue(root, new TypeReference<List<JsonNode>>() {});

            List <ProgramBaseDTO> programList = new ArrayList<>();
            //iterate to extract data
            resultList.forEach(faculty -> faculty.path("departments")
                    .forEach(department -> department.path("programs")
                            .forEach(prog -> {
                                if (!prog.isNull()) {
                                    ProgramBaseDTO progdto = new ProgramBaseDTO(prog.path("id").asString(),
                                            prog.path("name").asString());
                                    programList.add(progdto);
                                }
                            })));

            return programList;
        }catch (Exception e) {
            return List.of();
        }
    }

    public final List<GroupeCours> getScheduleList(String[] cours, String session) {

        String url = apiUrl + "/schedules?courses=";
        int i=0;
        boolean loop = true;

        do {
            url += cours;
            i++;
            loop = i<cours.length;

            if (loop){
                url += ",";
            }

        } while (loop);
        
        url += "&semester=" + session;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());
            List<JsonNode> resultList = mapper.convertValue(root, new TypeReference<List<JsonNode>>() {});
            
            List<GroupeCours> groupeCoursList = new ArrayList<>();
            resultList.forEach(elem -> elem.path("semesters")
                        .forEach(semesters -> semesters.path("courses")
                        .forEach(courses -> {

                            //id
                            final String id = courses.path("id").asString();
                            //course_id
                            final String course_id = courses.path("course_id").asString();
                            //session
                            final String sessionLabel = courses.path("semester").asString();
                            //last updated
                            final LocalDate disponibleDepuis = LocalDate.parse(courses.path("updated_at").asString());
                            //profs
                            List<String> profs = new ArrayList<String>();
                            //seances
                            List<Seance> seanceList = new ArrayList<>();

                            if (courses.path("sections") != null) {
                                courses.path("sections").forEach(sections -> {

                                    //id
                                    final String id_section = sections.path("id").asString();
                                    
                                    //profs
                                    if (sections.path("teachers") != null) {
                                        sections.path("teachers").forEach(teachers -> {
                                            profs.add(teachers.asString());
                                        });
                                    }
                                    

                                    if (sections.path("meetings") != null){
                                        sections.path("meetings").forEach(meetingsList -> {
                                                
                                            //typeSeance
                                            final TypeSeance typeSeance;
                                            switch (meetingsList.path("kind").asString()){
                                                case "TH" : typeSeance = TypeSeance.THEORIE;
                                                    break;
                                                case "TP" : typeSeance = TypeSeance.PRATIQUE;
                                                    break;
                                                default : 
                                                    throw new IllegalArgumentException("Type de seance inconnu");
                                            }

                                            //jourSemaine
                                            final int jourSemaine = Integer.parseInt(meetingsList.path("weekday").asString());
                                            //heureDebut
                                            final LocalTime heureDebut = LocalTime.parse(meetingsList.path("start_time").asString());
                                            //heureFin
                                            final LocalTime heureFin = LocalTime.parse(meetingsList.path("end_time").asString());

                                            if (sections.path("periods") != null){
                                                sections.path("periods").forEach(periodsList -> {

                                                    //dateDebut
                                                    final LocalDate dateDebut = LocalDate.parse(periodsList.path("start_date").asString());
                                                    //dateFin
                                                    final LocalDate dateFin = LocalDate.parse(periodsList.path("end_date").asString());
                                                    //mode
                                                    final String mode = periodsList.path("mode").asString();

                                                    if (periodsList.path("location") != null){
                                                        JsonNode locationNode = periodsList.path("location");

                                                        //campus
                                                        final String campus = locationNode.path("campus").asString();
                                                        //batiment
                                                        final String batiment = locationNode.path("building").asString();
                                                        //salle
                                                        final String salle = locationNode.path("room").asString();


                                                        //ajouter la seance dans la liste de seances
                                                        seanceList.add(new Seance(id_section, typeSeance, dateDebut, dateFin, heureDebut, heureFin
                                                            ,jourSemaine, mode, salle, batiment, campus));
                                                    }//location
                                                });
                                            }//periods
                                        });
                                    }//meetings

                                    if (sections.path("exams") != null){
                                        sections.path("exams").forEach(examsList -> {

                                            //typeSeance
                                            final TypeSeance typeSeance;
                                            switch (examsList.path("kind").asString()) {
                                                case "intra" : typeSeance = TypeSeance.INTRA;
                                                    break;
                                                case "final" : typeSeance = TypeSeance.FINAL;
                                                    break;
                                                default :
                                                    throw new IllegalArgumentException("Type de seance inconnu");
                                            }

                                            //date
                                            final LocalDate date = LocalDate.parse(examsList.path("date").asString());
                                            //heureDebut
                                            final LocalTime heureDebut = LocalTime.parse(examsList.path("start_time").asString());
                                            //heureFin
                                            final LocalTime heureFin = LocalTime.parse(examsList.path("end_time").asString());
                                            //mode
                                            final String mode = examsList.path("mode").asString();
                                            //jourSemaine
                                            final int jourSemaine = date.getDayOfWeek().getValue();

                                            if (examsList.path("locations") != null){
                                                examsList.path("locations").forEach(locations -> {

                                                    JsonNode locationNode = locations.path("location");
                                                    //campus
                                                    final String campus = locationNode.path("campus").asString();
                                                    //batiment
                                                    final String batiment = locationNode.path("building").asString();
                                                    //salle
                                                    final String salle = locationNode.path("room").asString();

                                                    //ajouter la seance dans la liste de seances
                                                    seanceList.add(new Seance(id_section, typeSeance, date, date, heureDebut, heureFin
                                                        ,jourSemaine, mode, salle, batiment, campus));

                                                });
                                            }//locations
                                        });
                                    }//exams
                                    
                                });
                            }//sections

                            //ajouter le groupeCours dans la liste de groupeCours
                            groupeCoursList.add(new GroupeCours(id, course_id, sessionLabel, profs, seanceList, disponibleDepuis));

                        })));//courses

            return groupeCoursList;
        } catch (Exception e){
            return List.of();
        }

    }//fin getScheduleList

}

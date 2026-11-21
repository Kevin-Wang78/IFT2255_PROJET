package org.udem.ift2255.service;

import org.udem.ift2255.DTO.ProgramBaseDTO;
import org.udem.ift2255.config.ConfigLoader;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

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

}

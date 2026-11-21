package org.udem.ift2255;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson3;
import org.udem.ift2255.controller.PlanificationController;
import org.udem.ift2255.controller.SearchController;
import org.udem.ift2255.controller.UtilisateurController;
import org.udem.ift2255.config.ConfigLoader;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {
    static void main() {

        PlanificationController planificationController = new PlanificationController();
        UtilisateurController utilisateurController = new UtilisateurController();
        SearchController searchController = new SearchController();

        String baseUrl = ConfigLoader.API_URL;
        IO.print(baseUrl);
        String appUrl = ConfigLoader.CLIENT_APP_URL;
        IO.print(appUrl);

        var app = Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.result("Hello ift2255"));

            config.routes.apiBuilder(() -> {
                path("/planification", () -> {
                    path("/programs", () -> {
                        get(planificationController::getAllPrograms);
                    });
                    post(planificationController::createPlannification);
                });
            });

            config.routes.apiBuilder(() -> {
                path("/user", () -> {
                    // add methods
                });
            });

            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(it -> {
                    it.allowHost(appUrl);
                    it.allowCredentials = true;
                });
            });

            config.jsonMapper(new JavalinJackson3().updateMapper(mapper -> {
                mapper.changeDefaultPropertyInclusion(incl -> incl
                        .withValueInclusion(JsonInclude.Include.NON_NULL)
                        .withContentInclusion(JsonInclude.Include.NON_NULL)
                );
            }));

        }).start(7070);
    }
}

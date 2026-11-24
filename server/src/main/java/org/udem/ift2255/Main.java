package org.udem.ift2255;
import org.udem.ift2255.config.ConfigLoader;
import org.udem.ift2255.controller.PlanificationController;
import org.udem.ift2255.controller.SearchController;
import org.udem.ift2255.controller.UtilisateurController;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import io.javalin.json.JavalinJackson3;

// Pour faire run le backend, juste faire run le Main dans Main.java
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

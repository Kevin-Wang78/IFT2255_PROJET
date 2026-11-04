package org.udem.ift2255;
import io.javalin.Javalin;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        var app = Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.result("Hello ift2255"));
        }).start(7070);
    }
}

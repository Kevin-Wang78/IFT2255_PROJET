package org.udem.ift2255.controller;

import io.javalin.http.Context;
import org.udem.ift2255.DTO.PlanificationDTO;
import org.udem.ift2255.DTO.ProgramBaseDTO;
import org.udem.ift2255.utils.ResultResponse;

import java.util.ArrayList;
import java.util.List;

public class PlanificationController {

    public final void getAllPrograms(Context ctx) {
        ProgramBaseDTO example = new ProgramBaseDTO("117510", "Informatique");
        List<ProgramBaseDTO> list = new ArrayList<>();
        list.add(example);
        ctx.json(list);
        ctx.status(200);
    }

    public final void createPlannification(Context ctx) {
        ctx.result("planification created");
    }
}

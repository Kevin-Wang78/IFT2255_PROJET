package org.udem.ift2255.controller;

import io.javalin.http.Context;
import org.udem.ift2255.DTO.ProgramBaseDTO;
import org.udem.ift2255.service.PlanificationService;
import org.udem.ift2255.utils.ResultResponse;
import java.util.List;

public class PlanificationController {

    PlanificationService planificationService = new PlanificationService();

    public final void getAllPrograms(Context ctx) {
        List<ProgramBaseDTO> returnList = planificationService.getProgramList();
        ResultResponse<List<ProgramBaseDTO>> result = new ResultResponse<>();

        if (!returnList.isEmpty()) {
            result.setSuccess(true);
            result.setData(returnList);
            ctx.json(result);
            ctx.status(200);
        } else {
            result.setSuccess(false);
            result.setMessage("Programs not found");
            ctx.json(result);
            ctx.status(404);
        }

    }

    public final void createPlannification(Context ctx) {
        ctx.result("planification created");
    }
}

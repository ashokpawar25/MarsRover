package com.amaap.marsrover.controller;

import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.service.RoverService;
import com.amaap.marsrover.service.exception.RoverNotFoundException;

public class RoverController {
    private final RoverService roverService;

    public RoverController(RoverService roverService) {
        this.roverService = roverService;
    }

    public Response create() {
        roverService.create();
        return new Response(HttpStatus.OK,"Rover Created Successfully");
    }

    public RoverDto find(int id) throws RoverNotFoundException {
        return roverService.find(id);
    }
}
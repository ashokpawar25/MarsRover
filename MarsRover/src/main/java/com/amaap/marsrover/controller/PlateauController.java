package com.amaap.marsrover.controller;

import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.service.PlateauService;

public class PlateauController {
    private final PlateauService plateauService;
    public PlateauController(PlateauService plateauService) {
        this.plateauService = plateauService;
    }

    public Response create(int length, int breadth) throws InvalidPlateauDimensionsException {
        plateauService.create(length,breadth);
        return new Response(HttpStatus.OK,"Plateau created successfully");
    }
}

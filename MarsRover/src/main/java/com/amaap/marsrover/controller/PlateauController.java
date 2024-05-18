package com.amaap.marsrover.controller;

import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.service.PlateauService;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;

public class PlateauController {
    private final PlateauService plateauService;
    public PlateauController(PlateauService plateauService) {
        this.plateauService = plateauService;
    }

    public Response create(int length, int breadth){
        try {
            plateauService.create(length,breadth);
            return new Response(HttpStatus.OK,"Plateau created successfully");

        } catch (InvalidPlateauDimensionsException e) {
            return new Response(HttpStatus.BADREQUEST,e.getMessage());
        }
    }

    public PlateauDto find(int id) throws PlateauNotFoundException {
        return plateauService.find(id);
    }
}

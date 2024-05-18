package com.amaap.marsrover.controller;

import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.domain.model.valueobject.Coordinate;
import com.amaap.marsrover.domain.model.valueobject.Direction;
import com.amaap.marsrover.service.PlateauService;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverAlreadyDeployedException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;

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


    public Response deployRover(int roverId, int plateauId, Coordinate coordinate, Direction direction) {
        try {
            plateauService.deployRover(roverId,plateauId,coordinate,direction);
            return new Response(HttpStatus.OK,"Rover deployed on plateau successfully");
        } catch (RoverNotFoundException | PlateauNotFoundException e) {
            return new Response(HttpStatus.NOTFOUND,e.getMessage());
        } catch (RoverAlreadyDeployedException e) {
            return new Response(HttpStatus.BADREQUEST,e.getMessage());
        }
    }
}

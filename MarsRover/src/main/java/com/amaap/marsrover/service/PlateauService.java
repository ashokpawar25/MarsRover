package com.amaap.marsrover.service;

import com.amaap.marsrover.domain.model.entity.DeployedRoverDto;
import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.domain.model.valueobject.Coordinate;
import com.amaap.marsrover.domain.model.valueobject.Direction;
import com.amaap.marsrover.repository.PlateauRepository;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverAlreadyDeployedException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import jakarta.inject.Inject;

public class PlateauService {
    private final PlateauRepository plateauRepository;
    private final RoverService roverService;
    @Inject
    public PlateauService(PlateauRepository plateauRepository,RoverService roverService) {
        this.plateauRepository = plateauRepository;
        this.roverService = roverService;
    }

    public PlateauDto create(int length, int breadth) throws InvalidPlateauDimensionsException {
        return plateauRepository.add(length,breadth);
    }

    public PlateauDto find(int id) throws PlateauNotFoundException {
        PlateauDto plateau = plateauRepository.find(id);
        if(plateau == null) throw new PlateauNotFoundException("Plateau with id:"+id+" not found");
        return plateau;
    }

    public PlateauDto deployRover(int roverId, int plateauId, Coordinate coordinate, Direction direction) throws RoverNotFoundException, PlateauNotFoundException, RoverAlreadyDeployedException {
        RoverDto rover = roverService.find(roverId);
        if(rover.isDeployed()) throw new RoverAlreadyDeployedException("Rover with id:"+roverId+" is already deployed");
        PlateauDto plateau = this.find(plateauId);
        plateau.addRover(new DeployedRoverDto(rover.getId(),coordinate,direction));
        rover.setDeployed();
        return plateau;
    }
}

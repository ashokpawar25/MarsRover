package com.amaap.marsrover;

import com.amaap.marsrover.domain.model.entity.DeployedRoverDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.domain.model.valueobject.Coordinate;
import com.amaap.marsrover.domain.model.valueobject.Direction;
import com.amaap.marsrover.domain.service.exception.InvalidInstructionException;
import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.marsrover.repository.impl.InMemoryPlateauRepository;
import com.amaap.marsrover.repository.impl.InMemoryRoverRepository;
import com.amaap.marsrover.service.InstructionService;
import com.amaap.marsrover.service.PlateauService;
import com.amaap.marsrover.service.RoverService;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverAlreadyDeployedException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;

public class Main {
    public static void main(String[] args) throws InvalidPlateauDimensionsException, RoverNotFoundException, PlateauNotFoundException, RoverAlreadyDeployedException, InvalidInstructionException {
        InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
        RoverService roverService = new RoverService(new InMemoryRoverRepository(inMemoryDatabase));
        PlateauService plateauService = new PlateauService(new InMemoryPlateauRepository(inMemoryDatabase),roverService);
        InstructionService instructionService = new InstructionService(plateauService);
        Coordinate coordinate = new Coordinate(1,2);
        roverService.create();
        plateauService.create(5,5);
        plateauService.deployRover(1,1,coordinate, Direction.N);
        DeployedRoverDto rover = instructionService.processInstructions(1, 1, "LMLMLMLMM");
        Coordinate coordinates = rover.getCoordinate();
        Direction direction = rover.getDirection();
        System.out.println("Position of rover is "+coordinates.getX()+" "+coordinates.getY()+" , and direction is "+direction);
    }
}

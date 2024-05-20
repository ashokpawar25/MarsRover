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
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) throws InvalidPlateauDimensionsException, RoverNotFoundException, PlateauNotFoundException, RoverAlreadyDeployedException, InvalidInstructionException {
        Injector injector = Guice.createInjector(new AppModule());
        RoverService roverService = injector.getInstance(RoverService.class);
        PlateauService plateauService = injector.getInstance(PlateauService.class);
        InstructionService instructionService = injector.getInstance(InstructionService.class);
        Coordinate coordinate = new Coordinate(1,2);
        roverService.create();
        plateauService.create(5,5);
        plateauService.deployRover(1,1,coordinate, Direction.N);
        DeployedRoverDto rover = instructionService.processInstructions(1, 1, "LMLMLMLMM");
        Coordinate coordinates = rover.getCoordinate();
        Direction direction = rover.getDirection();
        System.out.println("Position of rover is "+coordinates.getX()+","+coordinates.getY()+" and direction is "+direction);
    }
}

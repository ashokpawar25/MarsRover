package com.amaap.marsrover.service;

import com.amaap.marsrover.controller.InstructionController;
import com.amaap.marsrover.domain.model.entity.DeployedRoverDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.domain.model.valueobject.Coordinate;
import com.amaap.marsrover.domain.model.valueobject.Direction;
import com.amaap.marsrover.domain.service.exception.InvalidInstructionException;
import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.marsrover.repository.impl.InMemoryPlateauRepository;
import com.amaap.marsrover.repository.impl.InMemoryRoverRepository;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverAlreadyDeployedException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionServiceTest {

    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    RoverService roverService = new RoverService(new InMemoryRoverRepository(inMemoryDatabase));
    PlateauService plateauService = new PlateauService(new InMemoryPlateauRepository(inMemoryDatabase),roverService);
    InstructionService instructionService = new InstructionService(plateauService);

    @Test
    void shouldBeAbleToProcessInstruction() throws InvalidPlateauDimensionsException, RoverNotFoundException, PlateauNotFoundException, RoverAlreadyDeployedException, InvalidInstructionException {
        // arrange
        int length = 5;
        int breadth = 5;
        DeployedRoverDto expected = new DeployedRoverDto(1,new Coordinate(1,3), Direction.N);

        // act
        roverService.create();
        plateauService.create(length,breadth);
        plateauService.deployRover(1,1,new Coordinate(1,2), Direction.N);
        DeployedRoverDto actual = instructionService.processInstructions(1,1,"LMLMLMLMM");

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenRoverIsNotFoundOnPlateau() throws InvalidPlateauDimensionsException, RoverNotFoundException, PlateauNotFoundException, RoverAlreadyDeployedException, InvalidInstructionException {
        // arrange
        int length = 5;
        int breadth = 5;

        // act
        plateauService.create(length,breadth);

        // assert
        assertThrows(RoverNotFoundException.class,()->instructionService.processInstructions(1,1,"LMLMLMLMM"));
    }
}
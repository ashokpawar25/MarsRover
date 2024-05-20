package com.amaap.marsrover.service;

import com.amaap.marsrover.AppModule;
import com.amaap.marsrover.domain.model.entity.DeployedRoverDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.domain.model.valueobject.Coordinate;
import com.amaap.marsrover.domain.model.valueobject.Direction;
import com.amaap.marsrover.domain.service.exception.InvalidInstructionException;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverAlreadyDeployedException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InstructionServiceTest {
    RoverService roverService;
    PlateauService plateauService;
    InstructionService instructionService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        roverService = injector.getInstance(RoverService.class);
        plateauService = injector.getInstance(PlateauService.class);
        instructionService = injector.getInstance(InstructionService.class);
    }

    @Test
    void shouldBeAbleToProcessInstruction() throws InvalidPlateauDimensionsException, RoverNotFoundException, PlateauNotFoundException, RoverAlreadyDeployedException, InvalidInstructionException {
        // arrange
        int length = 5;
        int breadth = 5;
        DeployedRoverDto expected = new DeployedRoverDto(1, new Coordinate(1, 3), Direction.N);

        // act
        roverService.create();
        plateauService.create(length, breadth);
        plateauService.deployRover(1, 1, new Coordinate(1, 2), Direction.N);
        DeployedRoverDto actual = instructionService.processInstructions(1, 1, "LMLMLMLMM");

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenRoverIsNotFoundOnPlateau() throws InvalidPlateauDimensionsException, RoverNotFoundException, PlateauNotFoundException, RoverAlreadyDeployedException, InvalidInstructionException {
        // arrange
        int length = 5;
        int breadth = 5;

        // act
        plateauService.create(length, breadth);

        // assert
        assertThrows(RoverNotFoundException.class, () -> instructionService.processInstructions(1, 1, "LMLMLMLMM"));
    }
}
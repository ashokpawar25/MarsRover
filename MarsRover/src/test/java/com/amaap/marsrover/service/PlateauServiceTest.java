package com.amaap.marsrover.service;

import com.amaap.marsrover.AppModule;
import com.amaap.marsrover.domain.model.entity.DeployedRoverDto;
import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.domain.model.valueobject.Coordinate;
import com.amaap.marsrover.domain.model.valueobject.Direction;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverAlreadyDeployedException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlateauServiceTest {
    RoverService roverService;
    PlateauService plateauService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        roverService = injector.getInstance(RoverService.class);
        plateauService = injector.getInstance(PlateauService.class);
    }

    @Test
    void shouldBeAbleToCreatePlateau() throws InvalidPlateauDimensionsException {
        // arrange
        int length = 5;
        int breadth = 5;
        PlateauDto expected = new PlateauDto(1, length, breadth);

        // act
        PlateauDto actual = plateauService.create(length, breadth);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidPlateauDimensionsArePassed() {
        assertThrows(InvalidPlateauDimensionsException.class, () -> plateauService.create(-4, 5));
        assertThrows(InvalidPlateauDimensionsException.class, () -> plateauService.create(-4, -5));
        assertThrows(InvalidPlateauDimensionsException.class, () -> plateauService.create(4, 0));
    }

    @Test
    void shouldBeAbleToFindPlateauById() throws InvalidPlateauDimensionsException, PlateauNotFoundException {
        // arrange
        int id = 1;
        int length = 5;
        int breadth = 5;
        PlateauDto expected = new PlateauDto(id, length, breadth);

        // act
        plateauService.create(length, breadth);
        PlateauDto actual = plateauService.find(id);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenPlateauIsNotFound() {
        assertThrows(PlateauNotFoundException.class, () -> plateauService.find(1));
    }

    @Test
    void shouldBeAbleToDeployRoverOnPlateau() throws InvalidPlateauDimensionsException, RoverNotFoundException, PlateauNotFoundException, RoverAlreadyDeployedException {
        // arrange
        int length = 5;
        int breadth = 5;
        PlateauDto expected = new PlateauDto(1, length, breadth);
        expected.addRover(new DeployedRoverDto(1, new Coordinate(3, 3), Direction.N));

        // act
        roverService.create();
        plateauService.create(length, breadth);
        PlateauDto actual = plateauService.deployRover(1, 1, new Coordinate(3, 3), Direction.N);

        // assert
        assertEquals(expected, actual);
    }
}
package com.amaap.marsrover.controller;

import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.valueobject.Coordinate;
import com.amaap.marsrover.domain.model.valueobject.Direction;
import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.marsrover.repository.impl.InMemoryPlateauRepository;
import com.amaap.marsrover.repository.impl.InMemoryRoverRepository;
import com.amaap.marsrover.service.PlateauService;
import com.amaap.marsrover.service.RoverService;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlateauControllerTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    RoverService roverService = new RoverService(new InMemoryRoverRepository(inMemoryDatabase));
    PlateauController plateauController = new PlateauController(new PlateauService(new InMemoryPlateauRepository(inMemoryDatabase), roverService));

    @Test
    void shouldBeAbleToGetOkResponseWhenPlateauCreated() {
        // arrange
        int length = 5;
        int breadth = 5;
        Response expected = new Response(HttpStatus.OK, "Plateau created successfully");

        // act
        Response actual = plateauController.create(length, breadth);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetBadRequestAsResponseWhenPlateauDimensionsAreInvalid() {
        // arrange
        int length = -5;
        int breadth = 5;
        Response expected = new Response(HttpStatus.BADREQUEST, "Invalid Plateau dimensions :(" + length + "," + breadth + ")");

        // act
        Response actual = plateauController.create(length, breadth);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToFindPlateauById() throws PlateauNotFoundException {
        // arrange
        int id = 1;
        int length = 5;
        int breadth = 5;
        PlateauDto expected = new PlateauDto(id, length, breadth);

        // act
        plateauController.create(length, breadth);
        PlateauDto actual = plateauController.find(id);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenPlateauIsNotFound() {
        assertThrows(PlateauNotFoundException.class, () -> plateauController.find(1));
    }

    @Test
    void shouldBeAbleToGetOkResponseWhenRoverDeployedOnPlateau() {
        // arrange
        int length = 5;
        int breadth = 5;
        Response expected = new Response(HttpStatus.OK, "Rover deployed on plateau successfully");

        // act
        roverService.create();
        plateauController.create(length, breadth);
        Response actual = plateauController.deployRover(1, 1, new Coordinate(3, 3), Direction.N);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetNotFoundResponseWhenRoverNotFound() {
        // arrange
        int length = 5;
        int breadth = 5;
        Response expected = new Response(HttpStatus.NOTFOUND, "Rover with id:1 not found");

        // act
        plateauController.create(length, breadth);
        Response actual = plateauController.deployRover(1, 1, new Coordinate(3, 3), Direction.N);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetBadRequestAsResponseWhenRoverIsAlreadyDeployed() {
        // arrange
        int length = 5;
        int breadth = 5;
        Response expected = new Response(HttpStatus.BADREQUEST, "Rover with id:1 is already deployed");

        // act
        roverService.create();
        plateauController.create(length, breadth);
        plateauController.deployRover(1, 1, new Coordinate(3, 3), Direction.N);
        Response actual = plateauController.deployRover(1, 1, new Coordinate(3, 3), Direction.N);

        // assert
        assertEquals(expected, actual);
    }
}

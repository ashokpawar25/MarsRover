package com.amaap.marsrover.controller;

import com.amaap.marsrover.AppModule;
import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverControllerTest {
    RoverController roverController;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        roverController = injector.getInstance(RoverController.class);
    }

    @Test
    void shouldBeAbleToCreateRover() {
        // arrange
        Response expected = new Response(HttpStatus.OK, "Rover Created Successfully");

        // act
        Response actual = roverController.create();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetRoverById() throws RoverNotFoundException {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        roverController.create();
        RoverDto actual = roverController.find(1);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenRoverWithGivenIdIsNotFound() {
        assertThrows(RoverNotFoundException.class, () -> roverController.find(1));
    }
}
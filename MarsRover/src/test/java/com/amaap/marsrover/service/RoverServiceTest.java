package com.amaap.marsrover.service;

import com.amaap.marsrover.AppModule;
import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoverServiceTest {
    RoverService roverService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        roverService = injector.getInstance(RoverService.class);
    }

    @Test
    void shouldBeAbleToCreateRover() {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        RoverDto actual = roverService.create();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetRoverById() throws RoverNotFoundException {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        roverService.create();
        RoverDto actual = roverService.find(1);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenRoverWithGivenIdIsNotFound() {
        assertThrows(RoverNotFoundException.class, () -> roverService.find(1));
    }
}
package com.amaap.marsrover.controller;

import com.amaap.marsrover.controller.RoverController;
import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.repository.RoverRepository;
import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.marsrover.repository.impl.InMemoryRoverRepository;
import com.amaap.marsrover.service.RoverService;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverControllerTest {
    RoverController roverController = new RoverController(new RoverService
            (new InMemoryRoverRepository(new FakeInMemoryDatabase())));
    @Test
    void shouldBeAbleToCreateRover()
    {
        // arrange
        Response expected = new Response(HttpStatus.OK,"Rover Created Successfully");

        // act
        Response actual = roverController.create();

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetRoverById() throws RoverNotFoundException {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        roverController.create();
        RoverDto actual = roverController.find(1);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenRoverWithGivenIdIsNotFound()
    {
        assertThrows(RoverNotFoundException.class,()->roverController.find(1));
    }
}
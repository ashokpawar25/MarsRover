package com.amaap.marsrover;

import com.amaap.marsrover.controller.RoverController;
import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.repository.RoverRepository;
import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.marsrover.repository.impl.InMemoryRoverRepository;
import com.amaap.marsrover.service.RoverService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverControllerTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    RoverRepository roverRepository = new InMemoryRoverRepository(inMemoryDatabase);
    RoverService roverService = new RoverService(roverRepository);
    RoverController roverController = new RoverController(roverService);
    @Test
    void shouldBeAbleToCreateRover()
    {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        RoverDto actual = roverController.create();

        // assert
        assertEquals(expected,actual);
    }
}
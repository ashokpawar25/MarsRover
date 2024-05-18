package com.amaap.marsrover.service;

import com.amaap.marsrover.controller.RoverController;
import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.repository.RoverRepository;
import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.marsrover.repository.impl.InMemoryRoverRepository;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    RoverRepository roverRepository = new InMemoryRoverRepository(inMemoryDatabase);
    RoverService roverService = new RoverService(roverRepository);
    @Test
    void shouldBeAbleToCreateRover()
    {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        RoverDto actual = roverService.create();

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetRoverById() throws RoverNotFoundException {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        roverService.create();
        RoverDto actual = roverService.find(1);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenRoverWithGivenIdIsNotFound()
    {
        assertThrows(RoverNotFoundException.class,()->roverService.find(1));
    }
}
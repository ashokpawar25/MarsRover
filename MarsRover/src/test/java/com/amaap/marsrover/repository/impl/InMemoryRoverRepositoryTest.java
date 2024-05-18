package com.amaap.marsrover.repository.impl;

import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.repository.db.impl.FakeInMemoryDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRoverRepositoryTest {
    InMemoryRoverRepository inMemoryRoverRepository = new InMemoryRoverRepository(new FakeInMemoryDatabase());
    @Test
    void shouldBeAbleToAddRoverIntoRepository()
    {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        RoverDto actual = inMemoryRoverRepository.add();

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetRoverByIdFromRepository()
    {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        inMemoryRoverRepository.add();
        RoverDto actual = inMemoryRoverRepository.find(1);

        // assert
        assertEquals(expected,actual);
    }
}
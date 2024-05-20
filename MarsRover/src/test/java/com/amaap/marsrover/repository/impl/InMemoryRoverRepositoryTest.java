package com.amaap.marsrover.repository.impl;

import com.amaap.marsrover.AppModule;
import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryRoverRepositoryTest {
    InMemoryRoverRepository inMemoryRoverRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        inMemoryRoverRepository = injector.getInstance(InMemoryRoverRepository.class);
    }

    @Test
    void shouldBeAbleToAddRoverIntoRepository() {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        RoverDto actual = inMemoryRoverRepository.add();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetRoverByIdFromRepository() {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        inMemoryRoverRepository.add();
        RoverDto actual = inMemoryRoverRepository.find(1);

        // assert
        assertEquals(expected, actual);
    }
}
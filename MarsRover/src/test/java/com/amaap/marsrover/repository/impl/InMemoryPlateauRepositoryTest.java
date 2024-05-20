package com.amaap.marsrover.repository.impl;

import com.amaap.marsrover.AppModule;
import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryPlateauRepositoryTest {

    InMemoryPlateauRepository inMemoryPlateauRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        inMemoryPlateauRepository = injector.getInstance(InMemoryPlateauRepository.class);
    }

    @Test
    void shouldBeAbleToAddPlateauInRepository() throws InvalidPlateauDimensionsException {
        // arrange
        int length = 5;
        int breadth = 5;
        PlateauDto expected = new PlateauDto(1, length, breadth);

        // act
        PlateauDto actual = inMemoryPlateauRepository.add(length, breadth);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidPlateauDimensionsArePassed() {
        assertThrows(InvalidPlateauDimensionsException.class, () -> inMemoryPlateauRepository.add(-4, 5));
        assertThrows(InvalidPlateauDimensionsException.class, () -> inMemoryPlateauRepository.add(-4, -5));
        assertThrows(InvalidPlateauDimensionsException.class, () -> inMemoryPlateauRepository.add(4, 0));
    }

    @Test
    void shouldBeAbleToGetPlateauByIdFromRepository() throws InvalidPlateauDimensionsException {
        // arrange
        int id = 1;
        int length = 5;
        int breadth = 5;
        PlateauDto expected = new PlateauDto(id, length, breadth);

        // act
        inMemoryPlateauRepository.add(length, breadth);
        PlateauDto actual = inMemoryPlateauRepository.find(id);

        // assert
        assertEquals(expected, actual);
    }
}
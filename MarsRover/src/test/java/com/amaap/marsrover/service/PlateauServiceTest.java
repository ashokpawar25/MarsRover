package com.amaap.marsrover.service;

import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.marsrover.repository.impl.InMemoryPlateauRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauServiceTest {
    PlateauService plateauService = new PlateauService(new InMemoryPlateauRepository(new FakeInMemoryDatabase()));

    @Test
    void shouldBeAbleToCreatePlateau() throws InvalidPlateauDimensionsException {
        // arrange
        int length = 5;
        int breadth = 5;
        PlateauDto expected = new PlateauDto(1,length,breadth);

        // act
        PlateauDto actual = plateauService.create(length,breadth);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidPlateauDimensionsArePassed()
    {
        assertThrows(InvalidPlateauDimensionsException.class,()->plateauService.create(-4,5));
        assertThrows(InvalidPlateauDimensionsException.class,()->plateauService.create(-4,-5));
        assertThrows(InvalidPlateauDimensionsException.class,()->plateauService.create(4,0));
    }

    @Test
    void shouldBeAbleToFindPlateauById() throws InvalidPlateauDimensionsException {
        // arrange
        int id = 1;
        int length = 5;
        int breadth = 5;
        PlateauDto expected = new PlateauDto(id,length,breadth);

        // act
        plateauService.create(length,breadth);
        PlateauDto actual = plateauService.find(id);

        // assert
        assertEquals(expected,actual);
    }
}
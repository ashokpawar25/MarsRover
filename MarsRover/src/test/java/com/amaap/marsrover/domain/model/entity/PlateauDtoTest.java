package com.amaap.marsrover.domain.model.entity;

import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauDtoTest {

    @Test
    void shouldBeAbleToCreatePlateau() throws InvalidPlateauDimensionsException {
        // arrange
        int id = 1;
        int length = 5;
        int breadth = 5;
        PlateauDto expected = new PlateauDto(id,length,breadth);

        // act
        PlateauDto actual = PlateauDto.create(id,length,breadth);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidPlateauDimensionsArePassed()
    {
        assertThrows(InvalidPlateauDimensionsException.class,()->PlateauDto.create(1,0,1));
        assertThrows(InvalidPlateauDimensionsException.class,()->PlateauDto.create(1,-1,0));
        assertThrows(InvalidPlateauDimensionsException.class,()->PlateauDto.create(1,0,0));
        assertThrows(InvalidPlateauDimensionsException.class,()->PlateauDto.create(1,0,-1));
    }
}
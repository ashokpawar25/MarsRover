package com.amaap.marsrover.repository.db.impl;

import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FakeInMemoryDatabaseTest {

    FakeInMemoryDatabase fakeInMemoryDatabase = new FakeInMemoryDatabase();

    @Test
    void shouldBeAbleToAddRoverIntoDatabase()
    {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        RoverDto actual = fakeInMemoryDatabase.insertIntoRoverTable();

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetRoverByIdFromDatabase()
    {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        fakeInMemoryDatabase.insertIntoRoverTable();
        RoverDto actual = fakeInMemoryDatabase.selectFromRoverTable(1);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToAddPlateauInDatabase() throws InvalidPlateauDimensionsException {
        // arrange
        int length = 5;
        int breadth = 5;
        PlateauDto expected = new PlateauDto(1,length,breadth);

        // act
        PlateauDto actual = fakeInMemoryDatabase.insertIntoPlateauTable(length,breadth);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidPlateauDimensionsArePassed()
    {
        assertThrows(InvalidPlateauDimensionsException.class,()->fakeInMemoryDatabase.insertIntoPlateauTable(-4,5));
        assertThrows(InvalidPlateauDimensionsException.class,()->fakeInMemoryDatabase.insertIntoPlateauTable(-4,-5));
        assertThrows(InvalidPlateauDimensionsException.class,()->fakeInMemoryDatabase.insertIntoPlateauTable(4,0));
    }

}
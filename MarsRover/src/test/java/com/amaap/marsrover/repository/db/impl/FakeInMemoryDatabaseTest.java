package com.amaap.marsrover.repository.db.impl;

import com.amaap.marsrover.domain.model.entity.RoverDto;
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
}
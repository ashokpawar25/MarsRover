package com.amaap.marsrover.domain.model.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void shouldBeAbleToCheckEqualityOfInstance()
    {
        // arrange
        Coordinate coordinate1 = new Coordinate(1,2);
        Coordinate coordinate2 = new Coordinate(1,2);
        Coordinate coordinate3 = new Coordinate(2,2);
        Coordinate coordinate4 = new Coordinate(1,1);
        Coordinate coordinate5 = new Coordinate(3,3);
        Object object = new Object();

        // act & assert
        assertTrue(coordinate1.equals(coordinate1));
        assertTrue(coordinate1.equals(coordinate2));
        assertFalse(coordinate1.equals(coordinate3));
        assertFalse(coordinate1.equals(coordinate4));
        assertFalse(coordinate1.equals(coordinate5));
        assertFalse(coordinate1.equals(object));
        assertFalse(coordinate1.equals(null));
    }
}
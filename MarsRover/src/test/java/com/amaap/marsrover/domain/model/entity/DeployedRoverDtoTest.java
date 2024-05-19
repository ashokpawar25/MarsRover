package com.amaap.marsrover.domain.model.entity;

import com.amaap.marsrover.domain.model.valueobject.Coordinate;
import com.amaap.marsrover.domain.model.valueobject.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeployedRoverDtoTest {

    @Test
    void shouldBeAbleToCheckEqualityOfInstances()
    {
        // arrange
        Coordinate coordinate1 = new Coordinate(1,1);
        Coordinate coordinate2 = new Coordinate(1,2);
        DeployedRoverDto rover1 = new DeployedRoverDto(1,coordinate1, Direction.N);
        DeployedRoverDto rover2 = new DeployedRoverDto(1,coordinate1, Direction.N);
        DeployedRoverDto rover3 = new DeployedRoverDto(2,coordinate1, Direction.N);
        DeployedRoverDto rover4 = new DeployedRoverDto(1,coordinate2, Direction.N);
        DeployedRoverDto rover5 = new DeployedRoverDto(1,coordinate1, Direction.S);
        DeployedRoverDto rover6 = new DeployedRoverDto(2,coordinate2, Direction.S);
        Object object = new Object();

        // act & assert
        assertTrue(rover1.equals(rover1));
        assertTrue(rover1.equals(rover2));
        assertFalse(rover1.equals(rover3));
        assertFalse(rover1.equals(rover4));
        assertFalse(rover1.equals(rover5));
        assertFalse(rover1.equals(rover6));
        assertFalse(rover1.equals(object));
        assertFalse(rover1.equals(null));
    }
}
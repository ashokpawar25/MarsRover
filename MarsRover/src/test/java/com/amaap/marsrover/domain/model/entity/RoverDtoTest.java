package com.amaap.marsrover.domain.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverDtoTest {

    @Test
    void shouldBeAbleToCompareRover()
    {
        // arrange & act
        RoverDto rover1 = new RoverDto(1);
        RoverDto rover2 = new RoverDto(1);

        // assert
        assertEquals(rover1,rover2);
    }

    @Test
    void shouldBeAbleToValidateRoverIsNotDeployedWhenCreated()
    {
        // arrange
        RoverDto rover = new RoverDto(1);

        // act
        boolean isDeployed = rover.isDeployed();

        // assert
        assertFalse(isDeployed);
    }

    @Test
    void shouldBeAbleToCheckEqualityOfInstances()
    {
        // arrange
        RoverDto rover1 = new RoverDto(1);
        RoverDto rover2 = new RoverDto(1);
        RoverDto rover3 = new RoverDto(2);
        RoverDto rover4 = new RoverDto(1);
        RoverDto rover5 = new RoverDto(2);
        rover4.setDeployed();
        rover5.setDeployed();
        Object object = new Object();

        // act & assert
        assertTrue(rover1.equals(rover1));
        assertTrue(rover1.equals(rover2));
        assertFalse(rover1.equals(rover3));
        assertFalse(rover1.equals(rover4));
        assertFalse(rover1.equals(rover5));
        assertFalse(rover1.equals(object));
        assertFalse(rover1.equals(null));
    }
}
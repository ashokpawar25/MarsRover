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
}
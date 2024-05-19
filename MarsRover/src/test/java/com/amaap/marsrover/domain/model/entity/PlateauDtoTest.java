package com.amaap.marsrover.domain.model.entity;

import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.domain.model.valueobject.Coordinate;
import com.amaap.marsrover.domain.model.valueobject.Direction;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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

    @Test
    void shouldBeAbleToGetDeployedRoversOnPlateau()
    {
        // arrange
        PlateauDto plateauDto = new PlateauDto(1,5,5);
        DeployedRoverDto expected = new DeployedRoverDto(1,new Coordinate(1,3), Direction.N);
        plateauDto.addRover(expected);

        // act
        Optional<DeployedRoverDto> deployedRover = plateauDto.getDeployedRover(1);
        DeployedRoverDto actual = deployedRover.get();

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToHandleScenarioOfRoverNotFoundOnPlateau()
    {
        // arrange
        PlateauDto plateauDto = new PlateauDto(1,5,5);

        // act
        Optional<DeployedRoverDto> deployedRover = plateauDto.getDeployedRover(1);

        // assert
        assertFalse(deployedRover.isPresent());
    }

    @Test
    void shouldBeAbleToCheckEqualityOfInstances()
    {
        // arrange
        PlateauDto plateau1 = new PlateauDto(1,5,5);
        PlateauDto plateau2 = new PlateauDto(1,5,5);
        PlateauDto plateau3 = new PlateauDto(2,5,5);
        PlateauDto plateau4 = new PlateauDto(1,4,5);
        PlateauDto plateau5 = new PlateauDto(1,5,4);
        PlateauDto plateau6 = new PlateauDto(1,4,4);
        Object object = new Object();

        // act & assert
        assertTrue(plateau1.equals(plateau1));
        assertTrue(plateau1.equals(plateau2));
        assertFalse(plateau1.equals(plateau3));
        assertFalse(plateau1.equals(plateau4));
        assertFalse(plateau1.equals(plateau5));
        assertFalse(plateau1.equals(plateau6));
        assertFalse(plateau1.equals(object));
        assertFalse(plateau1.equals(null));
    }
}
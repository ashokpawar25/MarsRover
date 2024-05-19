package com.amaap.marsrover.domain.service;

import com.amaap.marsrover.domain.model.entity.DeployedRoverDto;
import com.amaap.marsrover.domain.model.valueobject.Coordinate;
import com.amaap.marsrover.domain.model.valueobject.Direction;
import com.amaap.marsrover.domain.service.exception.InvalidInstructionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionProcessorTest {

    @Test
    void shouldBeAbleToRotateDeployedRoverToRight() throws InvalidInstructionException {
        // arrange
        DeployedRoverDto rover = new DeployedRoverDto(1,new Coordinate(3,4), Direction.N);
        DeployedRoverDto expected = new DeployedRoverDto(1,new Coordinate(3,4), Direction.E);

        // act
        DeployedRoverDto actual = InstructionProcessor.process("R", rover);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToRotateDeployedRoverToLeft() throws InvalidInstructionException {
        // arrange
        DeployedRoverDto rover = new DeployedRoverDto(1,new Coordinate(3,4), Direction.N);
        DeployedRoverDto expected = new DeployedRoverDto(1,new Coordinate(3,4), Direction.W);

        // act
        DeployedRoverDto actual = InstructionProcessor.process("L", rover);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToMoveRoverInGivenDirection() throws InvalidInstructionException {
        // arrange
        DeployedRoverDto rover = new DeployedRoverDto(1,new Coordinate(3,4), Direction.N);
        DeployedRoverDto expected = new DeployedRoverDto(1,new Coordinate(3,5), Direction.N);

        // act
        DeployedRoverDto actual = InstructionProcessor.process("M", rover);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidInstructionIsPassed() {
        // arrange
        DeployedRoverDto rover = new DeployedRoverDto(1,new Coordinate(3,4), Direction.N);

        // act & assert
        assertThrows(InvalidInstructionException.class,()->InstructionProcessor.process("Z", rover));
    }

    @Test
    void shouldBeAbleToCreateInstanceOfClass()
    {
        // arrange
        InstructionProcessor instructionProcessor = new InstructionProcessor();

        // act & assert
        assertNotNull(instructionProcessor);
    }
}
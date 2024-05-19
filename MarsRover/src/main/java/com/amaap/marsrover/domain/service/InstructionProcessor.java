package com.amaap.marsrover.domain.service;

import com.amaap.marsrover.domain.model.entity.DeployedRoverDto;
import com.amaap.marsrover.domain.model.valueobject.Coordinate;
import com.amaap.marsrover.domain.model.valueobject.Direction;
import com.amaap.marsrover.domain.model.valueobject.Instruction;
import com.amaap.marsrover.domain.service.exception.InvalidInstructionException;

public class InstructionProcessor {
    public static DeployedRoverDto process(String rawInstruction, DeployedRoverDto rover) throws InvalidInstructionException {
        if (!rawInstruction.equalsIgnoreCase("L") &&
                !rawInstruction.equalsIgnoreCase("R") &&
                !rawInstruction.equalsIgnoreCase("M"))
            throw new InvalidInstructionException("Invalid Instruction " + rawInstruction);

        Instruction instruction = Instruction.valueOf(rawInstruction);
        if (instruction == Instruction.L) {
            rover.setDirection(rover.getDirection().getLeft());
        } else if (instruction == Instruction.R) {
            rover.setDirection(rover.getDirection().getRight());
        } else {
            if (rover.getDirection() == Direction.N) {
                rover.setCoordinate(new Coordinate(rover.getCoordinate().getX(), rover.getCoordinate().getY() + 1));
            }
            if (rover.getDirection() == Direction.S) {
                rover.setCoordinate(new Coordinate(rover.getCoordinate().getX(), rover.getCoordinate().getY() - 1));
            }
            if (rover.getDirection() == Direction.E) {
                rover.setCoordinate(new Coordinate(rover.getCoordinate().getX() + 1, rover.getCoordinate().getY()));
            }
            if (rover.getDirection() == Direction.W) {
                rover.setCoordinate(new Coordinate(rover.getCoordinate().getX() - 1, rover.getCoordinate().getY()));
            }
        }
        return rover;
    }
}

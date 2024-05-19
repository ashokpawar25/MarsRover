package com.amaap.marsrover.domain.service;

import com.amaap.marsrover.domain.model.entity.DeployedRoverDto;
import com.amaap.marsrover.domain.model.valueobject.Instruction;
import com.amaap.marsrover.domain.service.exception.InvalidInstructionException;

public class InstructionProcessor {
    public static DeployedRoverDto process(String rawInstruction, DeployedRoverDto rover) throws InvalidInstructionException {
        if (!rawInstruction.equals("L") && !rawInstruction.equals("R") && !rawInstruction.equals("M"))
            throw new InvalidInstructionException("Invalid Instruction " + rawInstruction);

        Instruction instruction = Instruction.valueOf(rawInstruction);
        if (instruction == Instruction.L)
            rover.setDirection(rover.getDirection().getLeft());
        else if (instruction == Instruction.R)
            rover.setDirection(rover.getDirection().getRight());
        else
            moveRover(rover);
        return rover;
    }

    private static void moveRover(DeployedRoverDto rover) {
        switch (rover.getDirection()) {
            case N:
                rover.setCoordinate(rover.moveInYDirection(1));
                break;
            case S:
                rover.setCoordinate(rover.moveInYDirection(-1));
                break;
            case E:
                rover.setCoordinate(rover.moveInXDirection(1));
                break;
            case W:
                rover.setCoordinate(rover.moveInXDirection(-1));
                break;
        }
    }
}

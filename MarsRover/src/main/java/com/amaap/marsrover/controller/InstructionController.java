package com.amaap.marsrover.controller;

import com.amaap.marsrover.domain.model.entity.DeployedRoverDto;
import com.amaap.marsrover.domain.service.exception.InvalidInstructionException;
import com.amaap.marsrover.service.InstructionService;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;

public class InstructionController {
    private InstructionService instructionService;
    public InstructionController(InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    public DeployedRoverDto processInstructions(int roverId, int plateauId, String instructions) throws RoverNotFoundException, PlateauNotFoundException, InvalidInstructionException {
        return instructionService.processInstructions(roverId,plateauId,instructions);
    }
}

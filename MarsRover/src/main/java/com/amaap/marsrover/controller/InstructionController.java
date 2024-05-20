package com.amaap.marsrover.controller;

import com.amaap.marsrover.domain.model.entity.DeployedRoverDto;
import com.amaap.marsrover.domain.service.exception.InvalidInstructionException;
import com.amaap.marsrover.service.InstructionService;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import jakarta.inject.Inject;

public class InstructionController {
    private final InstructionService instructionService;
    @Inject
    public InstructionController(InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    public DeployedRoverDto processInstructions(int roverId, int plateauId, String instructions) throws RoverNotFoundException, PlateauNotFoundException, InvalidInstructionException {
        return instructionService.processInstructions(roverId,plateauId,instructions);
    }
}

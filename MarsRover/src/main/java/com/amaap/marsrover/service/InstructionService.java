package com.amaap.marsrover.service;

import com.amaap.marsrover.domain.model.entity.DeployedRoverDto;
import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.service.InstructionProcessor;
import com.amaap.marsrover.domain.service.exception.InvalidInstructionException;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;

import static com.amaap.marsrover.domain.service.InstructionProcessor.process;

public class InstructionService {
    private final PlateauService plateauService;
    public InstructionService(PlateauService plateauService) {
        this.plateauService = plateauService;
    }

    public DeployedRoverDto processInstructions(int roverId, int plateauId, String instruction) throws PlateauNotFoundException, RoverNotFoundException, InvalidInstructionException {
        PlateauDto plateauDto = plateauService.find(plateauId);
        DeployedRoverDto rover = plateauDto.getDeployedRover(roverId).orElseThrow(()-> new RoverNotFoundException("Rover with id:"+roverId+" is not deployed on plateau"));
        String [] instructions = instruction.toUpperCase().split("");
        for(String rawInstruction: instructions)
        {
            rover = process(rawInstruction,rover);
        }
        return rover;
    }
}

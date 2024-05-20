package com.amaap.marsrover.service;

import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.repository.RoverRepository;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import jakarta.inject.Inject;

public class RoverService {
    private final RoverRepository roverRepository;
    @Inject
    public RoverService(RoverRepository roverRepository) {
        this.roverRepository = roverRepository;
    }

    public RoverDto create() {
        return roverRepository.add();
    }

    public RoverDto find(int id) throws RoverNotFoundException {
        RoverDto rover = roverRepository.find(id);
        if(rover == null) throw new RoverNotFoundException("Rover with id:"+ id + " not found");
        return rover;
    }
}

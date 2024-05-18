package com.amaap.marsrover.service;

import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.repository.RoverRepository;

public class RoverService {
    private final RoverRepository roverRepository;

    public RoverService(RoverRepository roverRepository) {
        this.roverRepository = roverRepository;
    }

    public RoverDto create() {
        return roverRepository.add();
    }
}

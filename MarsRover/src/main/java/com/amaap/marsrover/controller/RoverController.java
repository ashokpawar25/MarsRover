package com.amaap.marsrover.controller;

import com.amaap.marsrover.domain.model.entity.RoverDto;

public class RoverController {
    public RoverDto create() {
        return new RoverDto(1);
    }
}

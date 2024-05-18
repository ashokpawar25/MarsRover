package com.amaap.marsrover.repository.db.impl;

import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    private List<RoverDto> rovers = new ArrayList<>();
    private int roverCounter = 0;
    @Override
    public RoverDto insertIntoRoverTable() {
        RoverDto rover = new RoverDto(++roverCounter);
        rovers.add(rover);
        return rover;
    }
}

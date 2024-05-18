package com.amaap.marsrover.repository.db.impl;

import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    private List<RoverDto> rovers = new ArrayList<>();
    private int roverIdCounter = 0;
    @Override
    public RoverDto insertIntoRoverTable() {
        RoverDto rover = new RoverDto(++roverIdCounter);
        rovers.add(rover);
        return rover;
    }

    @Override
    public RoverDto selectFromRoverTable(int id) {
        return rovers.stream().filter(rover -> rover.getId() == id).findFirst().orElse(null);
    }
}

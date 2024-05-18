package com.amaap.marsrover.repository.db.impl;

import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    private List<RoverDto> rovers = new ArrayList<>();
    private List<PlateauDto> plateauDtos = new ArrayList<>();
    private int roverIdCounter = 0;
    private int plateauIdCounter = 0;
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

    @Override
    public PlateauDto insertIntoPlateauTable(int length, int breadth) throws InvalidPlateauDimensionsException {
        PlateauDto plateau = PlateauDto.create(++plateauIdCounter,length,breadth);
        plateauDtos.add(plateau);
        return plateau;
    }

    @Override
    public PlateauDto selectFromPlateauTable(int id) {
        return plateauDtos.stream().filter(plateau -> plateau.getId() == id).findFirst().orElse(null);
    }
}

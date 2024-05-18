package com.amaap.marsrover.repository.db;

import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;

public interface InMemoryDatabase {
    RoverDto insertIntoRoverTable();

    RoverDto selectFromRoverTable(int id);

    PlateauDto insertIntoPlateauTable(int length, int breadth) throws InvalidPlateauDimensionsException;
}

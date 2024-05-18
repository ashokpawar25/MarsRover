package com.amaap.marsrover.repository.db;

import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.RoverDto;

public interface InMemoryDatabase {
    RoverDto insertIntoRoverTable();

    RoverDto selectFromRoverTable(int id);

    PlateauDto insertIntoPlateauTable(int length, int breadth);
}

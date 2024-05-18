package com.amaap.marsrover.repository.db;

import com.amaap.marsrover.domain.model.entity.RoverDto;

public interface InMemoryDatabase {
    RoverDto insertIntoRoverTable();
}

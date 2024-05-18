package com.amaap.marsrover.repository.impl;

import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.repository.RoverRepository;
import com.amaap.marsrover.repository.db.InMemoryDatabase;

public class InMemoryRoverRepository implements RoverRepository {
    private final InMemoryDatabase inMemoryDatabase;

    public InMemoryRoverRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public RoverDto add() {
        return inMemoryDatabase.insertIntoRoverTable();
    }
}

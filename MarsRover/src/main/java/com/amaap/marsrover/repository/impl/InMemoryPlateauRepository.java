package com.amaap.marsrover.repository.impl;

import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.repository.PlateauRepository;
import com.amaap.marsrover.repository.db.InMemoryDatabase;

public class InMemoryPlateauRepository implements PlateauRepository {
    private final InMemoryDatabase inMemoryDatabase;
    public InMemoryPlateauRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public PlateauDto add(int length, int breadth) {
        return inMemoryDatabase.insertIntoPlateauTable(length,breadth);
    }
}

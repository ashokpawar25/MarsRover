package com.amaap.marsrover.repository.impl;

import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.repository.PlateauRepository;
import com.amaap.marsrover.repository.db.InMemoryDatabase;
import jakarta.inject.Inject;

public class InMemoryPlateauRepository implements PlateauRepository {
    private final InMemoryDatabase inMemoryDatabase;
    @Inject
    public InMemoryPlateauRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public PlateauDto add(int length, int breadth) throws InvalidPlateauDimensionsException {
        return inMemoryDatabase.insertIntoPlateauTable(length,breadth);
    }

    @Override
    public PlateauDto find(int id) {
        return inMemoryDatabase.selectFromPlateauTable(id);
    }
}

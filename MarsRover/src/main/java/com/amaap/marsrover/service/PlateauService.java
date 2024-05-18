package com.amaap.marsrover.service;

import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.repository.PlateauRepository;

public class PlateauService {
    private final PlateauRepository plateauRepository;
    public PlateauService(PlateauRepository plateauRepository) {
        this.plateauRepository = plateauRepository;
    }

    public PlateauDto create(int length, int breadth) throws InvalidPlateauDimensionsException {
        return plateauRepository.add(length,breadth);
    }
}

package com.amaap.marsrover.repository;

import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;

public interface PlateauRepository {
    PlateauDto add(int length, int breadth) throws InvalidPlateauDimensionsException;

    PlateauDto find(int id);
}

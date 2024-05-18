package com.amaap.marsrover.repository;

import com.amaap.marsrover.domain.model.entity.PlateauDto;

public interface PlateauRepository {
    PlateauDto add(int length, int breadth);
}

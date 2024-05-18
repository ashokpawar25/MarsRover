package com.amaap.marsrover.domain.model.entity;

import com.amaap.marsrover.domain.model.valueobject.Coordinate;
import com.amaap.marsrover.domain.model.valueobject.Direction;

import java.util.Objects;

public class DeployedRoverDto {
    private final int id;
    private Coordinate coordinate;
    private Direction direction;

    public DeployedRoverDto(int id, Coordinate coordinate, Direction direction) {
        this.id = id;
        this.coordinate = coordinate;
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeployedRoverDto that = (DeployedRoverDto) o;
        return id == that.id && Objects.equals(coordinate, that.coordinate) && direction == that.direction;
    }


}

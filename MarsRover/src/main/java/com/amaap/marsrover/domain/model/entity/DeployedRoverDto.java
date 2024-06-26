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

    public int getId() {
        return id;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public Coordinate moveInYDirection(int value) {
        this.coordinate.setY(this.coordinate.getY()+value);
        return this.coordinate;
    }

    public Coordinate moveInXDirection(int value) {
        this.coordinate.setX(this.coordinate.getX()+value);
        return this.coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setDirection(Direction direction) {
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

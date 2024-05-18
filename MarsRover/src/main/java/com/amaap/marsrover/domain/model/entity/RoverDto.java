package com.amaap.marsrover.domain.model.entity;

import java.util.Objects;

public class RoverDto {
    private int id;
    private boolean isDeployed;
    public RoverDto(int id) {
        this.id = id;
        this.isDeployed = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoverDto roverDto = (RoverDto) o;
        return id == roverDto.id && isDeployed == roverDto.isDeployed;
    }
}

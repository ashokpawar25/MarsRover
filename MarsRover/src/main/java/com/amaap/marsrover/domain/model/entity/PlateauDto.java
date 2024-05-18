package com.amaap.marsrover.domain.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlateauDto {
    private final int id;
    private final int length;
    private final int breadth;
    private List deployedRovers;
    public PlateauDto(int id, int length, int breadth) {
        this.id = id;
        this.length = length;
        this.breadth = breadth;
        this.deployedRovers = new ArrayList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlateauDto plateauDto = (PlateauDto) o;
        return id == plateauDto.id && length == plateauDto.length && breadth == plateauDto.breadth && Objects.equals(deployedRovers, plateauDto.deployedRovers);
    }
}

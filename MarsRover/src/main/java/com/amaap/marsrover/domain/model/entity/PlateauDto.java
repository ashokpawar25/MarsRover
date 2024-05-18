package com.amaap.marsrover.domain.model.entity;

import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;

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

    public static PlateauDto create(int id, int length, int breadth) throws InvalidPlateauDimensionsException {
        if(length <= 0 || breadth <= 0) throw new InvalidPlateauDimensionsException("Invalid Plateau dimensions :("+length+","+breadth+")");
        return new PlateauDto(id,length,breadth);
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlateauDto plateauDto = (PlateauDto) o;
        return id == plateauDto.id && length == plateauDto.length && breadth == plateauDto.breadth && Objects.equals(deployedRovers, plateauDto.deployedRovers);
    }
}

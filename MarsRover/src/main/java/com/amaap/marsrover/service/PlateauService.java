package com.amaap.marsrover.service;

import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.repository.PlateauRepository;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;

public class PlateauService {
    private final PlateauRepository plateauRepository;
    public PlateauService(PlateauRepository plateauRepository) {
        this.plateauRepository = plateauRepository;
    }

    public PlateauDto create(int length, int breadth) throws InvalidPlateauDimensionsException {
        return plateauRepository.add(length,breadth);
    }

    public PlateauDto find(int id) throws PlateauNotFoundException {
        PlateauDto plateau = plateauRepository.find(id);
        if(plateau == null) throw new PlateauNotFoundException("Plateau with id:"+id+" not found");
        return plateau;
    }
}

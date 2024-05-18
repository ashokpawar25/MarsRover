package com.amaap.marsrover.controller;

import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.domain.model.entity.exception.InvalidPlateauDimensionsException;
import com.amaap.marsrover.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.marsrover.repository.impl.InMemoryPlateauRepository;
import com.amaap.marsrover.service.PlateauService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauControllerTest {
    PlateauController plateauController = new PlateauController(new PlateauService(new InMemoryPlateauRepository(new FakeInMemoryDatabase())));
    @Test
    void shouldBeAbleToGetOkResponseWhenPlateauCreated(){
        // arrange
        int length = 5;
        int breadth = 5;
        Response expected = new Response(HttpStatus.OK,"Plateau created successfully");

        // act
        Response actual = plateauController.create(length,breadth);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetBadRequestAsResponseWhenPlateauDimensionsAreInvalid(){
        // arrange
        int length = -5;
        int breadth = 5;
        Response expected = new Response(HttpStatus.BADREQUEST,"Invalid Plateau dimensions :("+length+","+breadth+")");

        // act
        Response actual = plateauController.create(length,breadth);

        // assert
        assertEquals(expected,actual);
    }
}

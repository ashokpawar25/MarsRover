package com.amaap.marsrover;

import com.amaap.marsrover.controller.RoverController;
import com.amaap.marsrover.domain.model.entity.RoverDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverControllerTest {

    RoverController roverController = new RoverController();
    @Test
    void shouldBeAbleToCreateRoverDto()
    {
        // arrange
        RoverDto expected = new RoverDto(1);

        // act
        RoverDto actual = roverController.create();

        // assert
        assertEquals(expected,actual);
    }
}
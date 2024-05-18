package com.amaap.marsrover.repository.impl;

import com.amaap.marsrover.domain.model.entity.PlateauDto;
import com.amaap.marsrover.repository.db.impl.FakeInMemoryDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryPlateauRepositoryTest {

    InMemoryPlateauRepository inMemoryPlateauRepository = new InMemoryPlateauRepository(new FakeInMemoryDatabase());
    @Test
    void shouldBeAbleToAddPlateauInRepository()
    {
        // arrange
        int length = 5;
        int breadth = 5;
        PlateauDto expected = new PlateauDto(1,length,breadth);

        // act
        PlateauDto actual = inMemoryPlateauRepository.add(length,breadth);

        // assert
        assertEquals(expected,actual);
    }
}
package com.amaap.marsrover.repository.impl;

import com.amaap.marsrover.domain.model.entity.RoverDto;
import com.amaap.marsrover.repository.RoverRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

public class MongoRoverRepository implements RoverRepository {

    private final MongoClient mongoClient;
    private int idCounter = 0;

    public MongoRoverRepository(MongoClient mongoClient) {
        this.mongoClient = MongoClients.create("mongodb://localhost:27017");
    }

    @Override
    public RoverDto add() {
        idCounter+=1;
        mongoClient.getDatabase("mars-rover").getCollection("rover").insertOne(
                new Document().append("id",idCounter)
                        .append("isDeployed",false));
        return new RoverDto(1);
    }

    @Override
    public RoverDto find(int id) {
        return null;
    }
}

package org.acme.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.acme.models.Fruit;
import org.acme.repository.FruitRepository;
import org.bson.Document;

import com.mongodb.client.MongoClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FruitRepositoryImpl implements FruitRepository {
	@Inject
	MongoClient mongoClient;

	@Override
	public Fruit create(Fruit request) {
		Fruit fruit = Fruit
				.builder()
				.id(UUID.randomUUID().toString())
				.name(request.getName())
				.description(request.getDescription())
				.season(request.getSeason()).build();

		mongoClient
				.getDatabase("quarkus")
				.getCollection("fruits", Fruit.class)
				.insertOne(fruit);

		return fruit;
	}

	@Override
	public List<Fruit> findAll() {
		List<Fruit> fruits = mongoClient
				.getDatabase("quarkus")
				.getCollection("fruits", Fruit.class)
				.find()
				.into(new ArrayList<>());

		return fruits;
	}

	@Override
	public Fruit findByID(String id) {
		Fruit fruit = mongoClient
				.getDatabase("quarkus")
				.getCollection("fruits", Fruit.class)
				.find(new Document("_id", id))
				.first();

		if (fruit == null) {
			throw new IllegalArgumentException("Fruit not found");
		}

		return fruit;
	}

}

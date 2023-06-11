package org.acme.repository.impl;

import java.util.List;
import java.util.UUID;

import org.acme.models.Fruit;
import org.acme.repository.FruitRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitRepositoryImpl implements FruitRepository {

	@Override
	public Fruit create(Fruit request) {
		Fruit fruit = new Fruit();

		fruit.setId(UUID.randomUUID().toString());
		fruit.setName(request.getName());
		fruit.setDescription(request.getDescription());
		fruit.setSeason(request.getSeason());

		fruit.persist();

		return fruit;
	}

	@Override
	public List<Fruit> findAll() {
		return Fruit.listAll();
	}

	@Override
	public Fruit findByID(String id) {
		Fruit fruit = Fruit.findById(id);

		if (fruit == null) {
			throw new IllegalArgumentException("Fruit not found");
		}

		return fruit;
	}

}

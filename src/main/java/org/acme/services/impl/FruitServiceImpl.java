package org.acme.services.impl;

import java.util.List;

import org.acme.models.Fruit;
import org.acme.repository.FruitRepository;
import org.acme.services.FruitService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FruitServiceImpl implements FruitService {
	@Inject
	private FruitRepository fruitRepository;

	@Override
	public List<Fruit> findAll() {
		return fruitRepository.findAll();
	}

	@Override
	public Fruit findByID(String id) {
		return fruitRepository.findByID(id);
	}

	@Override
	public Fruit create(Fruit fruit) {
		return fruitRepository.create(fruit);
	}

}

package org.acme.services;

import java.util.List;

import org.acme.models.Fruit;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface FruitService {
	public List<Fruit> findAll();

	public Fruit findByID(String id);

	public Fruit create(Fruit fruit);
}

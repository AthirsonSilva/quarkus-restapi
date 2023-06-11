package org.acme.repository;

import java.util.List;

import org.acme.models.Fruit;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface FruitRepository {
	public Fruit create(Fruit fruit);

	public List<Fruit> findAll();

	public Fruit findByID(String id);
}

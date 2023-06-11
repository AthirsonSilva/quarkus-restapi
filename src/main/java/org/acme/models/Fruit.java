package org.acme.models;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fruit extends PanacheMongoEntity {
	private String id;
	private String name;
	private String description;
	private String season;
}
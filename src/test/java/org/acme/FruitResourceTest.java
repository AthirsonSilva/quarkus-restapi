package org.acme;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class FruitResourceTest {

	@Test
	public void testHelloEndpoint() {
		given()
				.when().get("/hello")
				.then()
				.statusCode(200);
	}
}
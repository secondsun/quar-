package net.saga.quarkey.server;

import io.quarkus.test.junit.QuarkusTest;
import net.saga.quarkey.server.entity.PortfolioEntry;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PortfolioResourceTest {

    private static final String getResults = "[{\"name\":\"Quarkey\",\"description\":\"A Quarkus and React based portfolio of my work.  You are looking at it right now.\",\"githubUrl\":\"https://github.com/secondsun/quarkey\",\"demoUrl\":\"https://secondsun.dev\"}]";

    @BeforeEach
    public void setupPortfolioObject() {
        PortfolioEntry portfolio = new PortfolioEntry();
        portfolio.name = "Quarkey";
        portfolio.description="A Quarkus and React based portfolio of my work.  You are looking at it right now.";
        portfolio.githubUrl="https://github.com/secondsun/Quarkey";
        portfolio.demoUrl="https://secondsun.dev";
     PortfolioEntry.persist(portfolio);   
    }

    @Test
    public void testAnonymousPortfolioGet() {
        given()
          .when().get("/portfolio")
          .then()
             .statusCode(200)
             .contentType("application/json")
             .body(is(getResults));
    }

}
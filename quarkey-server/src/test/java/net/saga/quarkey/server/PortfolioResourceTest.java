package net.saga.quarkey.server;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

@QuarkusTest
public class PortfolioResourceTest {

    private static final String getResults = "[{\"id\":1,\"name\":\"Quarkey\",\"description\":\"A Quarkus and React based portfolio of my work.  You are looking at it right now.\",\"githubUrl\":\"https://github.com/secondsun/quarkey\",\"demoUrl\":\"https://secondsun.dev\"}]";


    @Test
    public void testAnonymousPortfolioGet() {
        given()
          .when().get("/portfolio")
          .then()
             .statusCode(200)
             .contentType("application/json")
             .body(hasToString(getResults));
    }

    @Test
    public void testAnonymousPostPortfolio() {
        
        given()
          .when().post("/portfolio")
          .then()
             .statusCode(200)
             .contentType("application/json")
             .body(hasToString(getResults));
    }

}
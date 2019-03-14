package net.saga.quarkey.server;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import net.saga.quarkey.server.entity.PortfolioEntry;
import org.junit.jupiter.api.Test;
import  io.quarkus.test.h2.H2DatabaseTestResource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class PortfolioResourceTest {

    private static final String getResults = "[{\"id\":1,\"name\":\"Quarkey\",\"description\":\"A Quarkus and React based portfolio of my work.  You are looking at it right now.\",\"githubUrl\":\"https://github.com/secondsun/quarkey\",\"demoUrl\":\"https://secondsun.dev\"}]";
    private static final String postResults = "[{\"id\":2,\"name\":\"WLA-language-server\",\"description\":\"A language server for the WLA macro language\",\"githubUrl\":\"https://github.com/secondsun/wla-language-server\",\"demoUrl\":\"https://github.com/secondsun/wla-language-server\"}]";


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
    public void testAnonymousPostPortfolioPost() {
        
        given()
                .contentType(ContentType.JSON.toString())
                .body(new PortfolioEntry("WLA-language-server", "A language server for the WLA macro language", "https://github.com/secondsun/wla-language-server", "https://github.com/secondsun/wla-language-server"))
          .when().post("/portfolio")
          .then()
             .statusCode(200)
             .contentType("application/json")
             .body(hasToString(postResults));
    }

}
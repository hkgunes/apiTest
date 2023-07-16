package petStore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreatePet extends Base {



    @Test
    public void positiveScenario() {

        String body="{\n" +
                "  \"id\": 3,\n" +
                "  \"category\": {\n" +
                "    \"id\": 3,\n" +
                "    \"name\": \"doggie\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"name\": \"doggie\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo(PET_ID))
                .body("name", equalTo("doggie"))
                .body("status", equalTo("available"));

    }

    @Test
    public void negativeScenarioInvalidStatus() {
        String requestBody = "{ \"id\": " + PET_ID + ", \"naame\": \"doggie\", \"status\": \"hatali\" }";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/pet")
                .then()
                .statusCode(405)
                .body("message", equalTo("Invalid status value"));
    }

}

package petStore;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class UpdatePet extends Base {

    @Test
    public void positiveScenario() {
        String requestBody = "{ \"id\": " + PET_ID + ", \"name\": \"updatedDog\", \"status\": \"sold\" }";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo(PET_ID))
                .body("name", equalTo("updatedDog"))
                .body("status", equalTo("sold"));
    }


    @Test
    public void negative_1() {

        String requestBody = "{\"id\": " +1212121212 + ", \"name\": \"cat\", \"status\": \"sold\"}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/pet")
                .then()
                .statusCode(400)
                .body("message", equalTo("Invalid ID supplied"));

    }

    @Test
    public void negative_2() {
        String requestBody = "{\"id\": " + PET_ID + ", \"name\": \"adadad\", \"status\": \"sold\"}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/pet")
                .then()
                .statusCode(404)
                .body("message", equalTo("Pet not found"));
    }

    @Test
    public void negative_3() {
        String requestBody = "{\"id\": " + PET_ID + ", \"status\": \"sold\"}";

        given()
                .contentType(ContentType.XML)
                .body(requestBody)
                .when()
                .put("/pet")
                .then()
                .statusCode(405)
                .body("message", equalTo("Validation exception"));
    }
}

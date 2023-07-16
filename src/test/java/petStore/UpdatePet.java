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
}

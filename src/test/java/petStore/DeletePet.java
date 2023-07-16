package petStore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class DeletePet extends Base {

    @Test
    public void positiveScenario() {
        given()
                .pathParam("petId", PET_ID)
                .when()
                .delete("/pet/{petId}")
                .then()
                .statusCode(200);
    }

    @Test
    public void negativeScenario_invalidId() {
        int invalidPetId = 100;

        given()
                .pathParam("petId", invalidPetId)
                .when()
                .delete("/pet/{petId}")
                .then()
                .statusCode(404)
                .body("message", equalTo("Pet not found"));
    }
}

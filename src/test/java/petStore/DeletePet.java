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
    public void negativeScenario_1() {

        given()
                .pathParam("petId", "a<asas")
                .when()
                .delete("/pet/{petId}")
                .then()
                .statusCode(404)
                .body("message", equalTo("Invalid ID supplied "));
    }
    @Test
    public void negativeScenario_2() {

        given()
                .pathParam("petId", 12121212)
                .when()
                .delete("/pet/{petId}")
                .then()
                .statusCode(404)
                .body("message", equalTo("Pet not found"));
    }
}

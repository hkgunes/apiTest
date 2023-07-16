package petStore;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class ReadPet extends Base {


    @Test
    public void positiveScenario() {
        given()
                .pathParam("petId", PET_ID)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(PET_ID))
                .body("name", equalTo("doggie"))
                .body("status", equalTo("available"));
    }

    @Test
    public void negativeScenarioinvalid() {
        String  invalidPetId = "10121qesdz0";

        given()
                .pathParam("petId", invalidPetId)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(405)
                .body("message", equalTo("Pet not found"));
    }

}

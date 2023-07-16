package petStore;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FindByStatus extends Base{
    @Test
    public void positiveScenario() {
        String status = "available";

        given()
                .queryParam("status", status)
                .when()
                .get("/pet/findByStatus")
                .then()
                .statusCode(200)
                .body("status", everyItem(is(status)));
    }

    @Test
    public void negativeScenario() {
        String invalidStatus = "invalid_status";

        given()
                .queryParam("status", "error")
                .when()
                .get("/pet/findByStatus")
                .then()
                .statusCode(400)
                .body("message", equalTo("Invalid status value"));

    }


}

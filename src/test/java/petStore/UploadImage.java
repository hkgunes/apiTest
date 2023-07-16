package petStore;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class UploadImage extends Base {

    @Test
    public void uploadImagePositiveScenario() {


        given()
                .pathParam("petId", PET_ID)
                .header("Content-Type", "multipart/form-data")
                .multiPart("additionalMetadata", data)
                .multiPart("file", "/pet/cat.jpg")
                .when()
                .post("/pet/{petId}/uploadImage")
                .then()
                .statusCode(200);
    }


}

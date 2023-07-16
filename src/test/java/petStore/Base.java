package petStore;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class Base {

    public static final String BASE_URL = "https://petstore.swagger.io/v2";
    public static final int PET_ID = 3;
    public String data = "Task";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

}

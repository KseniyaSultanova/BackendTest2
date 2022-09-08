package RestAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.util.stream.Stream;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.*;


//apiKey=7daae3490447427cb309d569b5f4990e
//GET https://api.spoonacular.com/mealplanner/{username}/shopping-list
//{
//    "status": "success",
//    "username": "cc37a317-0cd1-4ec9-8a67-fc5ab8bd61a4",
//    "spoonacularPassword": "breakfastcasseroleon53beefbouillon",
//    "hash": "92dabf09967ce1a647d13869a88a2bba363a39a6"
//}


public class ShoppingList {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.spoonacular.com";
        RestAssured.requestSpecification = new RequestSpecBuilder()
               .addParam("apiKey", "7daae3490447427cb309d569b5f4990e")
                .addPathParam("username","cc37a317-0cd1-4ec9-8a67-fc5ab8bd61a4")
//               .addPathParam("hash","92dabf09967ce1a647d13869a88a2bba363a39a6")
                .build();
    }
@Test
    void testAddShoppingList(){
        String actually = RestAssured.given()
            .param("limitLicense", true)
            .param("query", "pkg")
            .log()
            .uri()
            .expect()
            .statusCode(200)
            .body ("totalResults", is (175))
            .body ("results", hasSize (3))
            .log()
            .body()
            .when()
            .get("/mealplanner/{username}/shopping-list")
            .body()
            .asPrettyString();

        String expected = readResourceAsString("expected.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );
    }

    private String readResourceAsString(String resourceName) {
        // ComplexSearchApiTest/resourceName
        String path = getClass().getSimpleName() + FileSystems.getDefault().getSeparator() + resourceName;
        try (InputStream inputStream = getClass().getResourceAsStream(path)) {
            assert inputStream != null;
            byte[] data = inputStream.readAllBytes();
            return new String(data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
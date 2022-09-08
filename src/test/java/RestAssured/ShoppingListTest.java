package RestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingListTest extends Base{

    @Test
    void testPostShoppingList() {

        String actually = RestAssured.given()
                .queryParam("username", "test")
                .queryParam("hash", "b9ca617b12cd3231a917ab0a4ce821a25bb35fdc")
                .body("{\n" +
                        "\t\"item\": \"1 package Baking powder\",\n" +
                        "\t\"aisle\": \"Baking\",\n" +
                        "\t\"parse\": true\n" +
                        "}")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .post("mealplanner/test1010/shopping-list/items")
                .body()
                .as(String.class);

        System.out.println(actually);

    }

    @Test
    void testGetPostShoppingList() {

        String actually = RestAssured.given()
                .queryParam("username", "test")
                .queryParam("hash", "b9ca617b12cd3231a917ab0a4ce821a25bb35fdc")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("mealplanner/test1010/shopping-list")
                .body()
                .as(String.class);

        System.out.println(actually);
    }
}
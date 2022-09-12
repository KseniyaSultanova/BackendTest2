package RestAssured;

import RestAssured.api.Item;
import RestAssured.api.shoppingListApi.ApiShoppingList;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiShoppingListLesson5 extends Base{

    @Test
    void testPostShoppingList() {

        Item actually = RestAssured.given()
                .queryParam("username", "test1010")
                .queryParam("hash", "b9ca617b12cd3231a917ab0a4ce821a25bb35fdc")
                .body("{\n" +
                        "\t\"item\": \"1 package bread powder\",\n" +
                        "\t\"aisle\": \"bread\",\n" +
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
                .as(Item.class);

        System.out.println(actually);

        Assertions.assertEquals(actually.getName(), "bread powder");
        Assertions.assertNotNull(actually.getId());
    }

    @Test
    void testGetPostShoppingList() {

        ApiShoppingList actually = RestAssured.given()
                .queryParam("username", "test1010")
                .queryParam("hash", "b9ca617b12cd3231a917ab0a4ce821a25bb35fdc")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("mealplanner/test1010/shopping-list")
                .body()
                .as(ApiShoppingList.class);

        System.out.println(actually);

        actually.getAisles().get(0).getAisle();
        actually.getAisles().get(0).getId();
        actually.getAisles().get(0).getName();


        Assertions.assertNull(actually.getCost());
        Assertions.assertNotNull(actually.getStartDate());
        Assertions.assertNull(actually.getEndDate());

    }

}

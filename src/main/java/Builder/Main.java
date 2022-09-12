package Builder;

import RestAssured.api.ApiSearchResult;
import RestAssured.api.SpoonaccularApi;
import RestAssured.api.SpoonaccularService;
import RestAssured.api.shoppingListApi.ApiShoppingList;
import RestAssured.api.shoppingListApi.ShoppingApiService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class Main {
    public static void main(String[] args) {


        User user = User.builder()
                .setName("Kseniya")
                .setSurname("Oshkina")
                .setAddress("Saint-P")
                .setEmail("elevationt@bk.ru")
                .build();
//
//        SpoonaccularService spoonaccularService = new SpoonaccularService();
//        ApiSearchResult recipes = spoonaccularService.findRecipes("Bread", 3);
//        System.out.println(recipes);

        ShoppingApiService shoppingApiService = new ShoppingApiService();
        ApiShoppingList aisles = shoppingApiService.findMealplanner("7daae3490447427cb309d569b5f4990e","1297805", "baking powder");
        System.out.println(aisles);

//
//        RequestSpecification requestSpecification =
//                new RequestSpecBuilder()
//                        .build();

    }
}

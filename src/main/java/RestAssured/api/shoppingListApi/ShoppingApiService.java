package RestAssured.api.shoppingListApi;

import RestAssured.api.ApiSearchResult;
import RestAssured.api.RetrofitUtils;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShoppingApiService {

    private ShoppingApiService api;
    private static final String API_KEY = "7daae3490447427cb309d569b5f4990e";

    public ShoppingApiService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spoonacular.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ShoppingApiService.class);
//        ShoppingApi api = retrofit.create(ShoppingApi.class);
    }

    public ApiShoppingList findMealplanner( String apiKey, String id, String name) {
        Call<ApiShoppingList> call = (Call<ApiShoppingList>) api.findMealplanner(API_KEY,id, name);
        return RetrofitUtils.execute(call);
    }
}

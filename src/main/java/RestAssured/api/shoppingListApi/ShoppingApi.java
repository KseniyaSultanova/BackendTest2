package RestAssured.api.shoppingListApi;

import RestAssured.api.ApiSearchResult;
import RestAssured.api.ApiUserConnectRequest;
import RestAssured.api.ApiUserConnectResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ShoppingApi {
    @GET("/mealplanner/test1010}/shopping-list")
    Call<ApiSearchResult> findMealplanner(
            @Query("apiKey") String apiKey,
            @Query("id") Integer hash,
            @Query("name") String name


    );

    @POST("/users/connect")
    Call<ApiUserConnectResult> connect(@Body ApiUserConnectRequest request, @Query("apiKey") String apiKey);

}

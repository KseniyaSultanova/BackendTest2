package RestAssured.api;

import RestAssured.api.shoppingListApi.ApiShoppingList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


// POJO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiSearchResult extends ApiShoppingList {
    private List<ApiSearchResultItem> results;
    private Integer offset;
    private Integer number;
    private Integer totalResults;
}


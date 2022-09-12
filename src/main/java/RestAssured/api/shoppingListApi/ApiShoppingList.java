package RestAssured.api.shoppingListApi;

import RestAssured.api.ApiSearchResultItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiShoppingList {
    private List<ApiResultShoppingItem> aisles;
    private Integer cost;
    private Integer startDate;
    private Integer endDate;
}
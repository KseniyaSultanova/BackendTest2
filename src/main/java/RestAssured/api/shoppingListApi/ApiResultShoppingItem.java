package RestAssured.api.shoppingListApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResultShoppingItem {

    private String aisle;
    private Long id;
    private String name;
}


package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static config.Enviroment.BASE_URL;
import static io.restassured.RestAssured.given;

public class GetIngredients {
    private static final String PATH_GET_INGREDIENTS = "/api/ingredients";

    @Step("Get ingredients")
    public ValidatableResponse getIngredientsRequest() {
        return given()
                //  .log().all()
                .when()
                .get(BASE_URL + PATH_GET_INGREDIENTS)
                .then();
                //  .log().all();
    }
}

package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static config.Enviroment.baseURL;
import static io.restassured.RestAssured.given;

public class GetIngredients {
    private static final String pathGetIngredients = "/api/ingredients";

    @Step("Get ingredients")
    public ValidatableResponse getIngredientsRequest() {
        return given()
                //  .log().all()
                .when()
                .get(baseURL + pathGetIngredients)
                .then();
                //  .log().all();
    }
}

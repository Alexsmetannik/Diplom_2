package api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static config.Enviroment.baseURL;
import static io.restassured.RestAssured.given;

public class CreateOrder {
    private static final String pathCreate = "/api/orders";
    public String[] ingredients;

    public CreateOrder (String[] ingredients){
        this.ingredients = ingredients;
    }

    public CreateOrder() {
    }

    @Step("Create order")
    public ValidatableResponse createOrder(CreateOrder createOrder) {
        return given()
                //  .log().all()
                .contentType(ContentType.JSON)
                .body(createOrder)
                .when()
                .post(baseURL + pathCreate)
                .then();
                //  .log().all()
    }
}

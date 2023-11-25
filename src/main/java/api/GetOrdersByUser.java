package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static config.Enviroment.BASE_URL;
import static io.restassured.RestAssured.given;

public class GetOrdersByUser {
    private static final String PATH_GET_ORDERS = "/api/orders";

    @Step("Get orders by user")
    public ValidatableResponse getOrdersByUserRequest(String token) {
        return given()
                 // .log().all()
                .auth().oauth2(token)
                .when()
                .get(BASE_URL + PATH_GET_ORDERS)
                .then();
                 //.log().all();
    }
}

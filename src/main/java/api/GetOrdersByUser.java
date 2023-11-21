package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static config.Enviroment.baseURL;
import static io.restassured.RestAssured.given;

public class GetOrdersByUser {
    private static final String pathGetOrders = "/api/orders";

    @Step("Get orders by user")
    public ValidatableResponse getOrdersByUserRequest(String token) {
        return given()
                 // .log().all()
                .auth().oauth2(token)
                .when()
                .get(baseURL + pathGetOrders)
                .then();
                 //.log().all();
    }
}

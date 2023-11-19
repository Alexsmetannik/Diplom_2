package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static config.Enviroment.baseURL;
import static io.restassured.RestAssured.given;

public class GetOrdersByUser {
    private static final String pathGetOrders = "/api/order";

    @Step("Get orders by user")
    public ValidatableResponse getOrdersByUser() {
        return given()
                //  .log().all()
                .when()
                .get(baseURL + pathGetOrders)
                .then();
                //  .log().all()
    }
}

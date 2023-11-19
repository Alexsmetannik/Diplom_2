package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static config.Enviroment.baseURL;
import static io.restassured.RestAssured.given;

public class DeleteUser {
    private static final String pathDelete = "/api/auth/user";

    @Step("Delete user")
    public ValidatableResponse deleteUser() {
        return given()
                //  .log().all()
                .when()
                .delete(baseURL + pathDelete)
                .then();
                //  .log().all()
    }
}

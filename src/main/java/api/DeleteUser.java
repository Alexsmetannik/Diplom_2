package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static config.Enviroment.BASE_URL;
import static io.restassured.RestAssured.given;

public class DeleteUser {
    private static final String PATH_DELETE = "/api/auth/user";

    @Step("Delete user")
    public ValidatableResponse deleteUserRequest(String token) {
        return given()
                //  .log().all()
                .auth().oauth2(token)
                .when()
                .delete(BASE_URL + PATH_DELETE)
                .then();
                 // .log().all();
    }
}

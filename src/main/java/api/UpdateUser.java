package api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static config.Enviroment.baseURL;
import static io.restassured.RestAssured.given;

public class UpdateUser {
    private static final String pathUpdate = "/api/auth/user";
    public String email;
    public String password;
    public String name;

    public UpdateUser (String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public UpdateUser() {
    }

    @Step("Create user")
    public ValidatableResponse updateUser(UpdateUser updateUser) {
        return given()
                //  .log().all()
                .contentType(ContentType.JSON)
                .body(updateUser)
                .when()
                .patch(baseURL + pathUpdate)
                .then();
                //  .log().all()
    }
}

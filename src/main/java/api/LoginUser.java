package api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static config.Enviroment.baseURL;
import static io.restassured.RestAssured.given;

public class LoginUser {
    private static final String pathLogin = "/api/auth/login";
    public String email;
    public String password;

    public LoginUser (String email, String password){
        this.email = email;
        this.password = password;
    }

    public LoginUser() {
    }

    public static LoginUser from (CreateUser createUser) {
        return new LoginUser(createUser.getEmail(), createUser.getPassword());
    }

    @Step("Login user")
    public ValidatableResponse loginUserRequest(LoginUser loginUser) {
        return given()
                  .log().all()
                .contentType(ContentType.JSON)
                .body(loginUser)
                .when()
                .post(baseURL + pathLogin)
                .then()
                  .log().all();
    }
}

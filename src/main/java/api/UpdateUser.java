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

    public static UpdateUser from (CreateUser createUser) {
        return new UpdateUser(createUser.getEmail(), createUser.getPassword(), createUser.getName());
    }

    @Step("Update user")
    public ValidatableResponse updateUserRequest(UpdateUser updateUser, String token) {
        return given()
                 // .log().all()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(updateUser)
                .when()
                .patch(baseURL + pathUpdate)
                .then();
                // .log().all();
    }
}

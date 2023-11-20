package api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static config.Enviroment.baseURL;

public class CreateUser {
    private static final String pathCreate = "/api/auth/register";
    public String email;
    public String password;
    public String name;

    public CreateUser (String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public CreateUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Step("Create user")
    public ValidatableResponse createUserRequest(CreateUser createUser) {
        return given()
                 // .log().all()
                .contentType(ContentType.JSON)
                .body(createUser)
                .when()
                .post(baseURL + pathCreate)
                .then();
                 //.log().all();
    }
}

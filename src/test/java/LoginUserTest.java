import api.CreateUser;
import api.DeleteUser;
import api.LoginUser;
import generators.UserGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.*;
import static org.junit.Assert.*;

public class LoginUserTest {
    private CreateUser createUser;
    private CreateUser user;
    private LoginUser loginUser;
    private DeleteUser deleteUser;
    private String token;
    private String bearerToken;
    private final static String errorMessageIncorrectField = "email or password are incorrect";

    @Before
    public void beforeCreateUserTest(){
        createUser = new CreateUser();
        user = UserGenerator.getSuccessCreateUser();
        loginUser = new LoginUser();
    }

    @After
    public void deleteUser() {
        deleteUser = new DeleteUser();
        if(token != null){
            deleteUser.deleteUserRequest(token);
        }
    }

    @Test
    @DisplayName("Check to login an existing user")
    @Description("логин под существующим пользователем")
    public void loginExistingUserTest(){
        ValidatableResponse responseCreate = createUser.createUserRequest(user);
        bearerToken = responseCreate.extract().path("accessToken");
        token = bearerToken.substring(7);

        ValidatableResponse responseLogin = loginUser.loginUserRequest(loginUser.from(user));
        int actualStatusCode = responseLogin.extract().statusCode();
        Boolean isUserlogged = responseLogin.extract().path("success");
        assertEquals("StatusCode is not 200", SC_OK, actualStatusCode);
        assertTrue("User is not login", isUserlogged);
    }

    @Test
    @DisplayName("Check to login a user with invalid Email")
    @Description("логин с неверным логином")
    public void loginWithInvalidEmailTest(){
        ValidatableResponse responseCreate = createUser.createUserRequest(user);
        bearerToken = responseCreate.extract().path("accessToken");
        token = bearerToken.substring(7);

        user.setEmail("1234");
        ValidatableResponse responseLogin = loginUser.loginUserRequest(loginUser.from(user));
        int actualStatusCode = responseLogin.extract().statusCode();
        String actualMessage = responseLogin.extract().path("message");
        assertEquals("StatusCode is not 403", SC_UNAUTHORIZED, actualStatusCode);
        assertEquals("Message is not correct", errorMessageIncorrectField, actualMessage);
    }

    @Test
    @DisplayName("Check to login a user with invalid Password")
    @Description("логин с неверным паролем")
    public void loginWithInvalidPasswordTest(){
        ValidatableResponse responseCreate = createUser.createUserRequest(user);
        bearerToken = responseCreate.extract().path("accessToken");
        token = bearerToken.substring(7);

        user.setPassword("1234");
        ValidatableResponse responseLogin = loginUser.loginUserRequest(loginUser.from(user));
        int actualStatusCode = responseLogin.extract().statusCode();
        String actualMessage = responseLogin.extract().path("message");
        assertEquals("StatusCode is not 403", SC_UNAUTHORIZED, actualStatusCode);
        assertEquals("Message is not correct", errorMessageIncorrectField, actualMessage);
    }
}

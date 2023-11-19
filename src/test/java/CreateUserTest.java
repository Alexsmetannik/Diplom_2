import api.CreateUser;
import api.LoginUser;
import generators.UserGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.Before;

import static org.apache.http.HttpStatus.*;
import static org.junit.Assert.*;

public class CreateUserTest {

    private CreateUser createUser;
    private CreateUser user;
    private LoginUser loginUser;

    @Before
    public void beforeCreateUserTest(){
        createUser = new CreateUser();
        user = UserGenerator.getSuccessCreateUser();
        loginUser = new LoginUser();
    }
    /*
    @After
    public void deleteCourier() {
        ValidatableResponse responseDelete = createCourierRequest.deleteCourier(courierId);
    }

     */

    @Test
    @DisplayName("Check to create a unique user")
    @Description("создать уникального пользователя")
    public void createUniqueUserTest(){
        ValidatableResponse responseCreate = createUser.createUserRequest(user);
        /*
        int actualStatusCode = responseCreate.extract().statusCode();
        Boolean isUserCreated = responseCreate.extract().path("ok");
        ValidatableResponse responseLogin = loginUser.loginUser(loginUser.from(createUser));
        assertEquals("StatusCode is not 201", SC_CREATED, actualStatusCode);
        assertTrue("User is not created", isUserCreated);

         */
    }
}

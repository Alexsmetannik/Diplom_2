package generators;

import api.CreateUser;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;


public class UserGenerator {
    public static Faker faker = new Faker();

    public static CreateUser getSuccessCreateUser() {
        String email = faker.internet().emailAddress();
        String password = RandomStringUtils.randomAlphabetic(12);
        String name = faker.name().firstName();
        return new CreateUser(email, password, name);
    }
}

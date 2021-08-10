package utils.data;

import com.github.javafaker.Faker;
import models.User;
import java.util.Random;

public class TestDataGenerator {
    private static Faker faker = new Faker();

    public static User createNewUser() {
        return new User.Builder()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(generateNewEmail())
                .setPassword(faker.commerce().promotionCode())
                .setAddress(faker.address().streetAddress())
                .setCity(faker.address().city())
                .setState(faker.address().state())
                .setPostalCode(faker.number().digits(5))
                .setPhone(faker.phoneNumber().cellPhone())
                .build();
    }

    public static User getRegisteredUser() {
        return new User.Builder()
                .setFirstName("John")
                .setLastName("Wick")
                .setEmail("johnwickkiller@gmail.com")
                .setPassword("password")
                .setAddress("TestStreet")
                .setAddress("New York")
                .setState("New York")
                .setPostalCode("12345")
                .setPhone("+123456789")
                .build();
    }

     private static String generateNewEmail() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 7;
        Random random = new Random();
        return random
                .ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString() + "@gmail.com";
    }
}

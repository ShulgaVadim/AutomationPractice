package utils.data;

import com.github.javafaker.Faker;
import models.User;
import java.util.Random;

public class TestDataGenerator {
    private static Faker faker = new Faker();

    public static User createNewUser() {
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(generateNewEmail())
                .password(faker.commerce().promotionCode())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .state(faker.address().state())
                .postalCode(faker.address().zipCode())
                .phone(faker.phoneNumber().phoneNumber())
                .build();
    }

    public static User getRegisteredUser() {
        return User.builder()
                .firstName("John")
                .lastName("Wick")
                .email("johnwickkiller@gmail.com")
                .password("password")
                .address("TestStreet")
                .city("New York")
                .state("New York")
                .postalCode("12345")
                .phone("+123456789")
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

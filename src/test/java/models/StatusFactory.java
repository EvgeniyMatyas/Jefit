package models;

import com.github.javafaker.Faker;
public class StatusFactory {

    static Faker faker = new Faker();

    public static Status get() {
        return Status.builder()
                .statusText(faker.gameOfThrones().dragon())
                .build();
    }
}

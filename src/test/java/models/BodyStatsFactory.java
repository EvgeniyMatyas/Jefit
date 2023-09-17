package models;

import com.github.javafaker.Faker;

public class BodyStatsFactory {

    static Faker faker = new Faker();

    public static BodyStats get() {
        return BodyStats.builder()
                .weight(String.valueOf(faker.number().numberBetween(10,99)))
                .bodyFat(String.valueOf(faker.number().numberBetween(10,99)))
                .height(String.valueOf(faker.number().numberBetween(10,99)))
                .chest(String.valueOf(faker.number().numberBetween(10,99)))
                .waist(String.valueOf(faker.number().numberBetween(10,99)))
                .arms(String.valueOf(faker.number().numberBetween(10,99)))
                .shoulders(String.valueOf(faker.number().numberBetween(10,99)))
                .foreams(String.valueOf(faker.number().numberBetween(10,99)))
                .neck(String.valueOf(faker.number().numberBetween(10,99)))
                .hips(String.valueOf(faker.number().numberBetween(10,99)))
                .thighs(String.valueOf(faker.number().numberBetween(10,99)))
                .calves(String.valueOf(faker.number().numberBetween(10,99)))
                .build();
    }
}

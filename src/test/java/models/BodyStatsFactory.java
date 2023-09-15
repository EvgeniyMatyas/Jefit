package models;

import com.github.javafaker.Faker;

public class BodyStatsFactory {

    static Faker faker = new Faker();

    public static BodyStats get() {
        return BodyStats.builder()
                .weight(faker.number().digits(2))
                .bodyFat(faker.number().digits(2))
                .height(faker.number().digits(2))
                .chest(faker.number().digits(2))
                .waist(faker.number().digits(2))
                .arms(faker.number().digits(2))
                .shoulders(faker.number().digits(2))
                .foreams(faker.number().digits(2))
                .neck(faker.number().digits(2))
                .hips(faker.number().digits(2))
                .thighs(faker.number().digits(2))
                .calves(faker.number().digits(2))
                .build();
    }
}

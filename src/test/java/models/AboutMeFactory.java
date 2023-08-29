package models;

import com.github.javafaker.Faker;

public class AboutMeFactory {

    static Faker faker = new Faker();

    public static AboutMe get() {
        return AboutMe.builder()
                .Location(faker.address().city())
                .Occupation(faker.job().title())
                .Interests_Hobbies(faker.gameOfThrones().dragon())
                .Why_Do_You_Workout(faker.chuckNorris().fact())
                .How_Did_You_Start(faker.chuckNorris().fact())
                .What_Motivates_You(faker.chuckNorris().fact())
                .Main_Goal(faker.chuckNorris().fact())
                .Long_Term_Goals(faker.chuckNorris().fact())
                .Short_Term_Goals(faker.chuckNorris().fact())
                .Music(faker.music().genre())
                .Food(faker.food().fruit())
                .Supplements(faker.beer().name())
                .Exercises(faker.educator().secondarySchool())
                .Magazines(faker.internet().emailAddress())
                .Movies(faker.lebowski().actor())
                .build();
    }
}

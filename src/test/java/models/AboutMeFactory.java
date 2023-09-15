package models;

import com.github.javafaker.Faker;

public class AboutMeFactory {

    static Faker faker = new Faker();

    public static AboutMe get() {
        return AboutMe.builder()
                .location(faker.address().city())
                .occupation(faker.job().title())
                .interestsHobbies(faker.gameOfThrones().dragon())
                .whyDoYouWorkout(faker.chuckNorris().fact())
                .howDidYouStart(faker.chuckNorris().fact())
                .whatMotivatesYou(faker.chuckNorris().fact())
                .mainGoal(faker.chuckNorris().fact())
                .longTermGoals(faker.chuckNorris().fact())
                .shortTermGoals(faker.chuckNorris().fact())
                .music(faker.music().genre())
                .food(faker.food().fruit())
                .supplements(faker.beer().name())
                .exercises(faker.educator().secondarySchool())
                .magazines(faker.internet().emailAddress())
                .movies(faker.lebowski().actor())
                .build();
    }
}

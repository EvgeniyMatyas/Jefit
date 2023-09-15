package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AboutMe {

    String location;
    String occupation;
    String interestsHobbies;
    String whyDoYouWorkout;
    String howDidYouStart;
    String whatMotivatesYou;
    String mainGoal;
    String longTermGoals;
    String shortTermGoals;
    String music;
    String food;
    String supplements;
    String exercises	;
    String magazines;
    String movies	;
}

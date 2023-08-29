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

    String Location;
    String Occupation;
    String Interests_Hobbies;
    String Why_Do_You_Workout;
    String How_Did_You_Start;
    String What_Motivates_You;
    String Main_Goal;
    String Long_Term_Goals;
    String Short_Term_Goals;
    String Music;
    String Food;
    String Supplements;
    String Exercises	;
    String Magazines;
    String Movies	;
}

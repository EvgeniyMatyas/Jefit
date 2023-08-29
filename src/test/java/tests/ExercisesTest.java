package tests;

import org.testng.annotations.Test;
import pages.BodyPartPage;
import tests.base.BaseTest;
import static org.testng.Assert.*;

public class ExercisesTest extends BaseTest {

    @Test(description = "Open Shoulders exercise page")
    public void ShouldersExercisePageShouldBeOpenedTest(){
        loginPage.open()
                        .loginWithValidData();
        exercisesPage.openExercisePage();
        String exerciseName = exercisesPage.getBodyNameFromList();
        exercisesPage.clickBodyNameFromList();
//TODO
        assertEquals(exerciseName,bodyPartPage.getExerciseName(),"Shoulders Database page hasn't opened");

    }
}

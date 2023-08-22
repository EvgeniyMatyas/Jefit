package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ExercisesTest extends BaseTest {

    @Test
    public void openExercise(){
        loginPage.open()
                        .loginWithValidData();
        exercisesPage.open();
        String bodyName = exercisesPage.getBodyNameFromList();
        exercisesPage.clickBodyNameFromList();
        //TODO assert

    }
}

package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class WorkoutPlansTest extends BaseTest {

    @Test(description = "Open Workout Plans")
    public void openWorkoutPlans() {
        loginPage
                .open()
                .loginWithValidData();
        boolean isWorkoutPlansPageOpened = workoutPlansPage
                .openWorkoutPlans()
                .isPageOpen();

        assertTrue(isWorkoutPlansPageOpened, "Workout Plans page hasn't opened");
    }

}

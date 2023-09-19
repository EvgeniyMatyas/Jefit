package tests;

import models.BodyStats;
import models.BodyStatsFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class LogWorkoutTest extends BaseTest {

    @Test(description = "Create Body Stats")
    public void bodyStatsCreate() {
        loginPage
                .open()
                .loginWithValidData();

        BodyStats bodyStats = BodyStatsFactory.get();

        boolean isBodyStatsOpened = logWorkoutPage.open()
                .clickAddBodyStatsButton()
                .createBodyStats(bodyStats)
                .isPageOpen();

        assertTrue(isBodyStatsOpened, "Body Stats form hasn't opened");

        assertEquals(logWorkoutPage.getBodyStatsValue("Weight"), bodyStats.getWeight(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Body Fat"), bodyStats.getBodyFat(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Height"), bodyStats.getHeight(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Chest"), bodyStats.getChest(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Waist"), bodyStats.getWaist(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Arms"), bodyStats.getArms(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Shoulders"), bodyStats.getShoulders(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Foreams"), bodyStats.getForeams(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Neck"), bodyStats.getNeck(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Hips"), bodyStats.getHips(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Thighs"), bodyStats.getThighs(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Calves"), bodyStats.getCalves(), "The text doesn't match");

        logWorkoutPage.deleteBodyStats();

    }


    @Test(description = "Create Note")
    public void noteCreate() {
        loginPage
                .open()
                .loginWithValidData();
        logWorkoutPage.open()
                .clickNotesAddButton()
                .createNote();

        assertEquals(logWorkoutPage.returnNoteFakerText(), logWorkoutPage.getNoteText(), "The text doesn't match");

        logWorkoutPage.deleteNote();
    }

}



package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyRoutinesTest extends BaseTest {

    @Test(description = "Create Routine")
    public void createNewRoutine(){
        loginPage.open()
                .loginWithValidData();
        boolean routinePageIsOpened = myRoutinesPage.open()
                .clickCreateNewRoutineButton()
                .createNewRoutine()
                .isPageOpen();

        assertTrue(routinePageIsOpened, "Page is not opened");

        assertEquals(myRoutinesPage.getRoutineName(), myRoutinesPage.returnRoutineFakerText(), "The text doesn't match");

        myRoutinesPage.deleteRoutine();

    }

    @Test(description = "Delete Routine")
    public void routineShouldBeDeletedTest() {
        loginPage.open()
                 .loginWithValidData();
        myRoutinesPage.open()
                .clickCreateNewRoutineButton()
                .createNewRoutine()
                .deleteRoutine();

        assertEquals(myRoutinesPage.routineIsDeletedText(),
                "You have not setup a default routine yet. Please create one or set one as default routine"
                , "The text doesn't match");

    }
}

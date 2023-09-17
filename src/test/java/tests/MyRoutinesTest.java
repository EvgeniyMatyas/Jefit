package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyRoutinesTest extends BaseTest {

    @Test(description = "Create Routine")
    public void createNewRoutine() {
        loginPage
                .open()
                .loginWithValidData();

        boolean myRoutinesPageIsOpen = myRoutinesPage
                .open()
                .createRoutine()
                .isPageOpen();

        assertTrue(myRoutinesPageIsOpen, "Page is not opened");

        assertEquals(myRoutinesPage.getRoutineName(), myRoutinesPage.returnRoutineFakerText(), "The text doesn't match");

        myRoutinesPage.deleteRoutine();
    }

    @Test(description = "Delete Routine")
    public void deleteRoutine() {
        loginPage
                .open()
                .loginWithValidData();
        myRoutinesPage
                .open()
                .createRoutine()
                .deleteRoutine();

        assertEquals(myRoutinesPage.routineIsDeletedText(), "0/20 Routines Created", "The text doesn't match");

    }
}

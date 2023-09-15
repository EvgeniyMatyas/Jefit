package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl,email,password;

    protected LoginPage loginPage;
    protected MyJefitPage myJefitPage;
    protected ProfilEpicPage profilepicPage;
    protected ExercisesPage exercisesPage;
    protected BodyPartPage bodyPartPage;
    protected AboutMePage aboutMePage;
    protected UserPage userPage;
    protected MyLogsPage myLogsPage;
    protected WorkoutPlansPage workoutPlansPage;
    protected BlogPage blogPage;
    protected PopularPostPage popularPostPage;
    protected CategoryPage categoryPage;
    protected MyRoutinesPage myRoutinesPage;
    protected ElitePage elitePage;
    protected SettingsProfileAppPage settingsProfileAppPage;
    protected SettingsEmailPasswordPage settingsEmailPasswordPage;
    protected SettingsMembershipPage settingsMembershipPage;
    protected SettingsNotificationPrivacyPage settingsNotificationPrivacyPage;




    @Step("Setting up and opening the browser")
    @BeforeMethod
    public void setUp(ITestContext context){
        baseUrl = System.getenv().getOrDefault("JEFIT_URL", PropertyReader.getProperty("jefit.url"));
        email = System.getenv().getOrDefault("JEFIT_EMAIL", PropertyReader.getProperty("jefit.email"));
        password = System.getenv().getOrDefault("JEFIT_PASSWORD", PropertyReader.getProperty("jefit.password"));

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
 //       options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
 //       context.setAttribute("driver",driver);


        loginPage = new LoginPage(driver);
        myJefitPage = new MyJefitPage(driver);
        profilepicPage = new ProfilEpicPage(driver);
        exercisesPage = new ExercisesPage(driver);
        bodyPartPage = new BodyPartPage(driver);
        aboutMePage = new AboutMePage(driver);
        userPage = new UserPage(driver);
        myLogsPage = new MyLogsPage(driver);
        workoutPlansPage = new WorkoutPlansPage(driver);
        blogPage = new BlogPage(driver);
        popularPostPage = new PopularPostPage(driver);
        categoryPage = new CategoryPage(driver);
        myRoutinesPage = new MyRoutinesPage(driver);
        elitePage = new ElitePage(driver);
        settingsProfileAppPage = new SettingsProfileAppPage(driver);
        settingsEmailPasswordPage = new SettingsEmailPasswordPage(driver);
        settingsMembershipPage = new SettingsMembershipPage(driver);
        settingsNotificationPrivacyPage = new SettingsNotificationPrivacyPage(driver);



    }
    @Step("Closing the browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        driver.quit();
    }
}




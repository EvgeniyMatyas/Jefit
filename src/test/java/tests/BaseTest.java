package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import pages.MyJefitPage;
import pages.ProfilePage;
import pages.SingUpPage;
import tests.base.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)

public class BaseTest {
    WebDriver driver;
    SingUpPage singUpPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    MyJefitPage myJefitPage;



    @Step("Настройка и открытие браузера")
    @BeforeMethod
    public void setUp(ITestContext context){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        context.setAttribute("driver",driver);


        singUpPage = new SingUpPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        myJefitPage = new MyJefitPage(driver);



    }
    @Step("Закрытие браузера")
    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        driver.quit();
    }
}




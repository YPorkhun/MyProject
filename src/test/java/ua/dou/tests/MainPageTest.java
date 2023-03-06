package ua.dou.tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.dou.pages.MainPage;
import java.util.concurrent.TimeUnit;
public class MainPageTest {

    public ChromeDriver driver;
    private MainPage mainPage;

    @Before
    public void setUP () {
        System.setProperty("chromedriver.chrome.driver","C:\\Users\\Yuliia\\IdeaProjects\\MyProject\\src\\main\\resources\\");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        this.mainPage = new MainPage(this.driver);
    }

    @Test
    public void find_JOB_IN_DOU() {
        mainPage.openDOU();
        mainPage.openJOBS();
        mainPage.openVACANCIES();
        mainPage.searchQA();
        mainPage.clickSEARCHBUTTON();
        mainPage.filteringVACANCIES();
        mainPage.returnVACANCIES();
        mainPage.filteringIsWORK();
//        mainPage.clickOnSignInButton();
    }
    @After
    public void cleanUP () {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}

package ua.dou.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
        public static final String MAIN_URL = "https://dou.ua/";
        private ChromeDriver driver;
        @FindBy (xpath = "//a[@href='https://jobs.dou.ua/'][contains(text(),\"Робота\")]")
        private WebElement DOU_JOBS;
        @FindBy (xpath = "//a[@href='https://jobs.dou.ua/'][contains(text(),\"Вакансії\")]")
        private WebElement DOU_VACANCIES;
        @FindBy(xpath = "//input[@class='btn-search'][@type='submit']")
        private WebElement SEARCH_BUTTON;
        public MainPage (ChromeDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }

        public MainPage openDOU() {
            driver.navigate().to(MAIN_URL);
            return this;
        }

        public MainPage openJOBS() {
            DOU_JOBS.click();
            return this;
        }

        public MainPage openVACANCIES(){
             DOU_VACANCIES.click();
             return this;
        }

        public MainPage searchQA() {
            driver.findElement(By.xpath("//input[@class='job'][@type='text']")).sendKeys("QA");
            return this;
        }

        public MainPage clickSEARCHBUTTON() {
            SEARCH_BUTTON.click();
            return this;
        }

        public MainPage filteringVACANCIES () {
            driver.findElement(By.xpath("//div[@class='b-region-filter']//li//a[@href='https://jobs.dou.ua/vacancies/?search=QA&exp=1-3']")).click();
            driver.findElement(By.xpath("//div/div/ul[2]/li[5]/a")).click();
            return this;
        }

        public MainPage filteringIsWORK (){
            driver.findElement(By.xpath("//div[@class='b-region-filter']//li//a[@href='https://jobs.dou.ua/vacancies/?search=QA&exp=1-3']")).isSelected();
            driver.findElement(By.xpath("//div/div/ul[2]/li[5]/a")).isSelected();
            return this;
        }

        public MainPage returnVACANCIES () {
            driver.findElements(By.xpath("//li[@class='l-vacancy']"));
            return this;
        }
        public MainPage clickOnSignInButton () {
            driver.findElement(By.id("login-link")).click();
            driver.switchTo().frame("_loginDialog");
            return this;
        }
    }


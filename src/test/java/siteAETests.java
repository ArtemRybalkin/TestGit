import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.css.model.Value;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.concurrent.TimeUnit.*;

public class siteAETests {

    private static WebDriver driver;
    private final String aeoHomePage = "https://ae.com";
    private static WebDriverWait wait;
    private final String googleHomePage = "https://google.com";
    private final String Login = "ep27@e.com";
    private final String Password = "TestTest123";
    private final String polo = "polo";
    private final String email = "213453@efer.com";
    private final String firstName = "Artem";
    private final String lastName = "Artem";
    private final String streetAddressField = "streetAddress";
    private final String city = "City";
    private final String zip = "11111";
    private final int states = 8;

    private Value Value;

    @BeforeClass
    public static void preCondition() {

        System.setProperty("webdriver.chrome.driver", "/Users/arybalkin/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().maximize();
        wait = (new WebDriverWait(driver, 10 ));
    }

    private static void visitUrl(String url) {
        driver.navigate().to(url);
    }

    private static boolean clickSafely (WebElement element) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                element.click();
                result = true;
                break;
            } catch(Exception e) {
            }
            attempts++;
        }
        return result;
    }


    private static void setCheckBoxes() {
        WebElement buttonBrend = driver.findElement(By.xpath("//div[@aria-label='side brand']"));
        buttonBrend.click();
        WebElement checkBoxAE = driver.findElement(By.xpath("//label[text()='AE']"));
        checkBoxAE.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement checkBoxAerie = driver.findElement(By.xpath("//label[text()='Aerie']"));
        wait.until(ExpectedConditions.visibilityOf(checkBoxAerie));
        clickSafely(checkBoxAerie);
    }

    @Test
    public void testLoginPage () {
        visitUrl(aeoHomePage);
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookie();
        driver.findElement(By.xpath("//button[@class='close-button btn-cancel qa-btn-cancel']")).click();
        mainPage.logIn(Login, Password);
        driver.findElement(By.xpath("//button[@class='btn-close qa-btn-cancel']")).click();
        WebElement accountSignoutButton = driver.findElement(By.xpath("//button[@class='btn btn-secondary    btn-sign-out']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[@class='btn btn-secondary    btn-sign-out']"))));
        String text = driver.findElement(By.xpath("//div[@class='modal-header']//h2")).getText();
        Assert.assertTrue(text.contains("Eugene'S Account"));
        Assert.assertTrue(accountSignoutButton.isEnabled());
        driver.quit();
    }

    @Test
    public void buySmthng() {
        visitUrl(aeoHomePage);
        MainPage mainPage = new MainPage(driver);
        ResultSearchPage resultSearchPage = new ResultSearchPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CartPage cartPage = new CartPage(driver);
        mainPage.acceptCookie();
        mainPage.sendQuery(polo);
        ResultSearchPage.clickBrandButton();
        ResultSearchPage.clickBrandAerieButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='__6cafc results-list qa-results-list']//div[1]")));
        ResultSearchPage.clickFirstProduct();
        productPage.setSize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dropdown-toggle qa-dropdown-toggle']")));
        productPage.addToBag();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='viewBag']")));
        productPage.viewBag();
        cartPage.clickCheckoutButton();
        checkoutPage.setShippingInfo(email, firstName, lastName, streetAddressField, city, zip, states);

    }





 }

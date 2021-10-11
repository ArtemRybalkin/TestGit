import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.utilities.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainPage {

    private WebDriver driver;
    private static Date dateNow;
// added constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private static WebDriverWait wait;
   private By acceptCookie = By.xpath("//button[@name='accept-cookie']");
   private By searchButton = By.xpath("//a[@class='clickable qa-show-sidetray-search sidetray-search']");
   private By logInButton = By.xpath("//a[@class='clickable qa-show-sidetray-account sidetray-account']");
   private By basketButton = By.xpath("//a[@class='ember-view bag-button underline-on-hover qa-tnav-bag-icon __fa246']");
   private By searchField = By.xpath("//input[@name='search']");
   private By searchButtonSideBar = By.xpath("//button[@class='btn-link    btn search-btn']");
   private By searchMessageElement = By.xpath("//span[@class='search-message']");
   private By accountPageSigInButton = By.xpath("//button[@name='signin']");
   private By signInPageEmailField = By.xpath("//input[@name='username']");
   private By signInPagePasswordField = By.xpath("//input[@name='password']");
   private By signInPageSigInButton = By.xpath("//button[@name='login']");


    public static boolean clickSafely (WebElement element) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 5) {
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


    public void logIn (String login, String password) {
        driver.findElement(logInButton).click();
        driver.findElement(accountPageSigInButton).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@name='username']"))));
        driver.findElement(signInPageEmailField).sendKeys(login);
        driver.findElement(signInPagePasswordField).sendKeys(password);
        driver.findElement(signInPageSigInButton).click();

    }
   public void acceptCookie() {
       driver.findElement(acceptCookie).click();
   }

   public void sendQuery(String query) {
       driver.findElement(searchButton).click();
       driver.findElement(searchField).sendKeys(query);
       driver.findElement(searchButtonSideBar).click();

   }
    public String getSearchMessage() {
     return    driver.findElement(searchMessageElement).getText().replaceAll("\\d+\\d", "xx");
    }


    public void getScreenShot() {
        dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String  fileName = format.format(dateNow) + ".png";

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("/Users/arybalkin/Desktop/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

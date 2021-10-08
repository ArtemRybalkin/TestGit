import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.concurrent.TimeUnit.*;

public class seleniumTestCheckbox {

    private static WebDriver driver;
    private final String aeoHomePage = "https://ae.com";
    private final String googleHomePage = "https://google.com";
    private final String polo = "polo";
    private final String dress = "dress";

    @BeforeClass
    public static void preCondition() {
        System.setProperty("webdriver.chrome.driver", "/Users/arybalkin/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
        driver.manage().window().maximize();
    }

    private static void visitUrl(String url) {
        driver.navigate().to(url);

    }
    private static boolean clickSafely (WebElement element) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 10) {
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
    private static void performSearch(String query) {
        driver.findElement(By.xpath("//button[@name='accept-cookie']")).click();
        WebElement searchButtonMain = driver.findElement(By.xpath("//a[@class='clickable qa-show-sidetray-search sidetray-search']"));
        searchButtonMain.click();
        WebElement searchField = driver.findElement(By.xpath("//input[@name='search']"));
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);
    }
    private static String searchMessage() {
        WebElement sMessage = driver.findElement(By.xpath("//self::span[@class='search-message']"));
        String sMessageText = sMessage.getText().replaceAll("\\d+\\d", "xx").substring(0,23);

        return sMessageText;
    }
    private static String searchMessageQuery() {
        WebElement sMessageQuery = driver.findElement(By.xpath("//span[@class='search-message']/strong"));
        String sMessageQueryText = sMessageQuery.getText();
//        System.out.println(sMessageQueryText);
        return sMessageQueryText;
    }

    private static void setCheckBoxes() {
        WebElement buttonBrend = driver.findElement(By.xpath("//div[@aria-label='side brand']"));
        buttonBrend.click();

        WebElement checkBoxAE = driver.findElement(By.xpath("//label[text()='AE']"));
        checkBoxAE.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement checkBoxAerie = driver.findElement(By.xpath("//label[text()='Aerie']"));
        wait.until(ExpectedConditions.visibilityOf(checkBoxAerie));
        clickSafely(checkBoxAerie);
    }

    @Test
    public void testPoloSearch() {
        visitUrl(aeoHomePage);
        performSearch(dress);
        searchMessage();
//        setCheckBoxes();

        Assert.assertEquals(searchMessage() + searchMessageQuery(),"We found xx results for"+ searchMessageQuery());
//        Assert.assertFalse(1 == 2);
    }


    public static void main(String[] args) {


        WebElement radioButtonOnlineOnly = driver.findElement(By.xpath("//label[text()='Online Only']"));
//        radioButtonOnlineOnly.click();
//        selectCheckBox("Online Only");
//        deSelectCheckBox("Online Only", "Newest");


        setCheckBoxes();
        WebElement checkBoxOFFLINE = driver.findElement(By.xpath("//label[text()='OFFLINE']"));
//        checkBoxOFFLINE.click();
//        selectCheckBox("Aerie");
//        selectCheckBox("OFFLINE");
        System.out.println();
        System.out.println(driver.findElement(By.xpath("//input[@name='Online Only']")).isSelected());
//        System.out.println(radioButtonOnlineOnly.isEnabled());
    }




    public static void selectCheckBox(String name1) {
        String chbXpath = "//input[@name='%s']";
        String chbXpath1 = "//label[text()='%s']";
//        System.out.println(driver.findElement(By.xpath(String.format(chbXpath, name1))).isSelected());
        if (!driver.findElement(By.xpath(String.format(chbXpath, name1))).isSelected())
            driver.findElement(By.xpath(String.format(chbXpath1, name1))).click();
    }

    public static void deSelectCheckBox(String name1, String name2) {
        String chbXpath = "//input[@name='%s']";
        String chbXpath1 = "//label[text()='%s']";
//        System.out.println(driver.findElement(By.xpath(String.format(chbXpath, name1))).isSelected());
        if (driver.findElement(By.xpath(String.format(chbXpath, name1))).isSelected())
            driver.findElement(By.xpath(String.format(chbXpath1, name2))).click(); //не выполнятеся, т.к. появляеться ошибка stale element, необходимо добавить ожидание

    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;

public class ResultSearchPage {
    private static WebDriver driver;

    // added constructor
    public ResultSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private static By filterBrandButton = By.xpath("//span[text()='Brand']");
    private By brandAEButton = By.xpath("//li[@aria-label='ae filter']//label");
    private static By brandAerieButton = By.xpath("//li[@aria-label='aerie filter']//label");
    private By brandOFFLINEButton = By.xpath("//li[@aria-label='OFFLINE filter']//label");

    private static final By firstProduct = By.xpath("//div[@class='__6cafc results-list qa-results-list']//div[1]");

    public static void clickBrandButton() {
        driver.findElement(filterBrandButton).click();

    }
    public void clickBrandAEButton () {
        driver.findElement(brandAEButton).click();
    }
    public static void clickBrandAerieButton() {
        WebElement element = driver.findElement(brandAerieButton);
        MainPage.clickSafely(element);
    }
    public void clickBrandOFFLINEButton () {
        driver.findElement(brandOFFLINEButton).click();
    }
    public static void clickFirstProduct() {
        WebElement element = driver.findElement(firstProduct);
        MainPage.clickSafely(element);
    }

}

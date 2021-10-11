import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class ProductPage {

    private WebDriver driver;
    private static Date dateNow;
    // added constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

   private By sizeField = By.xpath("//div[@class='dropdown-toggle qa-dropdown-toggle']");
    private By sizeXXS = By.xpath("//div[@aria-label='Size']//following::ul[1]//a[text()='XXS']");
    private By sizeXS = By.xpath("//div[@aria-label='Size']//following::ul[1]//a[text()='XS']");
    private By sizeS = By.xpath("//div[@aria-label='Size']//following::ul[1]//a[text()='S']");
    private By sizeM = By.xpath("//div[@aria-label='Size']//following::ul[1]//a[text()='M']");
    private By sizeL = By.xpath("//div[@aria-label='Size']//following::ul[1]//a[text()='L']");
    private By sizeXL = By.xpath("//div[@aria-label='Size']//following::ul[1]//a[text()='XL']");
    private By buttonAddToBag = By.xpath("//button[@name='addToBag']");
    private By buttonViewBag = By.xpath("//button[@name='viewBag']");

    public void setSize() {
        driver.findElement(sizeField).click();
        driver.findElement(sizeM).click();
    }

    public void addToBag() {
        driver.findElement(buttonAddToBag).click();

    }
    public void viewBag() {
        driver.findElement(buttonViewBag).click();
    }


}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {
    private WebDriver driver;

    // added constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.xpath("//input[@name='email']");
    private By firstNameField = By.xpath("//input[@name='firstname']");
    private By lastNameField = By.xpath("//input[@name='lastname']");
    private By streetAddressField = By.xpath("//input[@name='streetAddress']");
    private By cityField = By.xpath("//input[@name='city']");
    private By postalCodeField = By.xpath("//input[@name='postalCode']");
    private By statesField = By.xpath("//select[@name='states']");

   public void setShippingInfo (String email, String firstname, String lastname, String streetadress, String city, String
                                zip, int state) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(firstNameField).sendKeys(firstname);
        driver.findElement(lastNameField).sendKeys(lastname);
        driver.findElement(streetAddressField).sendKeys(streetadress);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(postalCodeField).sendKeys(zip);
       List<WebElement> states = driver.findElements(By.xpath("//select[@name='states']//option"));
       states.get(state).click();

   }

    public void setState() {
     List<WebElement> states = driver.findElements(By.xpath("//select[@name='states']//option"));
     states.get(3).click();
    }
}

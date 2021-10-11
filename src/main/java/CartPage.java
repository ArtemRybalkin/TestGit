import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class CartPage {
    private WebDriver driver;

    // added constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    private By numberOfItems = By.xpath("//h2[@class='commerce-items-qty-msg qa-commerce-items-qty-msg text-capitalize']");
    private By checkoutButton = By.xpath("//button[@class='btn btn-colored-blue    btn-block btn-go2checkout qa-btn-go2checkout']");

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }


}

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class seleniumTestCheckbox {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/arybalkin/Downloads/chromedriver");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://ae.com");

        driver.findElement(By.xpath("//button[@name='accept-cookie']")).click();
        WebElement searchButtonMain = driver.findElement(By.xpath("//a[@class='clickable qa-show-sidetray-search sidetray-search']"));
        searchButtonMain.click();
        WebElement searchField = driver.findElement(By.xpath("//input[@name='search']"));
        searchField.sendKeys("Chill");
        searchField.sendKeys(Keys.ENTER);

        WebElement radioButtonOnlineOnly = driver.findElement(By.xpath("//label[text()='Online Only']"));
        radioButtonOnlineOnly.click();

        WebElement buttonBrend = driver.findElement(By.xpath("//span[text()='Brand']"));
        buttonBrend.click();

       WebElement checkBoxAE = driver.findElement(By.xpath("//input[@name='AE']"));
       WebElement checkBoxAerie = driver.findElement(By.xpath("//input[@name='Aerie']"));
       WebElement checkBoxOFFLINE = driver.findElement(By.xpath("//input[@name='OFFLINE']"));

       checkBoxAE.click();
       checkBoxAerie.click();
       checkBoxOFFLINE.click();
        System.out.println();
        System.out.println(driver.findElement(By.xpath("//input[@name='Online Only']")).isSelected());
        System.out.println(radioButtonOnlineOnly.isEnabled());
    }

//    public static void selectCheckBox (String name) {
//        String chbXpath = "//label[text()='§s']";
//        if (!driver.findElement(By.xpath(String.format(chbXpath, name))).isSelected())
//            driver.findElement(By.xpath(String.format(chbXpath, name))).click();
//    }
}

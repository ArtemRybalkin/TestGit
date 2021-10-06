import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class seleniumTestSearch {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/arybalkin/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://ae.com");

        driver.findElement(By.xpath("//button[@name='accept-cookie']")).click();
        WebElement searchButtonMain = driver.findElement(By.xpath("//a[@class='clickable qa-show-sidetray-search sidetray-search']"));
        searchButtonMain.click();
        WebElement searchField = driver.findElement(By.xpath("//input[@name='search']"));
        searchField.sendKeys("Chill");
        driver.findElement(By.xpath("//button[@class='btn-link     btn search-btn']")).submit();
        driver.findElement(By.xpath("//button[@aria-label='close']")).click();

        searchButtonMain.click();
//        System.out.println(searchField.getAttribute("placeholder"));
        driver.findElement(By.xpath("//*[@id='modal-ember858']/div/div[2]/form/div/span")).click();
//        searchField.clear();

//        WebElement serchField = driver.findElement(By.xpath("//h2[@class='modal-title']"));
//        if (serchField.getText().equals("Search")) {
//            System.out.println("Success!");
//        }
//        else {
//            System.out.println("Fail!");
//        }

//        driver.quit();
    }
}

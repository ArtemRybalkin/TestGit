import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/arybalkin/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(500,1000));
        driver.get("https://google.com");
        driver.navigate().to("https://ae.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        //driver.quit();
    }
}

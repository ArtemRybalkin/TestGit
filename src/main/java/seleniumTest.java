import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/arybalkin/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
    }
}

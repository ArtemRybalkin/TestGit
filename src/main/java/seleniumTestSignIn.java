import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class seleniumTestSignIn {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/arybalkin/Downloads/chromedriver");

        WebDriver webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();

        webdriver.navigate().to("https://ae.com");
        WebElement cookie = webdriver.findElement(By.xpath("//button[@name='accept-cookie']"));
        cookie.click();
        WebElement accountIcon = webdriver.findElement(By.xpath(" //a[@class='clickable qa-show-sidetray-account sidetray-account']"));
        accountIcon.click();
        WebElement signInButton = webdriver.findElement(By.xpath("//div[@class='btn-actions']/button"));
        signInButton.click();
//        webdriver.manage().wait(1);
        WebElement email = webdriver.findElement(By.xpath("//div[@class='login-form-input']//input[@type='email']"));
        WebElement password = webdriver.findElement(By.xpath("//div[@class='login-form-input']//input[@type='password']"));
//        добавить ожидание, страница не успевать прогрузиться
        email.sendKeys("qdewf1111er@google.com");
        password.sendKeys("111111");
        WebElement submit = webdriver.findElement(By.xpath("//div[@class='login-form-input']//button[@name='login']"));

        submit.click();
        System.out.println(password.getAttribute("value"));



    }
}

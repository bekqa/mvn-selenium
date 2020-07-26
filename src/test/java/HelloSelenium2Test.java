import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class HelloSelenium2Test {
    String url = "http://www.saucedemo.com/";

    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void smarterTest(){
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.quit();
    }
}

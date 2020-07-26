import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumTest {
    String url = "http://www.saucedemo.com/";

    @Test
    public void firstTest(){
        System.setProperty("webdrive.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.quit();
    }
}

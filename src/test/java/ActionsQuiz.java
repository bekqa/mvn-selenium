import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ActionsQuiz {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void dropDownTest(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        element = driver.findElement(By.id("dropdown"));
        element.click();
        WebElement option1 = driver.findElement(By.cssSelector("option[value='1']"));
        WebElement option2 = driver.findElement(By.cssSelector("option[value='2']"));
        option1.click();
        assertTrue(option1.isSelected());
        assertFalse(option2.isSelected());
    }

    @Test
    public void hover(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

        element = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
        assertTrue("name: user2",element.isDisplayed());//string must be exactly as in element
    }
}
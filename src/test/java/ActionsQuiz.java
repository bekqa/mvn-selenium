import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

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

    @Test
    public void rightClick()
    {
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        driver.switchTo().alert().accept();
    }

    @Test
    public void keyPresses() {
        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
        element = driver.findElement(By.id("target"));
        element.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
            element = driver.findElement(By.id("result"));
            assertEquals("Clicked right arrow key","Correct", element.getText());
    }
    @Test
    public void getCSSValue() {
        //Get the href attribute from the Clickable Icon element
        driver.navigate().to("https://ultimateqa.com/simple-html-elements-for-automation/");
        element = driver.findElement(By.linkText("Clickable Icon"));
        String link = element.getAttribute("href");
        assertEquals("https://www.google.com/", link);
        assertEquals("padding-box", element.getCssValue("background-origin"));
    }
}
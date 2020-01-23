import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class FireFox {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void rega() throws NullPointerException {
        driver.get("https://credithub.ru/podbor-kredita");
        driver.manage().window().setSize(new Dimension(1174, 1040));
        driver.findElement(By.id("agree_with_terms")).click();
        driver.findElement(By.id("agree_with_terms")).click();
        driver.findElement(By.id("agree_with_terms")).click();
        driver.close();
    }
}

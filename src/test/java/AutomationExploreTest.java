import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import java.util.List;

public class AutomationExploreTest {
    @Test
    public void testRegistration() {
        System.setProperty("webdriver.chrome.driver","C:/Users/yevhe/University/Web Drivers/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://automationexplore.com/selenium-automation-practice-page");

        driver.findElement(By.id("firstname")).sendKeys("TestName");
        driver.findElement(By.id("lastname")).sendKeys("TestLastName");
        driver.findElement(By.id("email")).sendKeys(randomAlphanumericStringGenerator().toLowerCase() + "@gmail.com");

        List<WebElement> radioList = driver.findElements(By.name("gender"));
        radioList.get(ThreadLocalRandom.current().nextInt(0, radioList.size())).click();

        tickCheckbox(driver.findElement(By.name("Student")));
        tickCheckbox(driver.findElement(By.name("working")));
        tickCheckbox(driver.findElement(By.name("freelancer")));

        new Select(driver.findElement(By.name("country"))).selectByVisibleText("USA");
        Select multipleSelect = new Select(driver.findElement(By.name("skills")));
        multipleSelect.selectByValue("MT");
        multipleSelect.selectByValue("ET");

        driver.quit();
    }

    public String randomAlphanumericStringGenerator() {
        return RandomStringUtils.random(15, true, true);
    }

    public void tickCheckbox(WebElement webElement) {
        if (new Random().nextBoolean()) {
            webElement.click();
        }
    }
}

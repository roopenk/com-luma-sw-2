package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    } // Opening the browser

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Applying click on the SignIn link
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        // Entering the Valid Email
        driver.findElement(By.id("email")).sendKeys("rockpopone@rediffmail.com");
        // Entering the Valid Password
        driver.findElement(By.id("pass")).sendKeys("Wonderful123");
        // Applying click on SignIn button
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        String expectedMessage = "Welcome, Aniruddh Shrivastav!";
        WebElement actualText = driver.findElement(By.xpath("//span[text()='Welcome, Aniruddh Shrivastav!']"));
        String actualMessage = actualText.getText();
        Assert.assertEquals("Unexpected Page Flow...!!!", expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        // Applying click on the SignIn link
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        // Entering the Valid Email
        driver.findElement(By.id("email")).sendKeys("rockpopone@rediffmail.com");
        // Entering the Valid Password
        driver.findElement(By.id("pass")).sendKeys("Wonderful");
        // Applying click on SignIn button
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        String expectedMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement actualText = driver.findElement(By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']"));
        String actualMessage = actualText.getText();
        Assert.assertEquals("Unexpected Page Flow...!!!", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        // Applying click on the SignIn link
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        // Entering the Valid Email
        driver.findElement(By.id("email")).sendKeys("rockpopone@rediffmail.com");
        // Entering the Valid Password
        driver.findElement(By.id("pass")).sendKeys("Wonderful123");
        // Applying click on SignIn button
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        String expectedMessage = "Welcome, Aniruddh Shrivastav!";
        WebElement actualText = driver.findElement(By.xpath("//span[text()='Welcome, Aniruddh Shrivastav!']"));
        String actualMessage = actualText.getText();
        Assert.assertEquals("Unexpected Page Flow...!!!", expectedMessage, actualMessage);
        // Applying click on down arrow near the "Welcome" text and applying click on "Sign out" option
        driver.findElement(By.xpath("//button[@class='action switch'][@tabindex='-1']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
        String expMessage = "You are signed out";
        WebElement actText = driver.findElement(By.xpath("//span[text()='You are signed out']"));
        String actMessage = actText.getText();
        Assert.assertEquals("Unexpected Page Flow...!!!", expMessage, actMessage);

    }

    @After
    public void cutOff() {
        closeBrowser();
    } // Closing the browser
}

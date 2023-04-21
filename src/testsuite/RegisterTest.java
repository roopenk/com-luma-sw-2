package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    } // Opening the browser

    @Test // Method to Locate create account link and verifying the create account message
    public void verifyThatSignInPageDisplay() {
        // Locating the "Create an Account" link and applying click on it
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();
        // Verifying the "Create New Customer Account" message
        String expectedMessage = "Create New Customer Account";
        WebElement actualText = driver.findElement(By.xpath("//span[text()='Create New Customer Account']"));
        String actualMessage = actualText.getText();
        Assert.assertEquals("Invalid Page Displayed....!!!", expectedMessage, actualMessage);
    }

    public static String getRandomEmail() { // Method to generate the Random Email ID everytime
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder random = new StringBuilder();
        Random rnd = new Random();
        while (random.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            random.append(chars.charAt(index));
        }
        String email = random.toString() + "@gmail.com";
        return email;
    }

    @Test // Method to Register user account
    public void userShouldRegisterAccountSuccessfully() {
        // Locating the "Create an Account" link and applying click on it
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();
        // Entering the First name
        driver.findElement(By.id("firstname")).sendKeys("Roopen");
        // Entering the Last name
        driver.findElement(By.id("lastname")).sendKeys("Patel");
        // Clicking on the Newsletter sign up check box
        driver.findElement(By.id("is_subscribed")).click();
        // Generating random Email ID every time of registration
        driver.findElement(By.id("email_address")).sendKeys(getRandomEmail());
        // Entering the Password
        driver.findElement(By.id("password")).sendKeys("WonderfulPassword123");
        // Confirming Password
        driver.findElement(By.id("password-confirmation")).sendKeys("WonderfulPassword123");
        // Applying click on Create an account button
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
        // Message confirmation
        String expectedMessage = "Thank you for registering with Main Website Store.";
        WebElement actualText = driver.findElement(By.xpath("//div[text()='Thank you for registering with Main Website Store.']"));
        String actualMessage = actualText.getText();
        Assert.assertEquals("Invalid Page Flow...!!!", expectedMessage, actualMessage);
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

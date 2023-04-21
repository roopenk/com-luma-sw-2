package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    } // Opening the browser

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        // Applying click on Sale Menu
        driver.findElement(By.xpath("//span[text()='Sale']")).click();
        // Applying click on Jackets option
        driver.findElement(By.xpath("//a[text()='Jackets']")).click();
        // Verifying "Jackets" text is displayed or not
        String expectedMessage = "Jackets";
        WebElement actualText = driver.findElement(By.id("page-title-heading"));
        String actualMessage = actualText.getText();
        Assert.assertEquals("Invalid Page Flow...!!!", expectedMessage, actualMessage);
        String expectedNumberOfItems = driver.findElement(By.id("toolbar-amount")).getText(); // Total number of displayed items
        List<WebElement> jackets = driver.findElements(By.xpath("//div[@class='products wrapper grid products-grid']/ol/li[contains(@class,'item product')]//div[@class='product details product-item-details']//a[@class='product-item-link']"));//Getting list of products displayed
        String actualTotalItems = jackets.size() + " Items";// Getting actual number of products
        for (WebElement a : jackets) { // Iterating the list and printing titles of each element
            System.out.println(a.getText());
            Assert.assertEquals("Total Number Of Items Displayed Has Mismatched.", expectedNumberOfItems, actualTotalItems); // Validating expected and actual text
        }
    }

    @After
    public void cutOff() {
        closeBrowser();
    } // Closing the browser
}

